package views.plan;

import utils.Colleague;
import utils.ColleagueManager;
import views.plan.Components.AbstractFlightPlans;

import java.util.HashMap;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class NewFlightPlans extends AbstractFlightPlans implements Colleague<HashMap<String, String>> {
    public NewFlightPlans() {
        super("增加-飞行计划");
        ColleagueManager.Holder.MANAGER.register("NewFlightPlans", this);
    }


    @Override
    public void setData(HashMap<String, String> data) {
        updateTextField(data);
    }

    @Override
    public void update() {}
}
