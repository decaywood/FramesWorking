package data.parser;

import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:58
 */
public class TrackParser extends Parser {


    @Override
    public boolean canParse(int TYPEOBJ) {
        return false;
    }

    @Override
    public Map<String, Class> initClassMap() {
        return null;
    }
}
