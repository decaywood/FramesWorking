package views.plan.Components;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSW extends JPanel {

    private JTableFDR jTableFDR;

    public PanelForJPanelSW() {

        super();
        init();

    }

    public void init() {

        this.setLayout(new BorderLayout());
        jTableFDR = new JTableFDR();
        jTableFDR.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.add(jTableFDR, BorderLayout.CENTER);

    }

}
