package views.track;

import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import views.generalComponents.ScenariosViewFrame;
import views.track.Components.*;

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
        ColleagueManager.Holder.MANAGER.setData(JTableTrack.class.getName(), data);
    }

    @Override
    public void update() {

    }
}
