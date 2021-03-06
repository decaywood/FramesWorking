package views.track.Components;

import views.generalComponents.DateTextField;
import views.generalComponents.TimeTextField;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * Created by mamamiyear on 15-9-9.
 */
public class NewTrackCenterPanel extends JPanel {

    public JTextArea jTextAreaContents;
    public JTable jTableTrackPoint;
    private DefaultTableModel jTableTrackPointModel;
    public Vector<String> columNames;
    public Vector<Vector<String>> dataSet;
    public DateTextField dateTextFieldTrack;
    public TimeTextField timeTextFieldTrack;

    public NewTrackCenterPanel() {
        init();
    }

    public void init() {

        this.setLayout(new BorderLayout());

        JPanel[] jPanels = new JPanel[3];
        TitledBorder[] paneltitles = new TitledBorder[3];

        for (int i = 0; i < 3; i++) {

            jPanels[i] = new JPanel();
            jPanels[i].setLayout(new BorderLayout());
            paneltitles[i] = new TitledBorder("");
            jPanels[i].setBorder(paneltitles[i]);

        }

        paneltitles[0].setTitle("航迹执行时间");
        jPanels[0].setPreferredSize(new Dimension(700, 60));
        this.add(jPanels[0], BorderLayout.NORTH);
        paneltitles[1].setTitle("航迹点列表");
//        jPanels[1].setPreferredSize(new Dimension(700, 320));
        this.add(jPanels[1], BorderLayout.CENTER);
        paneltitles[2].setTitle("航迹剧本内容");
        jPanels[2].setPreferredSize(new Dimension(700, 100));
        this.add(jPanels[2], BorderLayout.SOUTH);

        JButton jButtonChangeTime = new JButton("修改时间");
        dateTextFieldTrack = new DateTextField();
        timeTextFieldTrack = new TimeTextField();
        jPanels[0].setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        jPanels[0].add(dateTextFieldTrack);
        jPanels[0].add(timeTextFieldTrack);
        jPanels[0].add(jButtonChangeTime);

        JScrollPane jScrollPane1 = new JScrollPane();
        initTableModel();
        jTableTrackPoint = new JTable(jTableTrackPointModel);
        jTableTrackPoint.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTableTrackPoint);
        jPanels[1].add(jScrollPane1);

        JScrollPane jScrollPane2 = new JScrollPane();
        jTextAreaContents = new JTextArea();
        jScrollPane2.setViewportView(jTextAreaContents);
        jPanels[2].add(jScrollPane2);



    }

    private void initTableModel() {

        jTableTrackPointModel = new DefaultTableModel();
        columNames = new Vector<String>();
        columNames.add("PTID");
        columNames.add("SPEED");
        columNames.add("ETO");
        columNames.add("FL");
        dataSet = new Vector<Vector<String>>();
        jTableTrackPointModel.setDataVector(dataSet, columNames);

    }
}
