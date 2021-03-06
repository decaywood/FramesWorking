package views.track;

import data.TRACK;
import utils.Colleague;
import utils.ColleagueManager;
import utils.Pair;
import views.generalComponents.BorderLayoutPanel;
import views.generalComponents.LabelTextField;
import views.generalComponents.LabelTextFieldPanel;
import views.track.Components.NewTrackCenterPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/9 15:33
 */
public class NewTrack extends JFrame implements Colleague<Map<String, String>> {

    private LabelTextFieldPanel rightNorthPanel;
    private LabelTextField labelTextField;
    private JTextArea textArea;
    public NewTrack() {
        super("新建航迹");
        init();
        ColleagueManager.Holder.MANAGER.register(NewTrack.class.getName(), this);
        setVisible(true);
    }

    private void init() {
        JPanel northPanel;
        JPanel centerPanel;
        JPanel leftPanel;
        JPanel rightPanel;
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
        centerPanel = new NewTrackCenterPanel();
        centerPanel.setPreferredSize(new Dimension(480, 270));

        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(new TitledBorder(""));
        labelTextField = new LabelTextField("FDRID", 100);
        leftPanel.add(new BorderLayoutPanel(labelTextField, 130, 270), BorderLayout.CENTER);
        // ------------- right ---------------------------------
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(430, 0));

        List<Pair> pairs = new ArrayList<>();
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
        textArea = new JTextArea();
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
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TRACK track = new TRACK();
                track.TYPECMD = "01";



                NewTrack.this.dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewTrack.this.dispose();
            }
        });
        southPanel.add(save, BorderLayout.WEST);
        southPanel.add(exit, BorderLayout.EAST);

    }


    @Override
    public void setData(Map<String, String> data) {
        labelTextField.setText(data.get("FDRID"));
        rightNorthPanel.updateTextField(data);
        textArea.setText(data.get("RTE"));
    }

    @Override
    public void update() {

    }
}
