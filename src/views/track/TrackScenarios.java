package views.track;

import views.generalComponents.ScenariosViewFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class TrackScenarios extends ScenariosViewFrame {



    public TrackScenarios() {

        super("航迹剧本列表");

    }

    @Override
    public Component getComponentsForJPanelN() {
        return new JPanel();
    }

    @Override
    public Component getComponentsForJPanelSW() {
        return new PanelForJPanelSW();
    }

    @Override
    public Component getComponentsForJPanelSEC() {
        return new PanelForJPanelSEC();
    }

    @Override
    public Component getComponentsForJPanelSES() {
        return new PanelForJPanelSES();
    }
}
