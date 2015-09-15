package views.generalComponents;

import data.JTreeDataNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author: decaywood
 * @date: 2015/9/11 20:28
 */
public class JTreePanel extends JScrollPane {

    public JTreePanel(JTreeDataNode root) {
        JTree jTree = new JTree(root.convertToTreeNode());
        setViewportView(jTree);
    }

    public JTreePanel(DefaultMutableTreeNode root) {
        JTree jTree = new JTree(root);
        setViewportView(jTree);
    }

}
