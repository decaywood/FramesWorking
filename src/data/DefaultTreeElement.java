package data;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 14:25
 */
public abstract class DefaultTreeElement extends DefaultMutableTreeNode implements TreeElement {

    public String TYPECMD;
    public String TYPEOBJ;
    public String OBJID;
    public String SCENARIOID;
    public String FDRID;
    public String PERFORMMSGTIME;

    protected Map<Integer, TreeElement> elementMap;
    protected TreeElement parent;

    public DefaultTreeElement() {
        this.elementMap = new HashMap<>();
    }

    //----------------------- MutableTreeNode 方法 -------------------------

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

    //----------------------- TreeElement 方法 -------------------------

    @Override
    public void addElement(TreeElement newChild) {
        if(newChild.getElementType().getParent() == getElementType()) {
            insert(newChild, getChildCount());
            return;
        }
        int key = newChild.getElementID(getElementType().getChild());
        if(elementMap.containsKey(key)) elementMap.get(key).addElement(newChild);
    }


}
