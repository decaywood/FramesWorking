package views.message.Components;

import data.DefaultTreeElement;
import data.FDR;
import data.MSG;
import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import utils.DataSender;
import utils.FieldsVector;
import views.generalComponents.JEasyTable;
import views.message.ModifyMSG;
import views.message.NewMSG;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author mamamiyear
 * @date 15-9-21
 */

public class JTableMSG extends JEasyTable implements Colleague<List<TreeElement>> {

    private Searcher searcher;
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
                new NewMSG();
                Map<String, String> data = new HashMap<String, String>();
                MSG element = (MSG) JTableMSG.this.getSelectedTreeElement();
                FDR fdr = (FDR) element.parent;
                for (Field field : FDR.class.getDeclaredFields()) {
                    try {
                        data.put(field.getName(), (String)field.get(fdr));
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }
                }

                ColleagueManager.Holder.MANAGER.setData(NewMSG.class.getName(), data);
            }
        });
        this.addPopupMenuItems("修改", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifyMSG();
                Map<String, String> data = new HashMap<String, String>();
                MSG element = (MSG) JTableMSG.this.getSelectedTreeElement();
                FDR fdr = (FDR) element.parent;
                for (Field field : FDR.class.getDeclaredFields()) {
                    try {
                        data.put(field.getName(), (String)field.get(fdr));
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    }
                }
                data.put("报文执行时间", element.PERFORMMSGTIME);
                data.put("报文类型", element.MSGTYPE);
                data.put("报头", element.MSGHEAD);
                data.put("报文体", element.MSGBODY);
                data.put("FDRID", fdr.OBJID);
                ColleagueManager.Holder.MANAGER.setData(ModifyMSG.class.getName(), data);
            }
        });
        this.addPopupMenuItems("删除", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTreeElement element = (DefaultTreeElement) JTableMSG.this.getSelectedTreeElement();
                DataSender.removeElement(element);
            }
        });
        searcher = new Searcher();
        addTableSelectedAction();
        ColleagueManager.Holder.MANAGER.register(JTableMSG.class.getName(), JTableMSG.this);

    }

    private void addTableSelectedAction() {

        ListSelectionListener selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;//仅在鼠标抬起时触发
                TreeElement element = JTableMSG.this.getSelectedTreeElement();
                if(element == null) return;
                MSG msg = (MSG) element;
                Map<String, String> map = new HashMap<>();
                map.put("执行时间", msg.PERFORMMSGTIME);
                map.put("报文类", msg.MSGTYPE);
                map.put("执行状态", msg.PERSTATE);
                map.put("ID", msg.OBJID);
                map.put("报头", msg.MSGHEAD);
                ColleagueManager.Holder.MANAGER.setData(PanelForJPanelSES.class.getName(), msg.MSGBODY);
                ColleagueManager.Holder.MANAGER.setData(PanelForJPanelSEC.class.getName(), map);
            }
        };

        this.setTableSelectedAction(selectionListener);

    }

    public class Searcher implements Colleague<Map<String, String>> {

        public Searcher() {
            ColleagueManager.Holder.MANAGER.register(JTableMSG.Searcher.class.getName(), this);
        }

        @Override
        public void setData(Map<String, String> data) {
            searchData(data);
        }

        @Override
        public void update() {

        }
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
                    oneData.element = element;
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
