package data.parser;

import data.DataAnalizer;
import data.TreeElement;

import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:58
 */
public class TrackParser extends Parser {

    @Override
    public TreeElement parse(List<DataAnalizer.Entry> entries) {
        return null;
    }

    @Override
    public boolean canParse(int TYPEOBJ) {
        return false;
    }
}
