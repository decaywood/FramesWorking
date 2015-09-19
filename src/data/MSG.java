package data;

import java.lang.reflect.Field;

/**
 * @author mamamiyear
 * @date 15-9-15
 */

public class MSG extends DefaultTreeElement {

    public String MSGTYPE;
    public String MSGHEAD;
    public String MSGBODY;


    @Override
    public ElementType getElementType() {
        return ElementType.MSG_TRACK;
    }

    @Override
    public int getElementID(ElementType type) {
        int res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS:
                res = Scene.FDR_SCENARIO_MAPPING.get(getElementID(ElementType.FDR)); break;
            case FDR: res = Integer.parseInt(FDRID);
            case MSG_TRACK: res = Integer.parseInt(OBJID); break;

        }
        return res;
    }

    @Override
    public String extract(String result) {
        StringBuilder builder = new StringBuilder();
        appendPair(builder, "BEGIN", "MSG");
        for (Field field : MSG.class.getDeclaredFields()) {
            appendField(builder, this, field);
        }
        appendPair(builder, "END", "MSG");
        return super.extract(builder.toString());
    }

    @Override
    public String getElementName() {
        return "MSG"+OBJID;
    }
}
