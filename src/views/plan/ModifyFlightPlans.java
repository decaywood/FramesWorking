package views.plan;

import utils.Colleague;
import utils.ColleagueManager;
import views.plan.Components.AbstractFlightPlans;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class ModifyFlightPlans extends AbstractFlightPlans implements Colleague<String> {

    public ModifyFlightPlans() {
        super("修改-飞行计划");
        ColleagueManager.Holder.MANAGER.register("ModifyFlightPlans", this);
    }

    @Override
    public void setData(String data) {

    }

    @Override
    public void update() {

    }
}
