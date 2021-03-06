package views.generalComponents;

import javax.swing.*;
import java.awt.*;

/**
 * @author: decaywood
 * @date: 2015/9/9 16:53
 */
public class LabelTextField extends JPanel {
    private JTextField textField;
    public LabelTextField(String lbName, int len) {
        setPreferredSize(new Dimension(len, 50));
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JLabel label = new JLabel(lbName);
        textField = new JTextField();
        label.setPreferredSize(new Dimension(len, 25));
        textField.setPreferredSize(new Dimension(len, 25));
        add(label);
        add(textField);
    }

    public String getText() {
        return textField.getText();
    }

    public void setText(String text) {
        textField.setText(text);
    }
}
