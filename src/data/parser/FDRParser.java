package data.parser;

import data.FDR;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:18
 */
public class FDRParser extends Parser {

    @Override
    public boolean canParse(int TYPEOBJ) {
        return TYPEOBJ == 2;
    }



    @Override
    public Map<String, Class> initClassMap() {
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("CMD", FDR.class);
        classMap.put("CONTENTCMD", FDR.class);
        classMap.put("FDR", FDR.class);
        return classMap;
    }

}
