package data;


import javax.swing.tree.MutableTreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/15 11:10
 */
public interface TreeElement extends MutableTreeNode {

    enum ElementType {
        SCENE,
        SCENARIOS,
        FDR,
        MSG_TRACK;

        public ElementType getParent() {
            switch (this) {
                case SCENARIOS:
                    return SCENE;
                case FDR:
                    return SCENARIOS;
                case MSG_TRACK:
                    return FDR;
                default :
                    return null;
            }
        }

        public ElementType getChild() {
            switch (this) {
                case SCENE:
                    return SCENARIOS;
                case SCENARIOS:
                    return FDR;
                case FDR:
                    return MSG_TRACK;
                default :
                    return null;
            }
        }

    }



    ElementType getElementType();

    int getElementID(ElementType type);

    String getElementName();

    void addElement(TreeElement newChild);

    void removeElement(TreeElement childToRemove);

}
