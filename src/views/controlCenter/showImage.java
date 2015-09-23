package views.controlCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author mamamiyear
 * @date 15-9-22
 */

public class showImage extends JDialog {

    private JLabel imagine;

    public showImage() {

        super();
        init();
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void init() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(0, 0, 950, 400);
        setUndecorated(true);
        Container container = this.getContentPane();

        ImageIcon icon = new ImageIcon("./textFiles/StateTransform.jpg");
        imagine = new JLabel(icon);

        container.setLayout(new BorderLayout());
        container.add(imagine, BorderLayout.CENTER);
    }

}
