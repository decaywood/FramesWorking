package views.track;

import data.FDR;
import data.TRACK;
import data.TreeElement;
import utils.*;
import views.generalComponents.BorderLayoutPanel;
import views.generalComponents.LabelTextField;
import views.generalComponents.LabelTextFieldPanel;
import views.track.Components.NewTrackCenterPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class ModifyTrack extends JFrame implements Colleague<TreeElement>{

    private NewTrackCenterPanel centerPanel;
    private LabelTextField labelTextField;
    private LabelTextFieldPanel rightNorthPanel;
    private JTextArea textArea;
    private TRACK track;
    public ModifyTrack() {
        super("编辑航迹");
        init();
        ColleagueManager.Holder.MANAGER.register(ModifyTrack.class.getName(), this);
        setVisible(true);
    }

    private void init() {
        JPanel northPanel;
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
        rightSouthPanel.setPreferredSize(new Dimension(570, 135));
        rightSouthPanel.setBorder(new TitledBorder("航路信息"));
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

        JButton save = new JButton("保存");
        JButton exit = new JButton("退出");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = centerPanel.jTextAreaContents.getText().replaceAll("\n", "");
                TRACK element = (TRACK) track.clone();
                element.TYPECMD = "02";
                DataSender.send(element.extractFromBody(str));
                ModifyTrack.this.dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyTrack.this.dispose();
            }
        });
        southPanel.add(save, BorderLayout.WEST);
        southPanel.add(exit, BorderLayout.EAST);
    }

    @Override
    public void setData(TreeElement data) {
        track = (TRACK) data;
        FDR fdr = (FDR) track.parent;
        Map<String, String> map = new HashMap<>();
        for (Field field : FDR.class.getDeclaredFields()) {
            try {
                map.put(field.getName(), (String)field.get(fdr));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        labelTextField.setText(fdr.OBJID);
        rightNorthPanel.updateTextField(map);
        Date[] dates = StringUtils.timeTransform(track.PERFORMMSGTIME);
        if (dates.length == 2) {
            centerPanel.dateTextFieldTrack.setDate(dates[0]);
            centerPanel.timeTextFieldTrack.setTime(dates[1]);
        }
        centerPanel.jTextAreaContents.setText(track.extractPoints(new StringBuilder()));
        for (TRACK.Point point : track.TRACKBODY) {
            FieldsVector<String> fieldsVector = new FieldsVector<>();
            for (int i = 0; i < centerPanel.columNames.size(); i++) {

                try {
                    String colName = centerPanel.columNames.get(i);
                    String val = (String) TRACK.Point.class.getField(colName).get(point);
                    fieldsVector.addElement(val);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            centerPanel.dataSet.add(fieldsVector);
            textArea.setLineWrap(true);
            textArea.setText(fdr.RTE);
        }
    }

    @Override
    public void update() {

    }
}
