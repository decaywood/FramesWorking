package views;

import view.newTrackPanel.NewTrackCenterPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mamamiyear on 15-9-9.
 */
public class TestFrame extends JFrame {

    private JButton[] jButtons = new JButton[5];
    private Container container;

    public TestFrame() {
        super("测试");
        init();
        //构造器最后一行
        setVisible(true);
    }

    private void init() {

        setExtendedState(MAXIMIZED_BOTH);
        setBounds(0, 0, 1200, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        JPanel jPanelButtons = new JPanel();
        jPanelButtons.setPreferredSize(new Dimension(100, 100));
        jPanelButtons.setLayout(new FlowLayout(1, 5, 5));

        for (int i = 0; i < 5; i++) {
            jButtons[i] = new JButton("Button" + i);
            jButtons[i].setPreferredSize(new Dimension(100,30));
            jPanelButtons.add(jButtons[i]);
        }
        container.add(jPanelButtons, BorderLayout.SOUTH);

        addComponents(new NewTrackCenterPanel());

    }

    private void addComponents(JPanel panel) {

        container.add(panel, BorderLayout.CENTER);

    }


}
