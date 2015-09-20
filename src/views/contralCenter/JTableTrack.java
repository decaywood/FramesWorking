package views.contralCenter;

import data.TRACK;
import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import utils.FieldsVector;
import views.generalComponents.JEasyTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-17
 */

public class JTableTrack extends JEasyTable implements Colleague<List<TreeElement>> {

    public JTableTrack() {

        this(new Vector<String>(), new Vector<FieldsVector<String>>());

    }

    public JTableTrack(String borderTitle) {

        this(borderTitle, new Vector<String>(), new Vector<FieldsVector<String>>(), true);

    }

    public JTableTrack(Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JTableTrack(Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JTableTrack(String borderTitle, Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas, boolean popupMenuEnable) {

        super(borderTitle, tableColumnName, tableDatas, popupMenuEnable);
        List<String> itemNames = new ArrayList<String>();
        addPopupMenuItems("添加", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addPopupMenuItems("修改", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addPopupMenuItems("删除", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ColleagueManager.Holder.MANAGER.register("JTableTrackForControlCenter", JTableTrack.this);

    }

    @Override
    public void setData(List<TreeElement> data) {
        Vector<FieldsVector<String>> dataSet = new Vector<FieldsVector<String>>();
        Vector<String> columnName = new Vector<String>();

        Field[] fields = TRACK.class.getFields();
        for (Field field : fields) {
            try {
                columnName.addElement(field.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (TreeElement element : data) {
            if (element.getElementType() == TreeElement.ElementType.MSG_TRACK) {

                System.out.println("MSG " + element.toString());
                if (element instanceof TRACK) {
                    FieldsVector<String> oneData = new FieldsVector<String>();
                    for (Field field : fields) {
                        try {
                            if(field.get(element) == null) {
                                oneData.addElement("");
                            } else {
                                oneData.addElement(field.get(element).toString());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    dataSet.addElement(oneData);
                }

            } else {
                System.out.println(element.getElementName() + "不是MSG或者Track.");
            }
        }

        setColumnNames(columnName);
        setDatas(dataSet);
    }

    @Override
    public void update() {

    }

}
