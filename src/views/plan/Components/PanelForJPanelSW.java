package views.plan.Components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSW extends JPanel {

    private JScrollPane jScrollPane;
    private JTableFDR jTableFDR;
    private DefaultTableModel jTabelFDRModel;
    private Vector<String> columnNames;
    private Vector<Vector<String>> dataSet;
    private Vector<Vector<String>> showSet;

    public PanelForJPanelSW() {

        super();
        init();

    }

    public void init() {

        this.setLayout(new BorderLayout());
        jTableFDR = new JTableFDR();
        jTableFDR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.add(jTableFDR, BorderLayout.CENTER);

    }

}
