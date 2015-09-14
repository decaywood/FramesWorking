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
    public Component setComponentsForJPanelN() {
        return new JPanel();
    }

    @Override
    public Component setComponentsForJPanelSW() {
        return new JPanel();
    }

    @Override
    public Component setComponentsForJPanelSEC() {
        return new JPanel();
    }

    @Override
    public Component setComponentsForJPanelSES() {
        return new JPanel();
    }
}
