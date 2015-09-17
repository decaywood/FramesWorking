package data;

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


    @Override
    public ElementType getElementType() {
        return ElementType.FDR;
    }

    @Override
    public int getElementID(ElementType type) {
        int res = Integer.MAX_VALUE;
        switch (type) {

            case SCENARIOS: res = Integer.parseInt(SCENARIOID); break;
            case FDR: res = Integer.parseInt(OBJID);
            case MSG_TRACK:break;

        }
        return res;
    }

    @Override
    public String getElementName() {
        return "FDR"+OBJID;
    }
}
