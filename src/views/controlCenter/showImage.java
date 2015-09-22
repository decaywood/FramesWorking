package views.controlCenter;

import javax.swing.*;
import java.awt.*;

/**
 * @author mamamiyear
 * @date 15-9-22
 */

public class showImage extends JDialog {

    private JLabel imagine;

    public showImage(JFrame father) {

        super(father, "状态转换图", true);
        init();

        setVisible(true);
    }

    private void init() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0, 0, 950, 400);
        Container container = this.getContentPane();

        ImageIcon icon = new ImageIcon("./textFiles/StateTransform.jpg");
        imagine = new JLabel(icon);

        container.setLayout(new BorderLayout());
        container.add(imagine, BorderLayout.CENTER);
    }

}
