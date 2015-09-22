package views.track;

import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import views.generalComponents.ScenariosViewFrame;
import views.track.Components.PanelForJPanelSEC;
import views.track.Components.PanelForJPanelSES;
import views.track.Components.PanelForJPanelSW;
import views.track.Components.PanelForJPanelN;
import java.util.List;
import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class TrackScenarios extends ScenariosViewFrame implements Colleague<List<TreeElement>>{



    public TrackScenarios() {

        super("航迹剧本列表");
        ColleagueManager.Holder.MANAGER.register(TrackScenarios.class.getName(), this);

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
