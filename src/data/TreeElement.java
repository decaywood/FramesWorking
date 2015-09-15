package data;


import javax.swing.tree.MutableTreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/15 11:10
 */
public interface TreeElement extends MutableTreeNode {

    enum ElementType {
        SCENE(null),
        SCENARIOS(SCENE),
        FDR(SCENARIOS),
        MSG(FDR),
        TRACK(MSG);

        public ElementType parentType;
        public ElementType childType;

        ElementType(ElementType parentType) {
            this.parentType = parentType;
            parentType.childType = this;
        }
    }


    ElementType getElementType();

    int getElementID(ElementType type);

    String getElementName();

    void addElement(TreeElement newChild);


}
