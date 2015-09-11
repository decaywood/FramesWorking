package views.plan.Components;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSES extends JPanel {

    private JScrollPane jScrollPane;
    private JTextArea jTextAreaContents;
    private JPanel jPanel;
    private JButton jButtonShowTrack;

    public PanelForJPanelSES() {

        super();
        init();

    }

    public void init() {

        this.setLayout(new BorderLayout());

        jScrollPane = new JScrollPane();
        jScrollPane.setBorder(new TitledBorder("航路信息"));
        this.add(jScrollPane, BorderLayout.CENTER);

        jTextAreaContents = new JTextArea();
        jScrollPane.setViewportView(jTextAreaContents);

        jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(0, 50));
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 3));
        jPanel.setBorder(new TitledBorder("命令"));
        this.add(jPanel, BorderLayout.SOUTH);

        jButtonShowTrack = new JButton("显示航路");
        jButtonShowTrack.setPreferredSize(new Dimension(120, 25));
        jPanel.add(jButtonShowTrack);
    }

}
