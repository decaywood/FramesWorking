package data;

import java.lang.reflect.Field;

/**
 * @author mamamiyear
 * @date 15-9-15
 */

public class FDR extends DefaultTreeElement {

    public String FLIGHTID;
    public String DEP;
    public String DES;
    public String RFL;
    public String TAS;
    public String RTE;
    public String ACTYPE;
    public String WCT;
    public String FLTRUL;
    public String FLTTYP;
    public String CEQPT;
    public String SEQPT;
    public String PEOBD;
    public String PEOBT;
    public String PETA;
    public String EOBD;
    public String EOBT;
    public String ETD;
    public String ETA;
    public String TTLEET;
    public String CEOBT;
    public String CETD;
    public String CETA;
    public String AOBT;
    public String ATD;
    public String ATA;
    public String ALTRANT;
    public String TALT;
    public String RALT;
    public String ARCNUM;
    public String CFL;
    public String OTHER;
    public String RTEPTS;
    public String SSRCODE;
    public String VIP;
    public String REG;
    public String DEPGATE;
    public String ARRGATE;
    public String DEPWAY;
    public String ARRWAY;
    public String SID;
    public String STAR;
    public String RTNALN;
    public String ARRRUNWAY;
    public String DEPRUNWAY;
    public String PRE;
    public String NEXT;


    @Override
    public ElementType getElementType() {
        return ElementType.FDR;
    }

    @Override
    public int getElementID(ElementType type) {
        long res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS:
                if(!SCENARIOID.equalsIgnoreCase("NULL")){
                    res = Integer.parseInt(SCENARIOID);
                    Scene.MAPPING.put(elementHash(), Long.parseLong(SCENARIOID));
                } else {
                    Long temp = Scene.MAPPING.get(elementHash());
                    res = temp == null ? this.parent.getElementID(this.parent.getElementType()) : temp;
                } break;
            case FDR: res = Integer.parseInt(OBJID); break;
            case MSG_TRACK:break;

        }
        return (int) res;
    }

    @Override
    public String extract(String result) {
        StringBuilder builder = new StringBuilder();
        appendPair(builder, "BEGIN", "FDR");
        for (Field field : FDR.class.getDeclaredFields()) {
            appendField(builder, this, field);
        }
        appendPair(builder, "END", "FDR");
        return super.extract(builder.toString());
    }

    @Override
    public String getElementName() {
        return "FDR"+OBJID;
    }
}
