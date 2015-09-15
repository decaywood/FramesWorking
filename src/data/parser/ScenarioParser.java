package data.parser;

import data.DataAnalizer;
import data.Scenario;
import data.TreeElement;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:56
 */
public class ScenarioParser extends Parser {

    private Map<String, Class> classMap;

    public ScenarioParser() {
        this.classMap = new HashMap<>();
        this.classMap.put("CONDITIONS", Scenario.Condition.class);
        this.classMap.put("RELEATIONS", Scenario.Releation.class);
    }

    @Override
    public boolean canParse(int TYPEOBJ) {
        return TYPEOBJ == 1;
    }

    @Override
    public TreeElement parse(List<DataAnalizer.Entry> entries) {
        Scenario scenario = new Scenario();
        Deque<Object> stack = new LinkedList<>();
        stack.push(scenario);
        for (DataAnalizer.Entry entry : entries) {
            String key = entry.key;
            String val = entry.value;
            Field field = null;
            try {
                field = scenario.getClass().getDeclaredField(key);
                field.setAccessible(true);
                field.set(scenario, val);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
