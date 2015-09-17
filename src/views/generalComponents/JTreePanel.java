package views.generalComponents;

import data.Scene;
import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 * @author: decaywood
 * @date: 2015/9/11 20:28
 */
public class JTreePanel extends JScrollPane implements Colleague<TreeElement> {

    private TreeElement root;
    private JTree jTree;

    public JTreePanel() {
        this(new Scene());
    }

    public JTreePanel(TreeElement root) {
        ColleagueManager.Holder.MANAGER.register("JTreePanel", this);
        this.root = root;
        this.jTree = new JTree(root);
        this.jTree.setEditable(true);
        setViewportView(jTree);
        initJTreePanel();
    }

    private void initJTreePanel() {
        this.jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object element =  jTree.getLastSelectedPathComponent(); // TreeElement
                ColleagueManager.Holder.MANAGER.setData("", element);
                ColleagueManager.Holder.MANAGER.setData("", element);
                ColleagueManager.Holder.MANAGER.setData("", element);
            }
        });
    }


    @Override
    public void setData(TreeElement data) {
        root.addElement(data);
    }

    @Override
    public void update() {
        this.jTree.updateUI();
    }
}
