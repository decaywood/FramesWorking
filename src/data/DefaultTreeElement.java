package data;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 14:25
 */
public abstract class DefaultTreeElement extends DefaultMutableTreeNode implements TreeElement {

    protected Map<Integer, TreeElement> elementMap;
    protected TreeElement parent;

    public DefaultTreeElement(Map<Integer, TreeElement> map) {
        this.elementMap = map;
    }

    @Override
    public void insert(MutableTreeNode child, int index) {
        super.insert(child, index);
        TreeElement c = (TreeElement) child;
        elementMap.put(c.getElementID(c.getElementType()), c);
    }

    @Override
    public void remove(int index) {
        super.remove(index);
        TreeElement child = (TreeElement)getChildAt(index);
        elementMap.remove(child.getElementID(child.getElementType()));
    }


    @Override
    public void setParent(MutableTreeNode newParent) {
        super.setParent(newParent);
        this.parent = (TreeElement) newParent;
    }


}
