package views.message;

import utils.Pair;
import views.generalComponents.BorderLayoutPanel;
import views.generalComponents.LabelTextField;
import views.generalComponents.LabelTextFieldPanel;
import views.message.Components.NewMSGCenterPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class NewMSG extends JFrame {

    public NewMSG() {
        super("新建报文");
        init();
        setVisible(true);
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
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        northPanel = new JPanel(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(700, 270));
        northPanel.setBorder(new TitledBorder("所属FDR信息"));
        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(700, 50));
        centerPanel = new NewMSGCenterPanel();
        centerPanel.setPreferredSize(new Dimension(480, 270));

        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(new TitledBorder(""));
        leftPanel.add(new BorderLayoutPanel(new LabelTextField("FDRID", 100), 130, 270), BorderLayout.CENTER);
        // ------------- right ---------------------------------
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(430, 0));

        java.util.List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair("FLIGHTID", 100));
        pairs.add(new Pair("DEP", 100));
        pairs.add(new Pair("DES", 100));
        pairs.add(new Pair("ACTYPE", 100));
        pairs.add(new Pair("RFL", 100));
        pairs.add(new Pair("TAS", 100));
        rightNorthPanel = new LabelTextFieldPanel(pairs);
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

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton save = new JButton("保存");
        JButton exit = new JButton("退出");
        southPanel.add(save, BorderLayout.WEST);
        southPanel.add(exit, BorderLayout.EAST);
    }

}
