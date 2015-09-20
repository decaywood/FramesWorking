package views.contralCenter;

import data.FDR;
import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import views.generalComponents.JEasyTable;
import views.plan.NewFlightPlans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-17
 */

public class JTableFDR extends JEasyTable implements Colleague<List<TreeElement>> {


    public JTableFDR() {

        this(new Vector<String>(), new Vector<Vector<String>>());

    }

    public JTableFDR(String borderTitle) {

        this(borderTitle, new Vector<String>(), new Vector<Vector<String>>(), true);

    }

    public JTableFDR(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JTableFDR(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JTableFDR(String borderTitle, Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        super(borderTitle, tableColumnName, tableDatas, popupMenuEnable);
        this.addPopupMenuItems("添加", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewFlightPlans();
                Vector<String> columns = JTableFDR.this.getColumnNames();
                for (String column : columns) {
                    System.out.println(column);
                }
                Vector<String> data = JTableFDR.this.dataSet.get(getSelectedRow());
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
        ColleagueManager.Holder.MANAGER.register("JTableFDRForControlCenter", JTableFDR.this);
    }


    @Override
    public void setData(List<TreeElement> data) {

        Vector<Vector<String>> dataSet = new Vector<Vector<String>>();
        Vector<String> columnName = new Vector<String>();

        Field[] fields = FDR.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                columnName.addElement(field.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        for (TreeElement element : data) {
            if (element.getElementType() == TreeElement.ElementType.FDR) {

                System.out.println("FDR " + element.toString());
                if (element instanceof FDR) {
                    Vector<String> oneData = new Vector<String>();
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
                System.out.println(element.getElementName() + "不是FDR.");
            }
        }

        setColumnNames(columnName);
        setDatas(dataSet);
        System.out.println(columnName.size()+"______"+dataSet.size());

    }

    @Override
    public void update() {

    }

}
