package data;

import data.parser.Parser;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.lang.reflect.Field;
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
    public String PERSTATE;
    public String ALTSTATE;
    public String ADDSTATE;


    protected Map<Integer, TreeElement> elementMap;
    public DefaultTreeElement parent;

    public DefaultTreeElement() {
        this.elementMap = new HashMap<>();
        setAllowsChildren(true);
    }

    @Override
    public Object getUserObject() {
        String type = getElementType() == ElementType.MSG_TRACK ?
                Integer.parseInt(TYPEOBJ) == 3 ? "MSG" :
                        "TRACK" : getElementType().name();
        return type + OBJID;
    }

    @Override
    public String toString() {
        String type = getElementType() == ElementType.MSG_TRACK ?
                Integer.parseInt(TYPEOBJ) == 3 ? "MSG" :
                        "TRACK" : getElementType().name();
        return type + OBJID;
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
        TreeElement child = (TreeElement)getChildAt(index);
        elementMap.remove(child.getElementID(child.getElementType()));
        super.remove(index);
    }


    @Override
    public void setParent(MutableTreeNode newParent) {
        super.setParent(newParent);
        this.parent = (DefaultTreeElement) newParent;
    }

    //----------------------- TreeElement 方法 -------------------------

    @Override
    public void addElement(TreeElement newChild) {

        if(newChild.getElementType().getParent() == getElementType()) {
            int elementID = newChild.getElementID(newChild.getElementType());
            if (elementMap.containsKey(elementID)) {
                TreeElement hunter = elementMap.get(elementID);
                Parser.mergeObject(hunter, newChild);
                return;
            }
            insert(newChild, getChildCount());
            return;
        }
        int key = newChild.getElementID(getElementType().getChild());
        if(elementMap.containsKey(key)) elementMap.get(key).addElement(newChild);
    }

    @Override
    public void removeElement(TreeElement childToRemove) {
        if(Scene.MAPPING.containsKey(childToRemove.elementHash())) Scene.MAPPING.remove(childToRemove.elementHash());
        if (childToRemove.getElementType().getParent() == getElementType()) {
            int key = childToRemove.getElementID(childToRemove.getElementType());
            if (elementMap.containsKey(key)) {
                // remove from JTree data structure
                remove(childToRemove);
                // remove from map
                elementMap.remove(key);
            }
        } else {
            TreeElement element = elementMap.get(childToRemove.getElementID(getElementType().getChild()));
            element.removeElement(childToRemove);
        }
    }

    @Override
    public String extract(String result) {
        result = result == null ? "" : result;
        StringBuilder builder = new StringBuilder();
        Field[] fields = DefaultTreeElement.class.getDeclaredFields();
        appendPair(builder, "BEGIN", "CMD");
        for (int i = 0; i < 5; i++) {
            appendField(builder, this, fields[i]);
        }
        appendPair(builder, "BEGIN", "CONTENTCMD");
        appendField(builder, this, fields[5]);
        builder.append(result);
        appendPair(builder, "END", "CONTENTCMD");
        appendPair(builder, "END", "CMD");
        return builder.toString();
    }

    protected static void appendPair(StringBuilder builder, String key, Object... val) {
        builder.append(key).append("=");
        for (Object o : val) {
            builder.append(o);
        }
        builder.append("|");
    }

    protected static void appendField(StringBuilder builder, Object object, Field field) {
        try {
            appendPair(builder, field.getName(), field.get(object));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public long elementHash() {
        return Integer.parseInt(TYPEOBJ) << 32 + Integer.parseInt(OBJID);
    }

    @Override
    public DefaultTreeElement clone() {
        return (DefaultTreeElement) super.clone();
    }

    //---------------------------------------------------------------

}
