package data;

import javax.swing.tree.TreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/15 11:10
 */
public interface TreeElement extends TreeNode {

    enum ElementType {
        SCENARIOS,
        FDR,
        MSG,
        TRACK
    }

    ElementType getElementType();

    int getElementID(ElementType type);

    String getElementName();

    void addElement(TreeElement element);

    void removeElement(TreeElement element);

}
