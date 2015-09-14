package views.track;

import views.generalComponents.ScenariosViewFrame;
import views.track.Components.PanelForJPanelSEC;
import views.track.Components.PanelForJPanelSES;
import views.track.Components.PanelForJPanelSW;
import views.track.Components.PanelForJPanelN;

import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class TrackScenarios extends ScenariosViewFrame {



    public TrackScenarios() {

        super("航迹剧本列表");

    }

    @Override
    public Component setComponentsForJPanelN() {
        return new PanelForJPanelN();
    }

    @Override
    public Component setComponentsForJPanelSW() {
        return new PanelForJPanelSW();
    }

    @Override
    public Component setComponentsForJPanelSEC() {
        return new PanelForJPanelSEC();
    }

    @Override
    public Component setComponentsForJPanelSES() {
        return new PanelForJPanelSES();
    }
}
