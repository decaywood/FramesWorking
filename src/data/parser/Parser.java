package data.parser;

import data.DataAnalizer;
import data.TreeElement;

import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:19
 */
public abstract class Parser {

    public boolean canParse(List<DataAnalizer.Entry> entries) {
        for (DataAnalizer.Entry entry : entries) {
            if (entry.key.equalsIgnoreCase("TYPEOBJ")) {
                return canParse(Integer.parseInt(entry.value));
            }
        }
        return false;
    }

    public abstract TreeElement parse(List<DataAnalizer.Entry> entries);

    public abstract boolean canParse(int TYPEOBJ);
}
