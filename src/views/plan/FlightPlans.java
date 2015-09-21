package views.plan;

import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import views.generalComponents.ScenariosViewFrame;
import views.plan.Components.PanelForJPanelN;
import views.plan.Components.PanelForJPanelSEC;
import views.plan.Components.PanelForJPanelSES;
import views.plan.Components.PanelForJPanelSW;

import java.awt.*;
import java.util.List;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class FlightPlans extends ScenariosViewFrame implements Colleague<List<TreeElement>> {

    public FlightPlans() {

        super("飞行计划列表");
        ColleagueManager.Holder.MANAGER.register("FlightPlans", this);
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

    @Override
    public void setData(List<TreeElement> data) {

    }

    @Override
    public void update() {

    }
}
