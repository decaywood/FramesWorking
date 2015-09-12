package views.AIDCCenter;

import views.generalComponents.JEasyChartBuilder;
import views.generalComponents.JEasyTable;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/11 21:44
 */
public class PanelForJPanelSEC extends JPanel {


    public PanelForJPanelSEC() {

        setLayout(new GridLayout(3, 1, 0, 0));
        setBorder(new TitledBorder("4D数据"));
        init();
    }

    private void init() {
        // --------------- for test ----------------------
        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list1.add(i - 25 * Math.random());
            list2.add(i - 25 * Math.random());
        }
        // --------------- for test ----------------------

        JPanel heightChartPanel = new JEasyChartBuilder()
                .createDataset("", list1)
                .createChart("高度与时间", "", "").buildPanel();

        JPanel speedChartPanel = new JEasyChartBuilder()
                .createDataset("", list2)
                .createChart("速度与时间", "", "").buildPanel();

        JEasyTable jTable = new JEasyTable();
        jTable.setTitle("Fix与时间");
        JButton displayTrackBtn = new JButton("显示航路");
        JButton trackingTargetBtn = new JButton("跟踪目标");
        JPanel btnPanel = new JPanel(new FlowLayout(0, 5, 5));
        btnPanel.add(displayTrackBtn);
        btnPanel.add(trackingTargetBtn);
        jTable.add(btnPanel, BorderLayout.SOUTH);

        add(heightChartPanel);
        add(speedChartPanel);
        add(jTable);
    }
}
