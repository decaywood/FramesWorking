package views.plan;

import data.FDR;
import utils.Colleague;
import utils.ColleagueManager;
import utils.FieldsVector;
import views.controlCenter.JTableFDR;
import views.generalComponents.JTreePanel;
import views.plan.Components.AbstractFlightPlans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Vector;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class ModifyFlightPlans extends AbstractFlightPlans implements Colleague<FieldsVector<String>> {
    FieldsVector<String> vector;
    public ModifyFlightPlans() {
        super("修改-飞行计划");
        ColleagueManager.Holder.MANAGER.register(ModifyFlightPlans.class.getName(), this);
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                ModifyFlightPlans.this.requestFocus(true);
            }
        });
        addSaveListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, String> modifiedData = ModifyFlightPlans.this.getData();
                for (Field field : FDR.class.getFields()) {
                    if (modifiedData.containsKey(field.getName())) {
                        try {
                            field.set(vector.element, modifiedData.get(field.getName()));
                        } catch (IllegalAccessException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                Vector<String> columnName = vector.columnName;
                for (int i = 0; i < vector.size(); i++) {
                    String colName = columnName.get(i);
                    if(!modifiedData.containsKey(colName)) continue;
                    vector.set(i, modifiedData.get(colName));
                }
                ColleagueManager.Holder.MANAGER.update(JTableFDR.class.getName());
                ColleagueManager.Holder.MANAGER.update(JTreePanel.class.getName());
                dispose();
            }
        });
    }


    @Override
    public void setData(FieldsVector<String> vector) {
        this.vector = vector;
        updateTextField(vector.element);
    }

    @Override
    public void update() {

    }
}
