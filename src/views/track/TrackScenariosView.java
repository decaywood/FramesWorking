package views.track;

import views.generalComponents.ScenariosViewFrame;
import views.track.Components.PanelForJPanelSEC;
import views.track.Components.PanelForJPanelSES;
import views.track.Components.PanelForJPanelSW;
import views.track.Components.PanelForJPanelN;

import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-11
 */

public class TrackScenariosView extends ScenariosViewFrame {

    public TrackScenariosView() {

        super("航迹剧本View");

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
