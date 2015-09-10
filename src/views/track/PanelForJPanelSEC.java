package views.track;

import utils.Pair;
import views.generalComponents.LabelTextFieldPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSEC extends JPanel {

    private LabelTextFieldPanel labelTextFieldPanel;

    private JScrollPane jScrollPaneTablePoint;
    private JTable jTableTrackPoint;
    private DefaultTableModel jTableTrackPointModel;
    private Vector<String> columnNames;
    private Vector<Vector<String>> dataSet;
    private Vector<Vector<String>> showSet;

    public PanelForJPanelSEC() {
        super();
        init();
    }

    public void init() {

        setLayout(new BorderLayout());

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair("执行时间", 100));
        pairs.add(new Pair("执行状态", 100));
        pairs.add(new Pair("ID", 100));
        labelTextFieldPanel = new LabelTextFieldPanel(pairs, "详细信息");
        this.add(labelTextFieldPanel, BorderLayout.NORTH);


        jScrollPaneTablePoint = new JScrollPane();
        jScrollPaneTablePoint.setBorder(new TitledBorder("航迹点列表"));
        this.add(jScrollPaneTablePoint, BorderLayout.CENTER);
        initTableModel();
        jTableTrackPoint = new JTable(jTableTrackPointModel);
        jScrollPaneTablePoint.setViewportView(jTableTrackPoint);


    }

    public void initTableModel() {

        columnNames = new Vector<String>();

        try {
            File file = new File("./textFiles/JTableTrackPointColumnNames");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = reader.readLine()) != null) {
                columnNames.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        dataSet = new Vector<Vector<String>>();
        showSet = new Vector<Vector<String>>();


        jTableTrackPointModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTableTrackPointModel.setDataVector(showSet, columnNames);

    }
}
