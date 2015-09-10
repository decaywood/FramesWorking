package views;

import views.track.TrackScenariosNorthPanel;

/**
 * @author: decaywood
 * @date: 2015/9/10 19:42
 */
public class TrackScenariosNorthPanelTest extends AbstractTestFrame {
    @Override
    protected void init() {
        add(new TrackScenariosNorthPanel());
    }

    public static void main(String[] args) {
        new TrackScenariosNorthPanelTest();
    }
}
