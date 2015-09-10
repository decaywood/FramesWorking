package views.newTrack;

import views.generalComponents.BorderLayoutPanel;
import views.generalComponents.LabelTextField;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author: decaywood
 * @date: 2015/9/9 15:33
 */
public class NewTrack extends JFrame {


    public NewTrack() {
        super("新建航迹");
        init();
    }

    private void init() {
        JPanel northPanel;
        JPanel centerPanel;
        JPanel leftPanel;
        JPanel rightPanel;
        JPanel rightNorthPanel;
        JPanel rightSouthPanel;
        JPanel southPanel;

        setBounds(0, 0, 700, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        northPanel = new JPanel(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(700, 270));
        northPanel.setBorder(new TitledBorder("所属FDR信息"));
        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(700, 50));
        centerPanel = new NewTrackCenterPanel();
        centerPanel.setPreferredSize(new Dimension(480, 270));

        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(new TitledBorder(""));
        leftPanel.add(new BorderLayoutPanel(new LabelTextField("FDR ID", 100), 130, 270), BorderLayout.CENTER);
        // ------------- right ---------------------------------
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(430, 0));

        rightNorthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rightNorthPanel.setPreferredSize(new Dimension(430, 135));
        rightNorthPanel.add(new LabelTextField("FLIGHT ID", 100));
        rightNorthPanel.add(new LabelTextField("DEP", 100));
        rightNorthPanel.add(new LabelTextField("DES", 100));
        rightNorthPanel.add(new LabelTextField("ACTYPE", 100));
        rightNorthPanel.add(new LabelTextField("RFL", 100));
        rightNorthPanel.add(new LabelTextField("TAS", 100));
        rightNorthPanel.setPreferredSize(new Dimension(570, 135));

        rightSouthPanel = new JPanel(new BorderLayout());
        rightSouthPanel.setBorder(new TitledBorder("航路信息"));
        rightSouthPanel.setPreferredSize(new Dimension(570, 135));
        rightSouthPanel.setBorder(new TitledBorder(""));
        JTextArea textArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(textArea);
        rightSouthPanel.add(jScrollPane, BorderLayout.CENTER);

        rightPanel.add(rightNorthPanel, BorderLayout.NORTH);
        rightPanel.add((rightSouthPanel), BorderLayout.CENTER);
        // -----------------------------------------------------
        container.add(northPanel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(southPanel, BorderLayout.SOUTH);
        northPanel.add(leftPanel, BorderLayout.WEST);
        northPanel.add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton save = new JButton("保存");
        JButton exit = new JButton("退出");
        southPanel.add(save, BorderLayout.WEST);
        southPanel.add(exit, BorderLayout.EAST);
    }


}
