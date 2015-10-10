package data;

import java.util.HashMap;
import java.util.List;
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

    private Scene() {}

    public static class Root {
        public static TreeElement instance = new Scene();
    }

    public static List<TreeElement> getElement(
            TreeElement root,
            List<TreeElement> list,
            Class type) {
        if(root.getClass() == type) {
            list.add(root);
            return list;
        }

        for (int i = 0; i < root.getChildCount(); i++) {
            TreeElement element = (TreeElement) root.getChildAt(i);
            getElement(element, list, type);
        }
        return list;
    }

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

    @Override
    public void addElement(TreeElement newChild) {
        DefaultTreeElement element = (DefaultTreeElement)newChild;
        if (element.TYPECMD.equals("03")) {
            removeElement(newChild);
        } else super.addElement(newChild);
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
