package views.AIDCCenter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author: decaywood
 * @date: 2015/9/11 21:44
 */
public class PanelForJPanelSEW extends JPanel {

    public PanelForJPanelSEW() {
        setBorder(new TitledBorder("报文收发情况"));
        setPreferredSize(new Dimension(500, 700));
        setLayout(new GridLayout(2, 1, 0, 0));
        init();
    }

    private void init() {
        JPanel northPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        northPanel.setBorder(new TitledBorder(""));
        JPanel northLeftPanel = new JPanel(new GridLayout(2, 1, 0, 0));

        JTable northLeftUpTable = new JTable();
        JTable northLefDownTable = new JTable();

        northLeftPanel.add(northLeftUpTable);
        northLeftPanel.add(northLefDownTable);
        northPanel.add(northLeftPanel);

        JTable northRightPanel = new JTable();
        northPanel.add(northRightPanel);

        JPanel southPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        JPanel southLeftPanel = new JPanel(new BorderLayout());
        southLeftPanel.setBorder(new TitledBorder(""));
        JTextArea leftArea = new JTextArea();
        JButton souLeftButton = new JButton("清空");
        southLeftPanel.add(leftArea, BorderLayout.CENTER);
        southLeftPanel.add(souLeftButton, BorderLayout.SOUTH);
        JPanel southRightPanel = new JPanel(new BorderLayout());
        southRightPanel.setBorder(new TitledBorder(""));
        JTextArea rightArea = new JTextArea();
        JButton souRightButton = new JButton("清空");
        southRightPanel.add(rightArea, BorderLayout.CENTER);
        southRightPanel.add(souRightButton, BorderLayout.SOUTH);
        southPanel.add(southLeftPanel);
        southPanel.add(southRightPanel);

        add(northPanel);
        add(southPanel);

    }
}
