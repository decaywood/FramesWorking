package views;

import utils.Pair;
import views.generalComponents.LabelTextFieldPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/10 11:22
 */
public class LabelTextFieldPanelTest extends JFrame {

    public LabelTextFieldPanelTest() {
        setBounds(0, 0, 700, 400);
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair("航班号", 100));
        pairs.add(new Pair("起飞机场", 100));
        pairs.add(new Pair("降落机场", 100));
        pairs.add(new Pair("机型", 100));
        pairs.add(new Pair("计划状态", 100));
        pairs.add(new Pair("剧本。。", 55));
        pairs.add(new Pair("航班号", 144));
        pairs.add(new Pair("起飞机场", 123));
        pairs.add(new Pair("降落机场", 42));
        pairs.add(new Pair("机型", 300));
        pairs.add(new Pair("计划状态", 100));
        pairs.add(new Pair("剧本。。", 200));
        JPanel panel = new LabelTextFieldPanel(pairs);
        panel.setPreferredSize(new Dimension(700, 400));
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelTextFieldPanelTest();
    }
}
