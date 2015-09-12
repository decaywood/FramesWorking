package views.AIDCCenter;

import views.generalComponents.ScenariosViewFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class AIDCCenter extends ScenariosViewFrame {


    public AIDCCenter() {
        super("AIDC综合窗口", 1500, 800, 1000, 0);
    }

    @Override
    public Component getComponentsForJPanelN() {
        return new PanelForJPanelN();
    }

    @Override
    public Component getComponentsForJPanelSW() {
        return new JTable();
    }

    @Override
    public Component getComponentsForJPanelSEC() {
        return new PanelForJPanelSEC();
    }

    @Override
    public Component getComponentsForJPanelSEW() {
        return new PanelForJPanelSEW();
    }
}
