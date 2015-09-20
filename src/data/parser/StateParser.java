package data.parser;

import data.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/19 11:06
 */
public class StateParser extends Parser {

    private Map<Integer, Map<String, Class>> maps;

    public StateParser() {
        this.maps = new HashMap<>();
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("CMD", Scenario.class);
        classMap.put("CONTENTCMD", Scenario.class);
        this.maps.put(1, classMap);
        classMap = new HashMap<>();
        classMap.put("CMD", FDR.class);
        classMap.put("CONTENTCMD", FDR.class);
        this.maps.put(2, classMap);
        classMap = new HashMap<>();
        classMap.put("CMD", MSG.class);
        classMap.put("CONTENTCMD", MSG.class);
        this.maps.put(3, classMap);
        classMap = new HashMap<>();
        classMap.put("CMD", TRACK.class);
        classMap.put("CONTENTCMD", TRACK.class);
        this.maps.put(4, classMap);
    }

    @Override
    public boolean canParse(int TYPEOBJ) {
        setClassMap(maps.get(TYPEOBJ));
        return true;
    }

    @Override
    public Map<String, Class> initClassMap() {
        return new HashMap<>();
    }

    @Override
    public boolean canParse(List<DataAnalizer.Entry> entries) {
        for (DataAnalizer.Entry entry : entries) {
            if (entry.key.equalsIgnoreCase("TYPECMD")) {
                int typeCMD = Integer.parseInt(entry.value);
                if(!(typeCMD > 5 && typeCMD < 9)) return false;
            }
            if (entry.key.equalsIgnoreCase("TYPEOBJ")) {
                return canParse(Integer.parseInt(entry.value));
            }
        }
        return false;
    }
}
