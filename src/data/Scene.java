package data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 11:20
 */
public class Scene extends DefaultTreeElement {

    /**
     * key: FDR_ID val: SCENARIO_ID
     */
    public static final Map<Integer, Integer> FDR_SCENARIO_MAPPING = new HashMap<>();
    private Map<Integer, TreeElement> scenarios;


    @Override
    public ElementType getElementType() {
        return ElementType.SCENE;
    }

    @Override
    public int getElementID(ElementType type) {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getElementName() {
        return "SCENE";
    }
}
