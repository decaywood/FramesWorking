package data;

import data.parser.*;

import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/9/15 17:08
 */
public class DataAnalizer {

    private List<Parser> parsers;

    public static class Entry {
        public String key;
        public String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public
    DataAnalizer() {
        parsers = new ArrayList<>();
        parsers.add(new StateParser());
        parsers.add(new MSGParser());
        parsers.add(new TrackParser());
        parsers.add(new FDRParser());
        parsers.add(new ScenarioParser());
    }

    private List<List<Entry>> convertData(String string) {
        List<List<Entry>> dataSet = new LinkedList<>();
        String[] orders = string.split("\\|");
        boolean start = false;
        List<Entry> list = new ArrayList<>();
        for(String set : orders){
            set = set.trim();
            String[] entry = set.split("=");
            if(entry.length != 2) continue;
            if(entry[1].trim().equalsIgnoreCase("CMD")) {
                list.add(new Entry(entry[0], entry[1]));
                if (entry[0].trim().equalsIgnoreCase("END")) {
                    dataSet.add(list);
                    list = new ArrayList<>();
                }
                start = !start;
                continue;
            }
            if (start) list.add(new Entry(entry[0], entry[1]));
        }
        return dataSet;
    }


    public TreeElement readSource(String string) {
        List<List<Entry>> dataSet = convertData(string);
        TreeElement root = Scene.Root.instance;
        for (List<Entry> data : dataSet) {
            TreeElement element = parseData(data);
            if(element == null) continue;
            root.addElement(element);
        }
        return root;
    }


    private TreeElement parseData(List<Entry> data) {
        for (Parser parser : parsers)
            if(parser.canParse(data)) return parser.parse(data);
        return null;
    }
}
