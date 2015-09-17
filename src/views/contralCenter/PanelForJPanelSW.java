package views.contralCenter;

import views.generalComponents.JEasyTable;
import views.generalComponents.JTreePanel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-12
 */

public class PanelForJPanelSW extends JPanel {

    private JTreePanel jTree;
    private JTableFDR jtableFDR;
    private Vector<String> tableColumnNames;
    private Vector<Vector<String>> tableDataSet;


    public PanelForJPanelSW() {
        super();
        init();
    }

    private void init() {

        setLayout(new BorderLayout());

        jTree = new JTreePanel(null);
        jTree.setPreferredSize(new Dimension(200, 700));
        this.add(jTree, BorderLayout.WEST);

        tableColumnNames = new Vector<String>();
        try {
            File file = new File("./textFiles/JTableFDRColumnNames");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = reader.readLine()) != null) {
                tableColumnNames.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableDataSet = new Vector<Vector<String>>();
        jtableFDR = new JTableFDR("FDR剧本", tableColumnNames, tableDataSet, true);
        jtableFDR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.add(jtableFDR, BorderLayout.CENTER);

    }

}
