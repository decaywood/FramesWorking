package data.parser;

import data.DataAnalizer;
import data.TRACK;
import data.TreeElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:58
 */
public class TrackParser extends Parser {


    @Override
    public boolean canParse(int TYPEOBJ) {
        return TYPEOBJ == 4;
    }

    @Override
    public TreeElement parse(List<DataAnalizer.Entry> entries) {
        TreeElement element =  super.parse(entries);
        return element;
    }

    @Override
    public Map<String, Class> initClassMap() {
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("CMD", TRACK.class);
        classMap.put("CONTENTCMD", TRACK.class);
        classMap.put("TRACK", TRACK.class);
        classMap.put("TRACKBODY", ArrayList.class);
        classMap.put("POINT", TRACK.Point.class);
        return classMap;
    }
}
