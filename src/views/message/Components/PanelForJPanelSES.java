package views.message.Components;

import utils.Colleague;
import utils.ColleagueManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSES extends JPanel implements Colleague<String> {

    private JScrollPane jScrollPane;
    private JTextArea jTextAreaContents;

    public PanelForJPanelSES() {

        super();
        ColleagueManager.Holder.MANAGER.register(PanelForJPanelSES.class.getName(), this);
        init();

    }

    public void init() {

        this.setLayout(new BorderLayout());

        jScrollPane = new JScrollPane();
        jScrollPane.setBorder(new TitledBorder("报文体"));
        this.add(jScrollPane, BorderLayout.CENTER);

        jTextAreaContents = new JTextArea();
        jTextAreaContents.setLineWrap(true);
        jScrollPane.setViewportView(jTextAreaContents);


    }

    @Override
    public void setData(String data) {
        if(data == null || data.equalsIgnoreCase("NULL")) return;
        jTextAreaContents.setText(data);
    }

    @Override
    public void update() {

    }
}
