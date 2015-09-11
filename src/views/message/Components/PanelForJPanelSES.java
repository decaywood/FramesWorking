package views.message.Components;

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

    public PanelForJPanelSES() {

        super();
        init();

    }

    public void init() {

        this.setLayout(new BorderLayout());

        jScrollPane = new JScrollPane();
        jScrollPane.setBorder(new TitledBorder("报文体"));
        this.add(jScrollPane, BorderLayout.CENTER);

        jTextAreaContents = new JTextArea();
        jScrollPane.setViewportView(jTextAreaContents);


    }

}
