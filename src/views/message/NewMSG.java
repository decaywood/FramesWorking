package views.message;

import data.MSG;
import utils.*;
import views.generalComponents.BorderLayoutPanel;
import views.generalComponents.LabelTextField;
import views.generalComponents.LabelTextFieldPanel;
import views.message.Components.NewMSGCenterPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class NewMSG extends JFrame implements Colleague<Map<String, String>> {

    protected NewMSGCenterPanel centerPanel;
    protected JPanel northPanel;
    protected JPanel leftPanel;
    protected JPanel rightPanel;
    protected LabelTextFieldPanel rightNorthPanel;
    protected JPanel rightSouthPanel;
    protected JPanel southPanel;
    protected JButton save = new JButton("保存");
    protected JButton exit = new JButton("退出");
    protected LabelTextField textFieldFDRID;
    protected JTextArea textArea;
    public NewMSG() {
        super("新建报文");
        ColleagueManager.Holder.MANAGER.register(NewMSG.class.getName(), NewMSG.this);
        init();
        addAction();
        setVisible(true);
    }

    private void init() {

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
        textFieldFDRID = new LabelTextField("FDRID", 100);
        leftPanel.add(new BorderLayoutPanel(textFieldFDRID, 130, 270), BorderLayout.CENTER);
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
        textArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(textArea);
        rightSouthPanel.add(jScrollPane, BorderLayout.CENTER);
        rightSouthPanel.setBorder(new TitledBorder("航路信息"));
        rightPanel.add(rightNorthPanel, BorderLayout.NORTH);
        rightPanel.add((rightSouthPanel), BorderLayout.CENTER);
        // -----------------------------------------------------
        container.add(northPanel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(southPanel, BorderLayout.SOUTH);
        northPanel.add(leftPanel, BorderLayout.WEST);
        northPanel.add(rightPanel, BorderLayout.CENTER);


        save = new JButton("保存");
        exit = new JButton("退出");
        southPanel.add(save, BorderLayout.WEST);
        southPanel.add(exit, BorderLayout.EAST);
    }

    private void addAction() {

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MSG msg = new MSG();
                msg.MSGTYPE = centerPanel.jComboBoxType.getItemAt(centerPanel.jComboBoxType.getSelectedIndex());
                msg.MSGHEAD = centerPanel.jTextAreaMSGHead.getText();
                msg.MSGBODY = centerPanel.jTextAreaMSGBody.getText();
                msg.FDRID = textFieldFDRID.getText();
                DataSender.addElement(msg);
                NewMSG.this.dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewMSG.this.dispose();
            }
        });

    }

    @Override
    public void setData(Map<String, String> data) {

        rightNorthPanel.updateTextField(data);
        textFieldFDRID.setText(data.get("FDRID"));
        textArea.setText(data.get("航路信息"));
        String dateTime = data.get("报文执行时间");
        Date[] date;
        date = StringUtils.timeTransform(dateTime);
        centerPanel.dateTextFieldTrack.setDate(date[0]);
        centerPanel.timeTextFieldTrack.setTime(date[1]);

    }

    @Override
    public void update() {

    }
}
