package views.plan;

import data.FDR;
import utils.Colleague;
import utils.ColleagueManager;
import utils.DataSender;
import views.plan.Components.AbstractFlightPlans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class NewFlightPlans extends AbstractFlightPlans implements Colleague<Map<String, String>>{

    Map<String, String> data;
    public NewFlightPlans() {
        super("增加-飞行计划");
        ColleagueManager.Holder.MANAGER.register(NewFlightPlans.class.getName(), this);
        addSaveListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, String> modifiedData = NewFlightPlans.this.getData();
                FDR fdr = new FDR();
                fdr.TYPEOBJ = "02";
                fdr.SCENARIOID = data.get("剧本ID");
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
                DataSender.addElement(fdr);
                dispose();
            }
        });
    }

    @Override
    public void setData(Map<String, String> data) {
        this.data = data;
        this.labelTextFieldPanel2.updateTextField(data);
    }

    @Override
    public void update() {

    }
}
