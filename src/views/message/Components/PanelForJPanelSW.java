package views.message.Components;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSW extends JPanel {

    private JTableMSG jTableMSG;

    public PanelForJPanelSW() {

        super();
        init();

    }

    public void init() {

        this.setLayout(new BorderLayout());
        jTableMSG = new JTableMSG();
        jTableMSG.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.add(jTableMSG, BorderLayout.CENTER);

    }


}
