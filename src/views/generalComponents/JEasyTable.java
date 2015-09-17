package views.generalComponents;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-11
 */

public class JEasyTable extends JPanel {

    private JTable jTable;
    private DefaultTableModel jTabelModel;
    private Vector<Vector<String>> dataSet;
    private Vector<String> columnNames;
    private TitledBorder titledBorder;
    private JPopupMenu jPopupMenu;
    public List<JMenuItem> popupMenuItems;
    private JScrollPane jScrollPane;

    private MouseAdapter popupMenuListener;

    public JEasyTable() {

        this(new Vector<String>(), new Vector<Vector<String>>());

    }

    public JEasyTable(String borderTitle) {

        this(borderTitle, new Vector<String>(), new Vector<Vector<String>>(), true);

    }

    public JEasyTable(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JEasyTable(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JEasyTable(String borderTitle, Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        init();
        if (borderTitle != null) {
            initBorder(borderTitle);
        }
        initTable(tableColumnName, tableDatas);
        if (popupMenuEnable) {

            initPopupMenu();

        }


    }

    private void init() {

        JEasyTable.this.setLayout(new BorderLayout());
        titledBorder = new TitledBorder("");
        dataSet = new Vector<Vector<String>>();
        columnNames = new Vector<String>();
        jScrollPane = new JScrollPane();
        jTabelModel = new DefaultTableModel();
        jTable = new JTable() {
            @Override
            public void updateUI() {
                super.updateUI();
                this.clearSelection();
            }
        };

        popupMenuListener = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {

                if (e.isPopupTrigger()) {

                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                    int index = jTable.rowAtPoint(e.getPoint());
                    if (!jTable.isRowSelected(index)) {

                        jTable.setRowSelectionInterval(index, index);

                    }

                }

            }
        };
        jPopupMenu = new JPopupMenu();
        popupMenuItems = new ArrayList<>();



    }

    private void initBorder(String title) {

        titledBorder.setTitle(title);
        JEasyTable.this.setBorder(titledBorder);

    }

    private void initTable(Vector<String> columnName, Vector<Vector<String>> datas) {

        for (int i = 0; i < columnName.size(); i++) {
            columnNames.addElement(columnName.get(i));
        }

        for (int i = 0; i < datas.size(); i++) {
            dataSet.addElement(datas.get(i));
        }

        jTabelModel.setDataVector(dataSet, columnNames);

        jTable.setModel(jTabelModel);

        jScrollPane.setViewportView(jTable);

        JEasyTable.this.add(jScrollPane, BorderLayout.CENTER);

    }

    private void initPopupMenu() {

        jTable.addMouseListener(popupMenuListener);

    }





    public void setTitle(String title) {

        titledBorder.setTitle(title);
        JEasyTable.this.setBorder(titledBorder);

    }

    public void setBorderEnabled(boolean borderEnabled) {

        if (borderEnabled) {
            JEasyTable.this.setBorder(titledBorder);
        } else {
            JEasyTable.this.setBorder(null);
        }

    }

    public void setPopupMenuEnabled(boolean popupMenuEnabled) {

        if (popupMenuEnabled) {
            jTable.addMouseListener(popupMenuListener);
        } else {
            jTable.removeMouseListener(popupMenuListener);
        }

    }

    public void setDatas(Vector<Vector<String>> datas) {

        dataSet.removeAllElements();
        for (int i = 0; i < datas.size(); i++) {
            dataSet.addElement(datas.get(i));
        }
        jTable.updateUI();

    }

    public void setColumnNames(Vector<String> columnName) {

        columnNames.removeAllElements();
        for (int i = 0; i < columnName.size(); i++) {
            columnNames.addElement(columnName.get(i));
        }
        jTable.updateUI();

    }

    public void setAutoResizeMode(int mode) {
        jTable.setAutoResizeMode(mode);
    }





    public void addPopupMenuItems(List<String> ItemNames) {

        JMenuItem jMenuItem;
        for (int i = 0; i < ItemNames.size(); i++) {

            jMenuItem = new JMenuItem(ItemNames.get(i));
            popupMenuItems.add(jMenuItem);
            jPopupMenu.add(jMenuItem);

        }

    }

    public void addPopupMenuItem(String ItemName) {

        JMenuItem jMenuItem = new JMenuItem(ItemName);

        popupMenuItems.add(jMenuItem);
        jPopupMenu.add(jMenuItem);

    }

    public void addData(Vector<String> data) {

        dataSet.add(data);
        jTable.updateUI();

    }

    public void addColumn(String name) {

        columnNames.add(name);
        jTable.updateUI();

    }





    public void insertData(Vector<Vector<String>> data) {

    }

    public void insertColumn(String name) {

    }





    public void removeData(int i) {

    }





    public int getRowCount() {
        int rowCount = 0;

        return rowCount;
    }






}
