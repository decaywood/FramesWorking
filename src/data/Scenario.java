package data;

import java.util.ArrayList;
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
            case MSG:break;
            case TRACK:break;

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

        /*
         * 剧本条件 的内部类 条件参数
         */
        public class MSGPARAM {

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

        public Releation(String RELEATION) {

            conditonElements = new ArrayList<String>();
            releationName = RELEATION.substring(0, RELEATION.indexOf("="));
            conditionName = RELEATION.substring(RELEATION.indexOf("=") + 1, RELEATION.indexOf(":"));
            String[] stringElements;
            stringElements = RELEATION.substring(RELEATION.indexOf(":") + 1).trim().split(" ");
            for (int i = 0; i < stringElements.length; i++) {
                conditonElements.add(stringElements[i]);
            }

        }

    }
}
