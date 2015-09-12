package views.generalComponents;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by mamamiyear on 15-9-10.
 */
public abstract class ScenariosViewFrame extends JFrame {

    private JPanel jPanelBottom;
    protected JLabel jLabelDatasNum;
    protected String datasNumShow;
    private JSplitPane jSplitPaneWhole;
    private JSplitPane jSplitPaneS;
    public JPanel jPanelN;
    public JPanel jPanelSW;
    private JPanel jPanelSE;
    public JPanel jPanelSEC;
    public JPanel jPanelSES;
    public JPanel jPanelSEW;

    public ScenariosViewFrame(String title, int southPanelHeight) {
        this(title, 1200, 800, 700, southPanelHeight);
    }

    public ScenariosViewFrame(String title) {
        this(title, 1200, 800, 700, 250);
    }

    public ScenariosViewFrame(String title, int width, int height, int leftSideWidth, int southPanelHeight) {

        super(title);
        init(width, height, leftSideWidth, southPanelHeight);
        setVisible(true);
    }

    public void init(int width, int height, int rightSideWidth, int southPanelHeight) {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(0, 0, width, height);
        setMinimumSize(new Dimension(700, 250));

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        jSplitPaneWhole = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jSplitPaneWhole.setDividerLocation(100);
        jSplitPaneWhole.setOneTouchExpandable(true);
        container.add(jSplitPaneWhole, BorderLayout.CENTER);

        jPanelBottom = new JPanel();
        jPanelBottom.setBorder(new LineBorder(Color.GRAY));
        jPanelBottom.setLayout(new FlowLayout(0, 5, 5));
        container.add(jPanelBottom, BorderLayout.SOUTH);

        datasNumShow = "记录数:";
        jLabelDatasNum = new JLabel(datasNumShow);
        jPanelBottom.add(jLabelDatasNum);

        jPanelN = new JPanel();
        jPanelN.setLayout(new FlowLayout(0, 0, 0));
        jSplitPaneWhole.setTopComponent(jPanelN);

        jSplitPaneS = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPaneS.setDividerLocation(width - rightSideWidth);
        jSplitPaneS.setResizeWeight(1.0);
        jSplitPaneWhole.setBottomComponent(jSplitPaneS);

        jPanelSW = new JPanel();
        jPanelSE = new JPanel();
        jPanelSW.setLayout(new BorderLayout());
        jPanelSE.setLayout(new BorderLayout());
        jSplitPaneS.setRightComponent(jPanelSE);
        jSplitPaneS.setLeftComponent(jPanelSW);

        jPanelSEC = new JPanel();
        jPanelSES = new JPanel();
        jPanelSEC.setLayout(new BorderLayout());
        jPanelSES.setLayout(new BorderLayout());
        jPanelSES.setPreferredSize(new Dimension(500, southPanelHeight));
        jPanelSE.add(jPanelSEC, BorderLayout.CENTER);
        jPanelSE.add(jPanelSES, BorderLayout.SOUTH);

        jPanelSEW = new JPanel();
        jPanelSEW.setLayout(new BorderLayout());
        jPanelSE.add(jPanelSEW, BorderLayout.WEST);

        jPanelN.add(getComponentsForJPanelN());
        jPanelSW.add(getComponentsForJPanelSW());
        jPanelSEC.add(getComponentsForJPanelSEC());
        jPanelSES.add(getComponentsForJPanelSES());
        jPanelSEW.add(getComponentsForJPanelSEW());


    }

    public  Component getComponentsForJPanelN(){return new JPanel();}

    public  Component getComponentsForJPanelSW(){return new JPanel();}

    public  Component getComponentsForJPanelSEC(){return new JPanel();}

    public  Component getComponentsForJPanelSES(){return new JPanel();}

    public Component getComponentsForJPanelSEW(){return new JPanel();}




}
