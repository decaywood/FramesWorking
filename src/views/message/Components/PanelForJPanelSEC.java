package views.message.Components;

import utils.Colleague;
import utils.ColleagueManager;
import utils.Pair;
import views.generalComponents.LabelTextFieldPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mamamiyear
 * @date 15-9-10
 */

public class PanelForJPanelSEC extends JPanel implements Colleague<Map<String, String>> {

    private LabelTextFieldPanel labelTextFieldPanel;

    private JScrollPane jScrollPaneTablePoint;
    private JTextArea jTextAreaMSGHead;


    public PanelForJPanelSEC() {
        super();
        ColleagueManager.Holder.MANAGER.register(PanelForJPanelSEC.class.getName(), this);
        init();
    }

    public void init() {

        setLayout(new BorderLayout());

        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair("执行时间", 100));
        pairs.add(new Pair("报文类", 100));
        pairs.add(new Pair("执行状态", 100));
        pairs.add(new Pair("ID", 100));
        labelTextFieldPanel = new LabelTextFieldPanel(pairs, "详细信息");
        this.add(labelTextFieldPanel, BorderLayout.NORTH);


        jScrollPaneTablePoint = new JScrollPane();
        jScrollPaneTablePoint.setBorder(new TitledBorder("报头"));
        this.add(jScrollPaneTablePoint, BorderLayout.CENTER);
        jTextAreaMSGHead = new JTextArea();
        jScrollPaneTablePoint.setViewportView(jTextAreaMSGHead);


    }



    @Override
    public void setData(Map<String, String> data) {
        String head = data.get("报头");
        if(head != null && !head.equalsIgnoreCase("NULL")){
            jTextAreaMSGHead.setText(head);
        }
        labelTextFieldPanel.updateTextField(data);

    }

    @Override
    public void update() {

    }
}
