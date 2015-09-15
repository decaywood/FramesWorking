package views.contralCenter;

import data.JTreeDataNode;
import views.generalComponents.JEasyTable;
import views.generalComponents.JTreePanel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-12
 */

public class PanelForJPanelSW extends JPanel {

    private JTreePanel jTree;
    private JTreeDataNode nodeRoot;
    private List<JTreeDataNode> nodeScenarios;
    private JEasyTable jtableFDR;
    private Vector<String> tableColumnNames;
    private Vector<Vector<String>> tableDataSet;


    public PanelForJPanelSW() {
        super();
        init();
    }

    private void init() {

        setLayout(new BorderLayout());

        nodeScenarios = new ArrayList<JTreeDataNode>();
        nodeScenarios.add(new JTreeDataNode("剧本1"));
        nodeScenarios.add(new JTreeDataNode("剧本2"));
        nodeScenarios.add(new JTreeDataNode("剧本3"));
        nodeScenarios.add(new JTreeDataNode("剧本4"));
        nodeScenarios.add(new JTreeDataNode("剧本5"));
        nodeRoot = new JTreeDataNode("剧本树", nodeScenarios);
        jTree = new JTreePanel(nodeRoot);
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
        jtableFDR = new JEasyTable("FDR剧本", tableColumnNames, tableDataSet, true);
        jtableFDR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.add(jtableFDR, BorderLayout.CENTER);

    }

}
