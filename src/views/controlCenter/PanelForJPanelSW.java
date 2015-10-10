package views.controlCenter;

import views.generalComponents.JTreePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author mamamiyear
 * @date 15-9-12
 */

public class PanelForJPanelSW extends JPanel {

    private JTreePanel jTree;
    private JTableFDR jtableFDR;

    public PanelForJPanelSW() {
        super();
        init();
        initPopupmenuAction();
    }

    private void init() {

        setLayout(new BorderLayout());

        jTree = new JTreePanel(null);
        jTree.setPreferredSize(new Dimension(200, 700));
        this.add(jTree, BorderLayout.WEST);

        jtableFDR = new JTableFDR("FDR剧本");
        jtableFDR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.add(jtableFDR, BorderLayout.CENTER);

    }

    private void initPopupmenuAction() {

        ActionListener actionListener = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("监听添加成功.");
            }
        };

        jtableFDR.setPopupMenuItemAction("添加", actionListener);
    }


}
