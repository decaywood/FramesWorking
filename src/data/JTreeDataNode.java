package data;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/11 20:31
 */
public class JTreeDataNode {

    String nodeName;
    List<JTreeDataNode> childs;

    public JTreeDataNode(String nodeName) {
        this(nodeName, null);
    }


    public JTreeDataNode(String nodeName, List<JTreeDataNode> childs) {
        this.nodeName = nodeName;
        this.childs = childs == null ? new ArrayList<JTreeDataNode>() : childs;
    }

    public void add(JTreeDataNode node) {
        if(node == null) return;
        childs.add(node);
    }

    public DefaultMutableTreeNode convertToTreeNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(nodeName);
        for (JTreeDataNode child : childs) {
            node.add(child.convertToTreeNode());
        }
        return node;
    }
}
