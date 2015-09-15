package data;


/**
 * @author: decaywood
 * @date: 2015/9/15 11:10
 */
public interface TreeElement {

    enum ElementType {
        SCENE(null),
        SCENARIOS(SCENE),
        FDR(SCENARIOS),
        MSG(FDR),
        TRACK(MSG);

        private ElementType parentType;
        private ElementType childType;

        ElementType(ElementType parentType) {
            this.parentType = parentType;
            parentType.childType = this;
        }
    }


    ElementType getElementType();

    int getElementID(ElementType type);

    String getElementName();

    void addElement(TreeElement element);

    void removeElement(TreeElement element);

}
