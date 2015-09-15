package data;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 14:25
 */
public abstract class DefaultTreeElement implements TreeElement {

    private List<TreeElement> elements;
    private Map<Integer, TreeElement> elementMap;
    private TreeElement parent;

    @Override
    public void insert(MutableTreeNode child, int index) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(MutableTreeNode node) {

    }

    @Override
    public void setUserObject(Object object) {

    }

    @Override
    public void removeFromParent() {

    }

    @Override
    public void setParent(MutableTreeNode newParent) {

    }

    public DefaultTreeElement(Map<Integer, TreeElement> map) {
        this.elementMap = map;
    }

    @Override
    public void setParent(TreeElement parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return elements.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return elements.size();
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration children() {
        return null;
    }

}
