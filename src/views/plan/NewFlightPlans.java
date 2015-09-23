package views.plan;

import data.FDR;
import utils.Colleague;
import utils.ColleagueManager;
import utils.DataSender;
import utils.FieldsVector;
import views.controlCenter.JTableFDR;
import views.generalComponents.JEasyTable;
import views.generalComponents.JTreePanel;
import views.plan.Components.AbstractFlightPlans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Vector;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class NewFlightPlans extends AbstractFlightPlans implements Colleague<JEasyTable>{

    private JEasyTable jEasyTable;



    public NewFlightPlans() {
        super("增加-飞行计划");
        ColleagueManager.Holder.MANAGER.register(NewFlightPlans.class.getName(), this);
        addSaveListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, String> modifiedData = NewFlightPlans.this.getData();
                FDR fdr = new FDR();
                fdr.TYPECMD = "01";
                fdr.TYPEOBJ = "02";
                for (Field field : FDR.class.getFields()) {
                    if (modifiedData.containsKey(field.getName())) {
                        try {
                            String val = modifiedData.get(field.getName());
                            field.set(fdr, val == null ? "" : val);
                        } catch (IllegalAccessException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                fdr.ETA = "ABS " + fdr.ETA;
                Vector<String> columnName = jEasyTable.getColumnNames();
                FieldsVector<String> fieldsVector = new FieldsVector<String>();
                fieldsVector.element = fdr;
                fieldsVector.columnName = columnName;
                for (int i = 0; i < columnName.size(); i++) {
                    String colName = columnName.get(i);
                    if (!modifiedData.containsKey(colName)) continue;
                    fieldsVector.add(modifiedData.get(colName));
                }
                jEasyTable.addRow(fieldsVector);
                ColleagueManager.Holder.MANAGER.update(JTableFDR.class.getName());
                ColleagueManager.Holder.MANAGER.update(JTreePanel.class.getName());
                DataSender.send(fdr.extract(""));
                dispose();
            }
        });
    }

    @Override
    public void setData(JEasyTable data) {
        this.jEasyTable = data;
    }

    @Override
    public void update() {

    }
}
