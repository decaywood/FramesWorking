package views.controlCenter;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-12
 */

public class PanelForJPanelSEC extends JPanel {

    private JTableMSG jtableMSG;
    private JTableTrack jtableTrack;

    public PanelForJPanelSEC() {

        super();
        init();

    }

    private void init() {

        this.setLayout(new GridLayout(2, 1, 0, 0));
        jtableMSG = new JTableMSG("MSG剧本");
        jtableMSG.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtableTrack = new JTableTrack("Track剧本");
        jtableTrack.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.add(jtableMSG);
        this.add(jtableTrack);

    }

    private void initAction() {



    }

}
