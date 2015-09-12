package views.contralCenter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-12
 */

public class PanelForJPanelSEE extends JPanel {

    private JPanel jPanelMSGHead;
    private JPanel jPanelMSGBody;
    private JPanel jPanelTrackBody;
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

        jPanelMSGHead = new JPanel();
        jPanelMSGHead.setBorder(new TitledBorder("报头"));
        jPanelMSGHead.setLayout(new BorderLayout());
        jTextAreaMSGHead = new JTextArea();
        jPanelMSGHead.add(jTextAreaMSGHead, BorderLayout.CENTER);

        jPanelMSGBody = new JPanel();
        jPanelMSGBody.setBorder(new TitledBorder("报文体"));
        jPanelMSGBody.setLayout(new BorderLayout());
        jTextAreaMSGBody = new JTextArea();
        jPanelMSGBody.add(jTextAreaMSGBody, BorderLayout.CENTER);

        jPanelTrackBody = new JPanel();
        jPanelTrackBody.setBorder(new TitledBorder("报头"));
        jPanelTrackBody.setLayout(new BorderLayout());
        jTextAreaTrackBody = new JTextArea();
        jPanelTrackBody.add(jTextAreaTrackBody, BorderLayout.CENTER);

        this.add(jPanelMSGHead);
        this.add(jPanelMSGBody);
        this.add(jPanelTrackBody);

    }


}
