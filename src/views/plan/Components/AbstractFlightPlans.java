package views.plan.Components;

import data.DefaultTreeElement;
import data.Scenario;
import data.TreeElement;
import utils.Pair;
import views.generalComponents.LabelTextFieldPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mamamiyear on 15-9-10.
 */
public class AbstractFlightPlans extends JFrame {

    private LabelTextFieldPanel labelTextFieldPanel;
    public LabelTextFieldPanel labelTextFieldPanel2;
    private JTextArea area;
    private JButton savaButton;
    public AbstractFlightPlans(String name) {
        super(name);
        setBounds(0, 0, 700, 800);
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void init() {
        setLayout(new BorderLayout());
        JPanel FPCenterPanel = new JPanel(new BorderLayout());
        FPCenterPanel.setBorder(new TitledBorder("航路信息"));
        JScrollPane scrollPane = new JScrollPane();
        area = new JTextArea();
        scrollPane.setViewportView(area);
        FPCenterPanel.add(scrollPane, BorderLayout.CENTER);
        JPanel FPSouthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        savaButton = new JButton("保存");
        JButton exitButton = new JButton("退出");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractFlightPlans.this.dispose();
            }
        });
        FPSouthPanel.add(savaButton);
        FPSouthPanel.add(exitButton);

        JPanel FPNorthPanel = new JPanel(new BorderLayout());
        FPNorthPanel.setBorder(new TitledBorder("详细信息"));
        List<Pair> list = new ArrayList<>();
        list.add(new Pair("FLIGHTID", 100));
        list.add(new Pair("DEP", 100));
        list.add(new Pair("DES", 100));
        list.add(new Pair("ACTYPE", 100));
        list.add(new Pair("RFL", 100));
        list.add(new Pair("TAS", 100));
        list.add(new Pair("FLTRUL", 100));
        list.add(new Pair("WCT", 100));
        list.add(new Pair("CEQPT", 100));
        list.add(new Pair("SEQPT", 100));
        list.add(new Pair("FLTTYP", 100));
        list.add(new Pair("SSRCODE", 100));
        list.add(new Pair("EOBT", 100));
        list.add(new Pair("TTLEET", 100));
        list.add(new Pair("ETA", 100));
        list.add(new Pair("REG", 100));
        list.add(new Pair("DEPGATE", 100));
        list.add(new Pair("DEPWAY", 100));
        list.add(new Pair("SID", 100));
        list.add(new Pair("ALTRNT", 100));
        list.add(new Pair("ARRGATE", 100));
        list.add(new Pair("ARRWAY", 100));
        list.add(new Pair("STAR", 100));
        list.add(new Pair("STATE", 100));
        labelTextFieldPanel = new LabelTextFieldPanel(list);
        FPNorthPanel.add(labelTextFieldPanel, BorderLayout.CENTER);
        List<Pair> list2 = new ArrayList<>();
        list2.add(new Pair("剧本ID", 100));
        list2.add(new Pair("名称", 100));
        labelTextFieldPanel2 = new LabelTextFieldPanel(list2, "所属剧本");
        labelTextFieldPanel2.setPreferredSize(new Dimension(200, 450));
        FPNorthPanel.add(labelTextFieldPanel2, BorderLayout.EAST);

        add(FPCenterPanel, BorderLayout.CENTER);
        add(FPNorthPanel, BorderLayout.NORTH);
        add(FPSouthPanel, BorderLayout.SOUTH);
    }

    public void addSaveListener(ActionListener listener) {
        this.savaButton.addActionListener(listener);
    }

    protected void updateTextField(TreeElement element) {
        Map<String, String> map = new HashMap<>();
        for (Field field : element.getClass().getFields()) {
            try {
                Object o = field.get(element);
                if(!(o instanceof String)) continue;
                map.put(field.getName(), o.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        DefaultTreeElement fdr = (DefaultTreeElement)element;
        map.put("剧本ID", fdr.parent.OBJID);
        map.put("名称", ((Scenario)fdr.parent).NAME);
        this.labelTextFieldPanel.updateTextField(map);
        this.labelTextFieldPanel2.updateTextField(map);
        this.area.setText(map.get("RTE"));
    }

    protected Map<String, String> getData() {
        return this.labelTextFieldPanel.getTextFieldData();
    }

}
