package views.plan;

import views.generalComponents.ScenariosViewFrame;
import views.plan.Components.PanelForJPanelN;
import views.plan.Components.PanelForJPanelSEC;
import views.plan.Components.PanelForJPanelSES;
import views.plan.Components.PanelForJPanelSW;

import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-11
 */

public class FlightPlansView extends ScenariosViewFrame {
    public FlightPlansView() {

        super("飞行计划View");

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
