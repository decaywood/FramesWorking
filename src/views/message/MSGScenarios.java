package views.message;

import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import views.generalComponents.ScenariosViewFrame;
import views.message.Components.*;

import java.util.List;
import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class MSGScenarios extends ScenariosViewFrame implements Colleague<List<TreeElement>> {



    public MSGScenarios() {

        super("MSG剧本列表");
        ColleagueManager.Holder.MANAGER.register(MSGScenarios.class.getName(), this);
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
        ColleagueManager.Holder.MANAGER.setData(JTableMSG.class.getName(), data);
    }

    @Override
    public void update() {

    }
}
