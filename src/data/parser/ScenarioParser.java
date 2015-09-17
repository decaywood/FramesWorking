package data.parser;

import data.DataAnalizer;
import data.Scenario;
import data.TreeElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:56
 */
public class ScenarioParser extends Parser {


    @Override
    public boolean canParse(int TYPEOBJ) {
        return TYPEOBJ == 1;
    }

    @Override
    public Map<String, Class> initClassMap() {
        Map<String, Class> classMap = new HashMap<>();
        classMap.put("CMD", Scenario.class);
        classMap.put("CONTENTCMD", Scenario.class);
        classMap.put("SCENARIO", Scenario.class);
        classMap.put("CONDITION", Scenario.Condition.class);
        classMap.put("MSG", Scenario.Condition.MSGPARAM.class);

        classMap.put("CONDITIONS", ArrayList.class);
        classMap.put("MSGPARAMS", ArrayList.class);
        classMap.put("RELEATIONS", ArrayList.class);
        return classMap;
    }

    @Override
    public TreeElement parse(List<DataAnalizer.Entry> entries) {
        Scenario element = (Scenario) super.parse(entries);
        List<Scenario.Releation> list = new ArrayList<>();
        for (int i = 0; element.RELEATIONS != null && i < element.RELEATIONS.size(); i++) {
            Object releation = element.RELEATIONS.get(i);
            //noinspection ConstantConditions
            list.add(new Scenario.Releation((String) releation, i));
        }

        element.RELEATIONS = list;
        return element;
    }
}
