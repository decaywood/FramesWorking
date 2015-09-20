package views.contralCenter;

import data.FDR;
import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import utils.FieldsVector;
import views.generalComponents.JEasyTable;
import views.plan.ModifyFlightPlans;
import views.plan.NewFlightPlans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-17
 */

public class JTableFDR extends JEasyTable implements Colleague<List<TreeElement>> {


    public JTableFDR() {

        this(new Vector<String>(), new Vector<FieldsVector<String>>());

    }

    public JTableFDR(String borderTitle) {

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

            }
        });
        this.addPopupMenuItems("修改", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifyFlightPlans();
                FieldsVector<String> vector = JTableFDR.this.dataSet.get(getSelectedRow());
                ColleagueManager.Holder.MANAGER.setData("ModifyFlightPlans", vector);
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

        Vector<FieldsVector<String>> dataSet = new Vector<FieldsVector<String>>();
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

                if (element instanceof FDR) {
                    FieldsVector<String> oneData = new FieldsVector<>();
                    oneData.element = element;
                    oneData.columnName = columnName;
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
