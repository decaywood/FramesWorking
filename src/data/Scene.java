package data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 11:20
 */
public class Scene extends DefaultTreeElement {

    /**
     * key: childHash val: OBJID
     */
    public static final Map<Long, Long> MAPPING = new HashMap<>();



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

    public void removeElement(TreeElement childToRemove) {
        super.removeElement(childToRemove);
        if (childToRemove.getElementType() == ElementType.SCENARIOS) {
            if(elementMap.containsKey(childToRemove.getElementID(ElementType.SCENARIOS))){
                for (int i = 0; i < childToRemove.getChildCount(); i++) {
                    TreeElement element = (TreeElement) childToRemove.getChildAt(i);
                    MAPPING.remove(element.elementHash());
                }
            }
        }
    }


}
