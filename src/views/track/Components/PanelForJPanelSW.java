package views.track.Components;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSW extends JPanel {



    private JTableTrack jTableTrack;

    public PanelForJPanelSW() {

        super();
        init();

    }

    public void init() {

        this.setLayout(new BorderLayout());
        jTableTrack = new JTableTrack();
        jTableTrack.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.add(jTableTrack, BorderLayout.CENTER);

    }

}
