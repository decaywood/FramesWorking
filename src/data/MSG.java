package data;

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
        return ElementType.MSG;
    }

    @Override
    public int getElementID(ElementType type) {
        int res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS: res = Integer.parseInt(SCENARIOID); break;
            case FDR: res = Integer.parseInt(FDRID);
            case MSG: res = Integer.parseInt(OBJID); break;
            case TRACK:break;

        }
        return res;
    }

    @Override
    public String getElementName() {
        return "MSG"+OBJID;
    }
}
