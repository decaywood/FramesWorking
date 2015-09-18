package data;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author mamamiyear
 * @date 15-9-15
 */

public class TRACK extends DefaultTreeElement {

    public List<Point> TRACKBODY;

    @Override
    public ElementType getElementType() {
        return ElementType.MSG_TRACK;
    }

    @Override
    public int getElementID(ElementType type) {
        int res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS:  res = Scene.FDR_SCENARIO_MAPPING.get(getElementID(ElementType.FDR)); break;
            case FDR: res = Integer.parseInt(FDRID);
            case MSG_TRACK: res = Integer.parseInt(OBJID); break;

        }
        return res;
    }

    @Override
    public String getElementName() {
        return "TRACK" + OBJID;
    }

    public static class Point {

        public String PTID;
        public String SPEED;
        public String FL;
        public String ETO;

        private void extract(StringBuilder builder, String index) {
            appendPair(builder, "BEGIN", "POINT", index);
            for (Field field : Point.class.getDeclaredFields()) {
                appendField(builder, Point.this, field);
            }
            appendPair(builder, "END", "POINT", index);
        }

    }

    @Override
    public String extract(String result) {
        StringBuilder builder = new StringBuilder();
        appendPair(builder, "BEGIN", "TRACK");
        appendPair(builder, "BEGIN", "TRACKBODY");
        int index = 1;
        for (Point point : TRACKBODY) {
            point.extract(builder, String.valueOf(index++));
        }
        appendPair(builder, "END", "TRACKBODY");
        appendPair(builder, "END", "TRACK");
        return super.extract(builder.toString());
    }
}
