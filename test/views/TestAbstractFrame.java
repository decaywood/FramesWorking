package views;

import views.generalComponents.ScenariosViewFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class TestAbstractFrame extends ScenariosViewFrame {

    public TestAbstractFrame() {
        super("title");
    }

    @Override
    public Component getComponentsForJPanelN() {
        return new JPanel();
    }

    @Override
    public Component getComponentsForJPanelSW() {
        return new JPanel();
    }

    @Override
    public Component getComponentsForJPanelSEC() {
        return new JPanel();
    }

    @Override
    public Component getComponentsForJPanelSES() {
        return new JPanel();
    }
}
