package views.generalComponents;

import utils.Pair;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/10 10:51
 */
public class LabelTextFieldPanel extends JPanel {

    private Map<String, LabelTextField> components;

    public LabelTextFieldPanel(List<Pair> componentInfos) {
        this(componentInfos, "");
    }

    public LabelTextFieldPanel(List<Pair> componentInfos, String tittle) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.components = new HashMap<>();
        init(componentInfos, tittle);
    }

    private void init(List<Pair> componentInfos, String tittle) {
        setBorder(new TitledBorder(tittle));
        for (Pair pair : componentInfos) {
            LabelTextField textField = new LabelTextField(pair.labelName, pair.labelLength);
            add(textField);
            components.put(pair.labelName, textField);
        }
    }

    public String getText(String componentName) {
        return components.get(componentName).getText();
    }

    public void setText(String componentName, String text) {
        components.get(componentName).setText(text);
    }




}
