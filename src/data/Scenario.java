package data;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author mamamiyear
 * @date 15-9-15
 */

public class Scenario extends DefaultTreeElement {


    public String ID;
    public String NAME;
    public List<Condition> CONDITIONS;
    public List<Releation> RELEATIONS;


    @Override
    public ElementType getElementType() {
        return ElementType.SCENARIOS;
    }

    @Override
    public int getElementID(ElementType type) {
        int res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS: res = Integer.parseInt(OBJID); break;
            case FDR:break;
            case MSG_TRACK:break;

        }
        return res;
    }

    @Override
    public String getElementName() {
        return NAME;
    }




    /**
     * 剧本 的内部类 剧本条件
     */
    public static class Condition {

        public String PERFORMMSGTIME;
        public List<MSGPARAM> MSGPARAMS;
        public String TRACK;

        public void extract(StringBuilder builder, String result) {
            appendPair(builder, "BEGIN", "CONDITION", result);
            appendPair(builder, "PERFORMMSGTIME", PERFORMMSGTIME);
            int index = 1;
            for (MSGPARAM msgparam : MSGPARAMS) {
                msgparam.extract(builder, String.valueOf(index++));
            }
            appendPair(builder, "TRACK", TRACK);
            appendPair(builder, "END", "CONDITION", result);
        }

        /*
         * 剧本条件 的内部类 条件参数
         */
        public static class MSGPARAM {

            public String MSGTYPE;
            public String MSGCONDITION;
            public String MSGSNDTIME;
            public String MSGGENPARAM;
            public String MSGEXCEPTION;
            public String MSGADDRESS;

            public void extract(StringBuilder builder, String result) {
                appendPair(builder, "BEGIN", "MSG", result);
                for (Field field : MSGPARAM.class.getDeclaredFields()) {
                    appendField(builder, MSGPARAM.this, field);
                }
                appendPair(builder, "END", "MSG", result);
            }
        }

    }

    /**
     * 剧本 的内部类 元素关系
     */
    public static class Releation {

        String releationName;
        String conditionName;
        List<String> conditonElements;

        public Releation(String RELEATION, int index) {



        }

        public String extract(String result) {
            return ""; //TODO
        }
    }


    public void removeElement(TreeElement childToRemove) {
        super.removeElement(childToRemove);
        if (childToRemove.getElementType() == ElementType.FDR) {
            if(elementMap.containsKey(childToRemove.getElementID(ElementType.FDR))){
                for (int i = 0; i < childToRemove.getChildCount(); i++) {
                    TreeElement element = (TreeElement) childToRemove.getChildAt(i);
                    if(Scene.MAPPING.containsKey(element.elementHash()))
                        Scene.MAPPING.remove(element.elementHash());
                }
            }
        }
    }


    @Override
    public String extract(String result) {
        StringBuilder builder = new StringBuilder();
        appendPair(builder, "BEGIN", "SCENARIO");
        Field[] fields = Scenario.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (List.class.isAssignableFrom(field.get(this).getClass())) continue;
                appendField(builder, this, field);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        extractConditions(builder);
        extractRelations(builder);
        appendPair(builder, "END", "SCENARIO");
        return super.extract(builder.toString());
    }

    private void extractConditions(StringBuilder builder) {
        appendPair(builder, "BEGIN", "CONDITIONS");
        int index = 1;
        for (Condition condition : CONDITIONS) {
            condition.extract(builder, String.valueOf(index++));
        }
        appendPair(builder, "END", "CONDITIONS");
    }

    private void extractRelations(StringBuilder builder) {
        appendPair(builder, "BEGIN", "RELEATIONS");
        int index = 1;
        for (Releation releation : RELEATIONS) {
            builder.append(releation.extract(String.valueOf(index++)));
        }
        appendPair(builder, "END", "RELEATIONS");
    }

    public static void main(String[] args) {
        System.out.println(new Scenario().extract(""));
    }
}
