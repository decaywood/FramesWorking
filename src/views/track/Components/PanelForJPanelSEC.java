package views.track.Components;

import data.TRACK;
import utils.Colleague;
import utils.ColleagueManager;
import utils.Pair;
import views.generalComponents.LabelTextFieldPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSEC extends JPanel implements Colleague<TRACK> {

    private LabelTextFieldPanel labelTextFieldPanel;

    private JScrollPane jScrollPaneTablePoint;
    private JTable jTableTrackPoint;
    private DefaultTableModel jTableTrackPointModel;
    private Vector<String> columnNames;
    private Vector<Vector<String>> dataSet;

    public PanelForJPanelSEC() {
        super();
        ColleagueManager.Holder.MANAGER.register(PanelForJPanelSEC.class.getName(), this);
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
        dataSet = new Vector<Vector<String>>();

        jTableTrackPointModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


    }

    @Override
    public void setData(TRACK track) {
        Map<String, String> map = new HashMap<>();
        map.put("执行时间", track.PERFORMMSGTIME);
        map.put("执行状态", track.PERSTATE);
        map.put("ID", track.OBJID);
        List<TRACK.Point> points = track.TRACKBODY;
        labelTextFieldPanel.updateTextField(map);
        columnNames.removeAllElements();
        dataSet.removeAllElements();
        for (Field field : TRACK.Point.class.getDeclaredFields()) {
            columnNames.addElement(field.getName());
        }
        for (TRACK.Point point : points) {
            Vector<String> vector = new Vector<>();
            for (Field field : TRACK.Point.class.getDeclaredFields()) {
                try {
                    vector.addElement((String)field.get(point));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            dataSet.addElement(vector);
        }
        jTableTrackPointModel.setDataVector(dataSet, columnNames);

    }

    @Override
    public void update() {

    }
}
