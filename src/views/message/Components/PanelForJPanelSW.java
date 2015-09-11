package views.message.Components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSW extends JPanel {

    private JScrollPane jScrollPane;
    private JTable jTableTrack;
    private DefaultTableModel jTabelTrackModel;
    private Vector<String> columnNames;
    private Vector<Vector<String>> dataSet;
    private Vector<Vector<String>> showSet;

    public PanelForJPanelSW() {

        super();
        init();

    }

    public void init() {

        this.setLayout(new BorderLayout());

        jScrollPane = new JScrollPane();
        this.add(jScrollPane, BorderLayout.CENTER);

        initTableModel();
        jTableTrack = new JTable(jTabelTrackModel);
        jScrollPane.setViewportView(jTableTrack);

    }

    public void initTableModel() {

        columnNames = new Vector<String>();
        try {
            File file = new File("./textFiles/JTableTrackColumnNames");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = reader.readLine()) != null) {
                columnNames.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }





        dataSet = new Vector<Vector<String>>();
        showSet = new Vector<Vector<String>>();

        jTabelTrackModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTabelTrackModel.setDataVector(showSet, columnNames);

    }

}
