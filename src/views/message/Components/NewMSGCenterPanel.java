package views.message.Components;

import views.generalComponents.DateTextField;
import views.generalComponents.TimeTextField;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Vector;

/**
 * Created by mamamiyear on 15-9-9.
 */
public class NewMSGCenterPanel extends JPanel {

    private JPanel[] jPanels;
    private JPanel jPanelN;
    private TitledBorder[] paneltitles;
    private JButton jButtonChangeTime;
    private DateTextField dateTextFieldTrack;
    private TimeTextField timeTextFieldTrack;
    private JComboBox<String> jComboBoxType;
    private Vector<String> typeNames;
    private JScrollPane jScrollPaneMSGHead;
    private JTextArea jTextAreaMSGHead;
    private JScrollPane jScrollPaneMSGBody;
    private JTextArea jTextAreaMSGBody;


    public NewMSGCenterPanel() {
        init();
    }

    public void init() {

        this.setLayout(new BorderLayout());

        jPanels = new JPanel[4];
        paneltitles = new TitledBorder[4];
        jPanelN = new JPanel();

        for (int i = 0; i < 4; i++) {
            jPanels[i] = new JPanel();
            jPanels[i].setLayout(new BorderLayout());
            paneltitles[i] = new TitledBorder("");
            jPanels[i].setBorder(paneltitles[i]);
        }

        paneltitles[0].setTitle("报文执行时间");
        paneltitles[1].setTitle("报文类型");
        paneltitles[2].setTitle("报头");
        paneltitles[3].setTitle("报文体");

        jButtonChangeTime = new JButton("修改时间");
        dateTextFieldTrack = new DateTextField();
        timeTextFieldTrack = new TimeTextField();
        jPanels[0].setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        jPanels[0].setPreferredSize(new Dimension(700, 60));
        jPanels[0].add(dateTextFieldTrack);
        jPanels[0].add(timeTextFieldTrack);
        jPanels[0].add(jButtonChangeTime);

        typeNames = new Vector<String>();
        typeNames.add("AFTN FPL");
        jComboBoxType = new JComboBox<>(typeNames);
        jComboBoxType.setPreferredSize(new Dimension(120, 25));
        jPanels[1].setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        jPanels[1].setPreferredSize(new Dimension(700, 60));
        jPanels[1].add(jComboBoxType);

        jPanelN.setLayout(new BorderLayout());
        jPanelN.setPreferredSize(new Dimension(700, 120));
        jPanelN.add(jPanels[0], BorderLayout.NORTH);
        jPanelN.add(jPanels[1], BorderLayout.SOUTH);
        this.add(jPanelN, BorderLayout.NORTH);

        jScrollPaneMSGHead = new JScrollPane();
        jTextAreaMSGHead = new JTextArea();
        jScrollPaneMSGHead.setViewportView(jTextAreaMSGHead);
        jPanels[2].add(jScrollPaneMSGHead, BorderLayout.CENTER);
        this.add(jPanels[2], BorderLayout.CENTER);

        jScrollPaneMSGBody = new JScrollPane();
        jTextAreaMSGBody = new JTextArea();
        jScrollPaneMSGBody.setViewportView(jTextAreaMSGBody);
        jPanels[3].setPreferredSize(new Dimension(700, 200));
        jPanels[3].add(jScrollPaneMSGBody, BorderLayout.CENTER);
        this.add(jPanels[3], BorderLayout.SOUTH);

    }

}
