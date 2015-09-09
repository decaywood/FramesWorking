package views.generalComponents;

import javax.swing.*;
import java.awt.*;

/**
 * @author: decaywood
 * @date: 2015/9/9 17:24
 */
public class BorderLayoutPanel extends JPanel {

    public BorderLayoutPanel(JComponent component, int width, int height) {
        setLayout(new BorderLayout());
        int componentWidth = (int) component.getPreferredSize().getWidth();
        int componentHeight = (int) component.getPreferredSize().getHeight();
        int dummyWidth = (width - componentWidth) / 2;
        int dummyHeight = (height - componentHeight) / 2;
        JPanel dummyPanelW = new JPanel();
        JPanel dummyPanelE = new JPanel();
        dummyPanelW.setPreferredSize(new Dimension(dummyWidth, 0));
        dummyPanelE.setPreferredSize(new Dimension(dummyWidth, 0));
        JPanel dummyPanelN = new JPanel();
        dummyPanelN.setPreferredSize(new Dimension(0, dummyHeight - 28));
        JPanel dummyPanelS = new JPanel();
        dummyPanelS.setPreferredSize(new Dimension(0, dummyHeight));
        add(dummyPanelN, BorderLayout.NORTH);
        add(dummyPanelS, BorderLayout.SOUTH);
        add(component, BorderLayout.CENTER);
        add(dummyPanelW, BorderLayout.WEST);
        add(dummyPanelE, BorderLayout.EAST);
    }
}
