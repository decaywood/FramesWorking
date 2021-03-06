package views.plan.Components;

import utils.Colleague;
import utils.ColleagueManager;
import utils.Pair;
import views.generalComponents.LabelTextFieldPanel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSEC extends JPanel implements Colleague<Map<String, String>> {


    private LabelTextFieldPanel labelTextFieldPanelSCE;
    private LabelTextFieldPanel labelTextFieldPanelINF;



    public PanelForJPanelSEC() {
        super();
        ColleagueManager.Holder.MANAGER.register(PanelForJPanelSEC.class.getName(), this);
        init();
    }

    public void init() {

        setLayout(new BorderLayout());

        List<Pair> pairsSCE = new ArrayList<>();
        pairsSCE.add(new Pair("剧本ID", 75));
        pairsSCE.add(new Pair("名称", 75));
        labelTextFieldPanelSCE = new LabelTextFieldPanel(pairsSCE, "所属剧本");
        labelTextFieldPanelSCE.setPreferredSize(new Dimension(100, 0));
        this.add(labelTextFieldPanelSCE, BorderLayout.EAST);

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());


        Vector<String> Names = new Vector<>();
        try {
            File file = new File("./textFiles/FlightPlanDetailedInfNames");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = reader.readLine()) != null) {
                Names.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Pair> pairsINF = new ArrayList<>();
        for (int i = 0; i < Names.size(); i++) {
            pairsINF.add(new Pair(Names.get(i), 75));
        }
        labelTextFieldPanelINF = new LabelTextFieldPanel(new GridLayout(6, 4, 5, 5), pairsINF, "详细信息");
        jPanel1.add(labelTextFieldPanelINF, BorderLayout.CENTER);
        this.add(jPanel1, BorderLayout.CENTER);



    }

    @Override
    public void setData(Map<String, String> data) {
        this.labelTextFieldPanelINF.updateTextField(data);
        this.labelTextFieldPanelSCE.updateTextField(data);
    }

    @Override
    public void update() {

    }
}
