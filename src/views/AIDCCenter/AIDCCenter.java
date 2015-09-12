package views.AIDCCenter;

import views.generalComponents.JEasyTable;
import views.generalComponents.ScenariosViewFrame;

import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class AIDCCenter extends ScenariosViewFrame {


    public AIDCCenter() {
        super("AIDC综合窗口", 1500, 800, 1000, 0);
    }

    @Override
    public Component setComponentsForJPanelN() {
        return new PanelForJPanelN();
    }

    @Override
    public Component setComponentsForJPanelSW() {
        return new JEasyTable();
    }

    @Override
    public Component setComponentsForJPanelSEC() {
        return new PanelForJPanelSEC();
    }

    @Override
    public Component setComponentsForJPanelSEW() {
        return new PanelForJPanelSEW();
    }
}
