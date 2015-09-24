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
        long res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS:
                if(parent != null && parent.parent != null) return parent.parent.getElementID(ElementType.SCENARIOS);
                if(!SCENARIOID.equalsIgnoreCase("NULL")){
                } else {
                    long fdrID = !FDRID.equalsIgnoreCase("NULL") ? getElementID(ElementType.FDR) : Scene.MAPPING.get(elementHash());
                    long fdrHash = 2 << 32 + fdrID;
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

    public String extractPoints(StringBuilder builder) {
        int index = 1;
        for (Point point : TRACKBODY) {
            point.extract(builder, String.valueOf(index++));
            builder.append("\n");
        }
        return builder.toString();
    }

    public String extractFromBody(String body) {
        StringBuilder builder = new StringBuilder();
        appendPair(builder, "BEGIN", "TRACK");
        appendPair(builder, "BEGIN", "TRACKBODY");
        builder.append(body);
        appendPair(builder, "END", "TRACKBODY");
        appendPair(builder, "END", "TRACK");
        return super.extract(builder.toString());
    }

    @Override
    public String extract(String result) {
        StringBuilder builder = new StringBuilder();
        appendPair(builder, "BEGIN", "TRACK");
        appendPair(builder, "BEGIN", "TRACKBODY");
        extractPoints(builder);
        appendPair(builder, "END", "TRACKBODY");
        appendPair(builder, "END", "TRACK");
        return super.extract(builder.toString());
    }
}
