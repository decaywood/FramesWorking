package views;

import javax.swing.*;

/**
 * @author: decaywood
 * @date: 2015/9/10 19:40
 */
public abstract class AbstractTestFrame extends JFrame {

    public AbstractTestFrame() {
        setBounds(0, 0, 700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    protected abstract void init();
}
