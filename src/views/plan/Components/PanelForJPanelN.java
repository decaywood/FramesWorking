package views.plan.Components;

import utils.Pair;
import views.generalComponents.LabelTextFieldPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/10 19:38
 */
public class PanelForJPanelN extends JPanel {

    private JPanel planConditionPanel;
    private JPanel MSGConditionPanel;
    private JPanel buttonPanel;
    private JPanel checkBoxJpanel;

    private JComboBox<String> jComboBox;
    private JTextField textField;

    public PanelForJPanelN() {
        super(new FlowLayout(FlowLayout.LEFT));
        init();
    }

    private void init() {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair("航班号", 75));
        list.add(new Pair("起飞机场", 75));
        list.add(new Pair("降落机场", 75));
        list.add(new Pair("机型选择", 75));
        list.add(new Pair("计划状态", 75));
        list.add(new Pair("计划ID", 75));
        list.add(new Pair("剧本ID", 75));
        planConditionPanel = new LabelTextFieldPanel(list, "计划条件");

        MSGConditionPanel = new JPanel(new GridLayout(2, 2, 0, 5));
        MSGConditionPanel.setBorder(new TitledBorder("报文条件"));
        MSGConditionPanel.add(new JLabel("执行状态"));
        jComboBox = new JComboBox<>();
        textField = new JTextField();
        MSGConditionPanel.add(jComboBox);
        MSGConditionPanel.add(new JLabel("报文类型"));
        MSGConditionPanel.add(textField);

        buttonPanel = new JPanel(new GridLayout(2, 2, 5, 10));
        buttonPanel.setBorder(new TitledBorder(""));
        JButton jButtonFlyPlan = new JButton("查询");
        JButton jButtonMSGSce = new JButton("清空");
        JButton jButtonTRACKSce = new JButton("航迹剧本View");
        JButton jButtonAIDC = new JButton("航迹剧本View");
        buttonPanel.add(jButtonFlyPlan);
        buttonPanel.add(jButtonMSGSce);
        buttonPanel.add(jButtonTRACKSce);
        buttonPanel.add(jButtonAIDC);

        checkBoxJpanel = new JPanel(new GridLayout(2, 1, 5 ,10));
        JCheckBox synchronizeCtrl = new JCheckBox("同步控制中心定位");
        JCheckBox revertCtrl = new JCheckBox("反向同步控制中心定位");
        checkBoxJpanel.add(synchronizeCtrl);
        checkBoxJpanel.add(revertCtrl);

        add(planConditionPanel);
        add(MSGConditionPanel);
        add(checkBoxJpanel);
        add(buttonPanel);
        add(checkBoxJpanel);

    }
}
