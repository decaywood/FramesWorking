package views.controlCenter;

import utils.Colleague;
import utils.ColleagueManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author mamamiyear
 * @date 15-9-12
 */

public class PanelForJPanelSEE extends JPanel implements Colleague<ArrayList<String>> {

    private JScrollPane jPanelMSGHead;
    private JScrollPane jPanelMSGBody;
    private JScrollPane jPanelTrackBody;
    private JTextArea jTextAreaMSGHead;
    private JTextArea jTextAreaMSGBody;
    private JTextArea jTextAreaTrackBody;

    public PanelForJPanelSEE() {

        super();
        init();

    }

    private void init() {

        this.setLayout(new GridLayout(3, 1, 0, 0));
        this.setPreferredSize(new Dimension(400, 700));

        jPanelMSGHead = new JScrollPane();
        jPanelMSGHead.setBorder(new TitledBorder("报头"));
        jTextAreaMSGHead = new JTextArea();
        jTextAreaMSGHead.setLineWrap(true);
        jPanelMSGHead.setViewportView(jTextAreaMSGHead);

        jPanelMSGBody = new JScrollPane();
        jPanelMSGBody.setBorder(new TitledBorder("报文体"));
        jTextAreaMSGBody = new JTextArea();
        jTextAreaMSGBody.setLineWrap(true);
        jPanelMSGBody.setViewportView(jTextAreaMSGBody);

        jPanelTrackBody = new JScrollPane();
        jPanelTrackBody.setBorder(new TitledBorder("航迹剧本内容"));
        jTextAreaTrackBody = new JTextArea();
        jTextAreaTrackBody.setLineWrap(true);
        jPanelTrackBody.setViewportView(jTextAreaTrackBody);

        this.add(jPanelMSGHead);
        this.add(jPanelMSGBody);
        this.add(jPanelTrackBody);

        ColleagueManager.Holder.MANAGER.register(PanelForJPanelSEE.class.getName(), PanelForJPanelSEE.this);

    }

    public void setMSGHead(String text) {

        jTextAreaMSGHead.setText(text);

    }

    public void setMSGBody(String text) {

        jTextAreaMSGBody.setText(text);

    }

    public void setTrackBody(String text) {

        jTextAreaTrackBody.setText(text);

    }


    @Override
    public void setData(ArrayList<String> data) {

        if (data.get(0) != null) {
            setMSGHead(data.get(0));
        }

        if (data.get(1) != null) {
            setMSGBody(data.get(1));
        }

        if (data.get(2) != null) {
            setTrackBody(data.get(2));
        }

    }

    @Override
    public void update() {

    }
}
