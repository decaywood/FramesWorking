package views.controlCenter;

import utils.Colleague;
import utils.ColleagueManager;
import utils.DataSender;
import utils.ReceiveInstruction;
import views.generalComponents.ScenariosViewFrame;

import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class ScenarioControlCenter extends ScenariosViewFrame implements Colleague<String> {

    public ReceiveInstruction receive;

    public ScenarioControlCenter() {
        super("动态剧本控制中心", 1500, 800, 800, 0);
        ColleagueManager.Holder.MANAGER.register(ScenarioControlCenter.class.getName(), ScenarioControlCenter.this);

        receive = new ReceiveInstruction("192.168.1.255", 10001);

        String getTreeInstruction = "BEGIN=CMD|"+
                "TYPECMD=09|" + "TYPEOBJ=NULL|" +
                "OBJID=NULL|" + "SCENARIOID=NULL|" +
                "FDRID=NULL|" + "BEGIN=CONTENTCMD|" +
                "GETTYPE=TREE|" + "END=CONTENTCMD|" + "END=CMD|";
        DataSender.send(getTreeInstruction);

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
