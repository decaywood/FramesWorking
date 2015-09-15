package data;

import java.util.List;

/**
 * @author mamamiyear
 * @date 15-9-15
 */

public class TRACK extends DefaultTreeElement {

    public List<Point> TRACKBODY;

    @Override
    public ElementType getElementType() {
        return ElementType.TRACK;
    }

    @Override
    public int getElementID(ElementType type) {
        int res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS: res = Integer.parseInt(SCENARIOID); break;
            case FDR: res = Integer.parseInt(FDRID);
            case MSG: break;
            case TRACK: res = Integer.parseInt(OBJID); break;

        }
        return res;
    }

    @Override
    public String getElementName() {
        return "TRACK" + OBJID;
    }

    public class Point {

        public String PTID;
        public String SPEED;
        public String FL;
        public String ETO;

    }

}
