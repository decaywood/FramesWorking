package views.contralCenter;

import data.FDR;
import data.MSG;
import data.TRACK;
import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import utils.FieldsVector;
import views.generalComponents.JEasyTable;
import views.generalComponents.LabelTextFieldPanel;
import views.plan.NewFlightPlans;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author mamamiyear
 * @date 15-9-17
 */

public class JTableFDR extends JEasyTable implements Colleague<List<TreeElement>> {



    public JTableFDR() {

        this(new Vector<String>(), new Vector<FieldsVector<String>>());

    }

    public JTableFDR(String borderTitle, LabelTextFieldPanel search) {

        this(borderTitle, new Vector<String>(), new Vector<FieldsVector<String>>(), true);

    }

    public JTableFDR(Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JTableFDR(Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JTableFDR(String borderTitle, Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas, boolean popupMenuEnable) {

        super(borderTitle, tableColumnName, tableDatas, popupMenuEnable);
        this.addPopupMenuItems("添加", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewFlightPlans();
                Vector<String> columns = JTableFDR.this.getColumnNames();
                for (String column : columns) {
                    System.out.println(column);
                }
                FieldsVector<String> data = JTableFDR.this.dataSet.get(getSelectedRow());
                Map<String, String> hashMap = new HashMap<String, String>();
                for (int i = 0; i < columns.size(); i++) {
                    hashMap.put(columns.get(i), data.get(i));
                }
                ColleagueManager.Holder.MANAGER.setData("NewFlightPlans", hashMap);
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
        ColleagueManager.Holder.MANAGER.register("JTableFDRForControlCenter", JTableFDR.this);
    }

    private void addTableSelectedAction() {

        ListSelectionListener selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;//仅在鼠标抬起时触发
                List<TreeElement> MSGs = new ArrayList<>();
                List<TreeElement> TRACKs = new ArrayList<>();

                TreeElement element = JTableFDR.this.getSelectedTreeElement();
                for (int i = 0; i < element.getChildCount(); i++) {
                    TreeElement c = (TreeElement) element.getChildAt(i);
                    if(c instanceof MSG) {
                        MSGs.add(c);
                    } else if (c instanceof TRACK) {
                        TRACKs.add(c);
                    } else {
                        System.out.println(element.getElementName()+"的第"+i+"个孩子既不是MSG也不是TRACK.");
                    }
                }

                ArrayList<String> b = new ArrayList<>();
                b.add("");
                b.add("");
                b.add("");
                ColleagueManager.Holder.MANAGER.setData("JTableAreasForControlCenter", b);
                ColleagueManager.Holder.MANAGER.setData("JTableMSGForControlCenter", MSGs);
                ColleagueManager.Holder.MANAGER.setData("JTableTrackForControlCenter", TRACKs);

            }
        };

        this.setTableSelectedAction(selectionListener);

    }

    public class Searcher implements Colleague<Map<String, String>> {

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

        Field[] fields = FDR.class.getDeclaredFields();
        columnName.addElement("ID");
        columnName.addElement("执行状态");
        for (Field field : fields) {
            try {
                columnName.addElement(field.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        for (TreeElement element : data) {
            if (element.getElementType() == TreeElement.ElementType.FDR) {

                if (element instanceof FDR) {
                    FieldsVector<String> oneData = new FieldsVector<>();
                    oneData.element = element;
                    oneData.put("SCENARIOID", ((FDR) element).SCENARIOID);
                    oneData.put("FDRID", ((FDR) element).OBJID);
                    oneData.put("PERSTATE", ((FDR) element).PERSTATE);
                    oneData.put("ADDSTATE", ((FDR) element).ADDSTATE);
                    oneData.put("ALTSTATE", ((FDR) element).ALTSTATE);
                    oneData.addElement(((FDR) element).OBJID);
                    oneData.addElement(((FDR) element).PERSTATE);
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
                } else {
                    System.out.println(element.getElementName() + "不能转换为FDR.");
                }

            } else {
                System.out.println(element.getElementName() + "不是FDR.");
            }
        }

        setColumnNames(columnName);
        setDatas(dataSet);
        System.out.println("FDR表头共有" + columnName.size() + "列");
        System.out.println("FDR表一个数据共有" + dataSet.get(0).size() + "列");

    }

    @Override
    public void update() {

    }

}
