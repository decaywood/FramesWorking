package views.controlCenter;

import utils.Colleague;
import utils.ColleagueManager;
import views.generalComponents.ScenariosViewFrame;

import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class ScenarioControlCenter extends ScenariosViewFrame implements Colleague<String> {


    public ScenarioControlCenter() {
        super("动态剧本控制中心", 1500, 800, 800, 0);
        ColleagueManager.Holder.MANAGER.register(ScenarioControlCenter.class.getName(), ScenarioControlCenter.this);

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
    public Component setComponentsForJPanelSEE() {
        return new PanelForJPanelSEE();
    }

    @Override
    public Component setComponentsForJPanelSEC() {
        return new PanelForJPanelSEC();
    }

    @Override
    public void setData(String data) {

    }

    @Override
    public void update() {

    }
}
