package views.plan;

import views.generalComponents.ScenariosViewFrame;
import views.plan.Components.PanelForJPanelN;
import views.plan.Components.PanelForJPanelSEC;
import views.plan.Components.PanelForJPanelSES;
import views.plan.Components.PanelForJPanelSW;

import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class FlightPlans extends ScenariosViewFrame {

    public FlightPlans() {

        super("飞行计划列表");

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
