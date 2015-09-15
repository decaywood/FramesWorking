package data;


import javax.swing.tree.MutableTreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/15 11:10
 */
public interface TreeElement extends MutableTreeNode {

    enum ElementType {
        SCENARIOS,
        FDR,
        MSG,
        TRACK
    }

    void setParent(TreeElement parent);

    ElementType getElementType();

    int getElementID(ElementType type);

    String getElementName();

    void addElement(TreeElement element);

    void removeElement(TreeElement element);

}
