package views.generalComponents;

import data.*;
import utils.Colleague;
import utils.ColleagueManager;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.util.ArrayList;
import java.util.List;

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
        if(root != null) {
            initJtree(root);
        }
    }

    private void initJtree(final TreeElement root) {
        this.root = root;
        this.jTree = new JTree(root);
        this.jTree.setEditable(true);
        setViewportView(jTree);
        this.jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreeElement element = (TreeElement) jTree.getLastSelectedPathComponent(); // TreeElement
                ColleagueManager manager = ColleagueManager.Holder.MANAGER;
                manager.setData("JTableFDRForControlCenter", getElement(element, new ArrayList<TreeElement>(), FDR.class));
                manager.setData("JTableMSGForControlCenter", getElement(element, new ArrayList<TreeElement>(), MSG.class));
                manager.setData("JTableTrackForControlCenter", getElement(element, new ArrayList<TreeElement>(), TRACK.class));
            }
        });
    }

    private List<TreeElement> getElement(
            TreeElement root,
            List<TreeElement> list,
            Class type) {
        if(root.getClass() == type) {
            list.add(root);
            return list;
        }

        for (int i = 0; i < root.getChildCount(); i++) {
            TreeElement element = (TreeElement) root.getChildAt(i);
            getElement(element, list, type);
        }
        return list;
    }


    @Override
    public void setData(TreeElement data) {
        if(data == null) return;
        if (root == null || data.getElementType() == TreeElement.ElementType.SCENE) {
            initJtree(data);
        } else root.addElement(data);
    }

    @Override
    public void update() {
        updateUI();
    }
}
