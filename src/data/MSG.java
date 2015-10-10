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
        long res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS:
                if(parent != null && parent.parent != null) return parent.parent.getElementID(ElementType.SCENARIOS);
                if(SCENARIOID.equals("NULL")) {
                    long fdrID = !FDRID.equalsIgnoreCase("NULL") ? getElementID(ElementType.FDR) : Scene.MAPPING.get(elementHash());
                    long fdrHash = (2L << 32) + fdrID;
                    res = Scene.MAPPING.get(fdrHash);
                } break;
            case FDR:
                if(parent != null) return parent.getElementID(ElementType.FDR);
                if(!FDRID.equalsIgnoreCase("NULL")){
                    res = Integer.parseInt(FDRID);
                    Scene.MAPPING.put(elementHash(), Long.parseLong(FDRID));
                } else {
                    res = Scene.MAPPING.get(elementHash());
                } break;
            case MSG_TRACK: res = Integer.parseInt(OBJID); break;

        }
        return (int)res;
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
