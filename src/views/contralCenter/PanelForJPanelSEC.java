package views.contralCenter;

import views.generalComponents.JEasyTable;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-12
 */

public class PanelForJPanelSEC extends JPanel {

    private JTableMSG jtableMSG;
    private JTableTrack jtableTrack;

    private Vector<String> tableMSGColumnNames;
    private Vector<String> tableTrackColumnNames;
    private Vector<Vector<String>> tableMSGDatas;
    private Vector<Vector<String>> tableTrackDatas;


    public PanelForJPanelSEC() {

        super();
        init();

    }

    private void init() {

        this.setLayout(new GridLayout(2, 1, 0, 0));

        tableMSGColumnNames = new Vector<String>();
        tableTrackColumnNames = new Vector<String>();
        tableMSGDatas = new Vector<Vector<String>>();
        tableTrackDatas = new Vector<Vector<String>>();

        jtableMSG = new JTableMSG("MSG剧本", tableMSGColumnNames, tableMSGDatas, true);
        jtableMSG.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtableTrack = new JTableTrack("Track剧本", tableTrackColumnNames, tableTrackDatas, true);
        jtableTrack.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.add(jtableMSG);
        this.add(jtableTrack);

    }

}
