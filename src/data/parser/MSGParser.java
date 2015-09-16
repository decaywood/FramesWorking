package data.parser;

import data.MSG;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:58
 */
public class MSGParser extends Parser {



    @Override
    public boolean canParse(int TYPEOBJ) {
        return TYPEOBJ == 3;
    }

    @Override
    public Map<String, Class> initClassMap() {
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("CMD", MSG.class);
        classMap.put("CONTENTCMD", MSG.class);
        classMap.put("MSG", MSG.class);
        return classMap;
    }
}
