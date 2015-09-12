package views.AIDCCenter;

import views.generalComponents.JEasyChartBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/11 21:44
 */
public class PanelForJPanelSEC extends JPanel {


    public PanelForJPanelSEC() {

        // --------------- for test ----------------------
        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list1.add(i - 25 * Math.random());
            list2.add(i - 25 * Math.random());
        }
        // --------------- for test ----------------------
        setLayout(new GridLayout(3, 1, 0, 0));
        JPanel heightChartPanel = new JEasyChartBuilder()
                .createDataset("", list1)
                .createChart("高度与时间", "", "").buildPanel();

        JPanel speedChartPanel = new JEasyChartBuilder()
                .createDataset("", list2)
                .createChart("速度与时间", "", "").buildPanel();

        JTable jTable = new JTable();

        add(heightChartPanel);
        add(speedChartPanel);
        add(jTable);

    }
}
