package views.contralCenter;

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
    private JPanel buttonPanel1;
    private JPanel buttonPanel2;
    private JPanel buttonPanel3;
    private JPanel imaginePanel;


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



        buttonPanel1 = new JPanel(new GridLayout(2, 1, 5, 10));
        buttonPanel1.setBorder(new TitledBorder(""));
        JButton jButtonFlyPlan = new JButton("查询");
        JButton jButtonMSGSce = new JButton("清空");
        buttonPanel1.add(jButtonFlyPlan);
        buttonPanel1.add(jButtonMSGSce);

        buttonPanel2 = new JPanel(new GridLayout(2, 2, 10 ,10));
        JButton jButton1 = new JButton("飞行计划列表");
        JButton jButton2 = new JButton("MSG剧本列表");
        JButton jButton3 = new JButton("TRACK剧本列表");
        JButton jButton4 = new JButton("联程航班列表");
        buttonPanel2.add(jButton1);
        buttonPanel2.add(jButton2);
        buttonPanel2.add(jButton3);
        buttonPanel2.add(jButton4);

        buttonPanel3 = new JPanel(new GridLayout(2, 3, 5, 5));
        buttonPanel3.setBorder(new TitledBorder("执行状态颜色设置"));
        JButton[] jButtonColors = new JButton[5];
        Color[] colors = new Color[5];
        colors[0] = Color.WHITE;
        colors[1] = Color.GREEN;
        colors[2] = Color.YELLOW;
        colors[3] = Color.MAGENTA;
        colors[4] = Color.RED;
        jButtonColors[0] = new JButton("未执行态");
        jButtonColors[1] = new JButton("执行态");
        jButtonColors[2] = new JButton("完成态");
        jButtonColors[3] = new JButton("停止态");
        jButtonColors[4] = new JButton("停止态");

        for (int i = 0; i < jButtonColors.length; i++) {
            jButtonColors[i].setForeground(colors[i]);
            buttonPanel3.add(jButtonColors[i]);
        }

        imaginePanel = new JPanel();
        imaginePanel.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("./textFiles/StateTransform.jpg");
        icon.setImage(icon.getImage().getScaledInstance(270,100,Image.SCALE_DEFAULT));
        JLabel imagine = new JLabel(icon);
        imagine.setPreferredSize(new Dimension(270, 100));
        imaginePanel.add(imagine, BorderLayout.CENTER);
        imaginePanel.setBackground(Color.cyan);


        add(planConditionPanel);
        add(buttonPanel2);
        add(buttonPanel1);
        add(buttonPanel2);
        add(buttonPanel3);
        add(imaginePanel);

    }
}
