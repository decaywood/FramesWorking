package views.contralCenter;

import utils.FieldsVector;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private Vector<FieldsVector<String>> tableMSGDatas;
    private Vector<FieldsVector<String>> tableTrackDatas;


    public PanelForJPanelSEC() {

        super();
        init();

    }

    private void init() {

        this.setLayout(new GridLayout(2, 1, 0, 0));

        tableMSGColumnNames = new Vector<String>();
        tableTrackColumnNames = new Vector<String>();
        try {
            File file = new File("./textFiles/JTableMSGColumnNames");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = reader.readLine()) != null) {
                tableMSGColumnNames.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file = new File("./textFiles/JTableTrackColumnNames");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = reader.readLine()) != null) {
                tableTrackColumnNames.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        tableMSGDatas = new Vector<FieldsVector<String>>();
        tableTrackDatas = new Vector<FieldsVector<String>>();

        jtableMSG = new JTableMSG("MSG剧本", tableMSGColumnNames, tableMSGDatas, true);
        jtableMSG.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtableTrack = new JTableTrack("Track剧本", tableTrackColumnNames, tableTrackDatas, true);
        jtableTrack.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.add(jtableMSG);
        this.add(jtableTrack);

    }

    private void initAction() {



    }

}
