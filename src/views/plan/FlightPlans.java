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
