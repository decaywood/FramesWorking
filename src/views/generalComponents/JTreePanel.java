package views.generalComponents;

import data.*;
import utils.Colleague;
import utils.ColleagueManager;
import views.controlCenter.JTableFDR;
import views.controlCenter.JTableMSG;
import views.controlCenter.JTableTrack;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.util.ArrayList;

/**
 * @author: decaywood
 * @date: 2015/9/11 20:28
 */
public class JTreePanel extends JScrollPane implements Colleague<TreeElement> {

    private TreeElement root;
    private JTree jTree;



    public JTreePanel(TreeElement root) {

        ColleagueManager.Holder.MANAGER.register(JTreePanel.class.getName(), this);
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
                updateUI(element);
            }
        });
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

    private void updateUI(TreeElement element) {
        ColleagueManager manager = ColleagueManager.Holder.MANAGER;
        manager.setData(JTableFDR.class.getName(), Scene.getElement(element, new ArrayList<TreeElement>(), FDR.class));
        manager.setData(JTableMSG.class.getName(), Scene.getElement(element, new ArrayList<TreeElement>(), MSG.class));
        manager.setData(JTableTrack.class.getName(), Scene.getElement(element, new ArrayList<TreeElement>(), TRACK.class));
    }
}
