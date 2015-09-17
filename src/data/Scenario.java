package data;

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

    @Override
    public void addElement(TreeElement newChild) {
        super.addElement(newChild);
        if(newChild.getElementType() == ElementType.FDR) {
            int fdrID = newChild.getElementID(ElementType.FDR);
            Scene.FDR_SCENARIO_MAPPING.put(fdrID, getElementID(getElementType()));
        }
    }

    @Override
    public void removeElement(TreeElement childToRemove) {
        super.removeElement(childToRemove);
        if(childToRemove.getElementType() == ElementType.FDR) {
            Scene.FDR_SCENARIO_MAPPING.remove(childToRemove.getElementID(ElementType.FDR));
        }
    }

    /**
     * 剧本 的内部类 剧本条件
     */
    public static class Condition {

        public String PERFORMMSGTIME;
        public List<MSGPARAM> MSGPARAMS;
        public String TRACK;

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

    }
}
