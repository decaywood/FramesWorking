package views.contralCenter;

import data.MSG;
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
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-17
 */

public class JTableMSG extends JEasyTable implements Colleague<List<TreeElement>> {

    public JTableMSG() {

        this(new Vector<String>(), new Vector<FieldsVector<String>>());

    }

    public JTableMSG(String borderTitle) {

        this(borderTitle, new Vector<String>(), new Vector<FieldsVector<String>>(), true);

    }

    public JTableMSG(Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JTableMSG(Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JTableMSG(String borderTitle, Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas, boolean popupMenuEnable) {

        super(borderTitle, tableColumnName, tableDatas, popupMenuEnable);
        List<String> itemNames = new ArrayList<String>();
        this.addPopupMenuItems("添加", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.addPopupMenuItems("修改", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.addPopupMenuItems("删除", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addTableSelectedAction();
        ColleagueManager.Holder.MANAGER.register("JTableMSGForControlCenter", JTableMSG.this);

    }

    private void addTableSelectedAction() {

        ListSelectionListener selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;//仅在鼠标抬起时触发
                }
                ArrayList<String> b = new ArrayList<>();
                int y = JTableMSG.this.getColumnIndex("MSGHEAD");
                int x = JTableMSG.this.getSelectedRow();
                String textHead = JTableMSG.this.getValueAt(x, y);
                y = JTableMSG.this.getColumnIndex("MSGBODY");
                String textBody = JTableMSG.this.getValueAt(x, y);

                b.add(textHead);
                b.add(textBody);
                b.add(null);
                ColleagueManager.Holder.MANAGER.setData("JTableAreasForControlCenter", b);

            }
        };

        this.setTableSelectedAction(selectionListener);

    }

    @Override
    public void setData(List<TreeElement> data) {

        Vector<FieldsVector<String>> dataSet = new Vector<FieldsVector<String>>();
        Vector<String> columnName = new Vector<String>();

        Field[] fields = MSG.class.getDeclaredFields();
        columnName.addElement("ID");
        columnName.addElement("执行状态");
        columnName.addElement("执行时间");
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

                if (element instanceof MSG) {
                    FieldsVector<String> oneData = new FieldsVector<String>();
                    oneData.addElement(((MSG) element).OBJID);
                    oneData.addElement(((MSG) element).PERSTATE);
                    oneData.addElement(((MSG) element).PERFORMMSGTIME);
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
                    oneData.addElement(((MSG) element).ADDSTATE);
                    oneData.addElement(((MSG) element).ALTSTATE);
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
