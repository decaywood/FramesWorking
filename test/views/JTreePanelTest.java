package views;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: decaywood
 * @date: 2015/9/11 20:06
 */
public class JTreePanelTest extends AbstractTestFrame {
    @Override
    protected void init() {
        setLayout(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode color = new DefaultMutableTreeNode("color");
        DefaultMutableTreeNode shape = new DefaultMutableTreeNode("shape");
        DefaultMutableTreeNode size = new DefaultMutableTreeNode("size");
        color.add(new DefaultMutableTreeNode("red"));
        color.add(new DefaultMutableTreeNode("green"));
        color.add(new DefaultMutableTreeNode("yellow"));
        shape.add(new DefaultMutableTreeNode("circle"));
        shape.add(new DefaultMutableTreeNode("rect"));
        root.add(color);
        root.add(shape);
        root.add(size);
        JTree jTree = new JTree(root);
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        add(jTree, BorderLayout.CENTER);
        JButton button = new JButton("addNode");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double data = Math.random();
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(String.valueOf(data));
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
                model.insertNodeInto(node, selected, 0);
            }
        });
        add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new JTreePanelTest();
    }
}
