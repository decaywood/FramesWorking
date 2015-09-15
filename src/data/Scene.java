package data;

import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 11:20
 */
public class Scene extends DefaultTreeElement {

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
