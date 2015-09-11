package views.message;

import views.generalComponents.ScenariosViewFrame;
import views.message.Components.PanelForJPanelN;
import views.message.Components.PanelForJPanelSEC;
import views.message.Components.PanelForJPanelSES;
import views.message.Components.PanelForJPanelSW;

import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-11
 */

public class MSGScenariosView extends ScenariosViewFrame {


    public MSGScenariosView() {

        super("MSG剧本View");

    }

    @Override
    public Component getComponentsForJPanelN() {
        return new PanelForJPanelN();
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
