package views;

import utils.JTreeDataNode;

import javax.swing.*;

/**
 * @author: decaywood
 * @date: 2015/9/11 20:06
 */
public class JTreePanelTest extends AbstractTestFrame {
    @Override
    protected void init() {
        JTreeDataNode root = new JTreeDataNode("root");
        JTreeDataNode color = new JTreeDataNode("color");
        JTreeDataNode shape = new JTreeDataNode("shape");
        JTreeDataNode size = new JTreeDataNode("size");
        color.add(new JTreeDataNode("red"));
        color.add(new JTreeDataNode("green"));
        color.add(new JTreeDataNode("yellow"));
        shape.add(new JTreeDataNode("circle"));
        shape.add(new JTreeDataNode("rect"));
        root.add(color);
        root.add(shape);
        root.add(size);
        JTree jTree = new JTree(root.convertToTreeNode());
        add(jTree);
    }

    public static void main(String[] args) {
        new JTreePanelTest();
    }
}
