package views.track.Components;

import data.TRACK;
import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import utils.FieldsVector;
import views.generalComponents.JEasyTable;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-21
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
        addTableSelectedAction();
        ColleagueManager.Holder.MANAGER.register("JTableTrackForControlCenter", JTableTrack.this);

    }

    private void addTableSelectedAction() {

        ListSelectionListener selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;//仅在鼠标抬起时触发

            }
        };

        this.setTableSelectedAction(selectionListener);

    }

    public class Searcher implements Colleague<Map<String, String>> {

        public Searcher() {
            ColleagueManager.Holder.MANAGER.register("JTableTrack", this);
        }

        @Override
        public void setData(Map<String, String> data) {

        }

        @Override
        public void update() {

        }
    }


    @Override
    public void setData(List<TreeElement> data) {
        Vector<FieldsVector<String>> dataSet = new Vector<FieldsVector<String>>();
        Vector<String> columnName = new Vector<String>();

        columnName.addElement("ID");
        columnName.addElement("执行状态");
        columnName.addElement("执行时间");
        Field[] fields = TRACK.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                columnName.addElement(field.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        columnName.addElement("新增状态");
        columnName.addElement("修改状态");

        for (TreeElement element : data) {
            if (element.getElementType() == TreeElement.ElementType.MSG_TRACK) {

                if (element instanceof TRACK) {
                    FieldsVector<String> oneData = new FieldsVector<String>();
                    oneData.addElement(((TRACK) element).OBJID);
                    oneData.addElement(((TRACK) element).PERSTATE);
                    oneData.addElement(((TRACK) element).PERFORMMSGTIME);
                    oneData.addElement(((TRACK) element).extractPoints(new StringBuilder()));
                    oneData.addElement(((TRACK) element).ADDSTATE);
                    oneData.addElement(((TRACK) element).ALTSTATE);
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
