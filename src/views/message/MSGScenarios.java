package views.message;

import views.generalComponents.ScenariosViewFrame;
import views.message.Components.PanelForJPanelSEC;
import views.message.Components.PanelForJPanelSES;
import views.message.Components.PanelForJPanelSW;
import views.message.Components.PanelForJPanelN;

import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class MSGScenarios extends ScenariosViewFrame {



    public MSGScenarios() {

        super("MSG剧本列表");

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
