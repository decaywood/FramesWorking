package views.generalComponents;

import data.TreeElement;
import utils.FieldsVector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * @author mamamiyear
 * @date 15-9-11
 */

public class JEasyTable extends JPanel {

    private JTable jTable;
    private DefaultTableModel jTableModel;
    protected Vector<FieldsVector<String>> dataSet;
    protected Vector<FieldsVector<String>> showSet;
    private Vector<String> columnNames;
    private TitledBorder titledBorder;
    private JPopupMenu jPopupMenu;
    public List<JMenuItem> popupMenuItems;
    private JScrollPane jScrollPane;

    private MouseAdapter popupMenuListener;


     /*__________________________构造方法簇——————————————————————————————————*/


    public JEasyTable() {

        this(new Vector<String>(), new Vector<FieldsVector<String>>());

    }

    public JEasyTable(String borderTitle) {

        this(borderTitle, new Vector<String>(), new Vector<FieldsVector<String>>(), true);

    }

    public JEasyTable(Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JEasyTable(Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JEasyTable(String borderTitle, Vector<String> tableColumnName, Vector<FieldsVector<String>> tableDatas, boolean popupMenuEnable) {

        init();
        if (borderTitle != null) {
            initBorder(borderTitle);
        }
        initTable(tableColumnName, tableDatas);
        if (popupMenuEnable) {

            initPopupMenu();

        }

    }


     /*__________________________init方法簇——————————————————————————————————*/


    private void init() {

        JEasyTable.this.setLayout(new BorderLayout());
        titledBorder = new TitledBorder("");
        dataSet = new Vector<FieldsVector<String>>();
        showSet = new Vector<FieldsVector<String>>();
        columnNames = new Vector<String>();
        jScrollPane = new JScrollPane();
        jTableModel = new DefaultTableModel();
        jTable = new JTable() {
            @Override
            public void updateUI() {
                super.updateUI();
                this.clearSelection();
            }
        };

        jPopupMenu = new JPopupMenu();
        popupMenuItems = new ArrayList<>();

        popupMenuListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                super.mousePressed(e);
                if (e.getButton() == MouseEvent.BUTTON3) {

                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                    int index = jTable.rowAtPoint(e.getPoint());
                    if (!jTable.isRowSelected(index)) {

                        jTable.setRowSelectionInterval(index, index);

                    }

                }

            }
        };
    }

    private void initBorder(String title) {

        titledBorder.setTitle(title);
        JEasyTable.this.setBorder(titledBorder);

    }

    private void initTable(Vector<String> columnName, Vector<FieldsVector<String>> datas) {

        for (int i = 0; i < columnName.size(); i++) {
            columnNames.addElement(columnName.get(i));
        }

        for (int i = 0; i < datas.size(); i++) {
            dataSet.addElement(datas.get(i));
        }

        for (int i = 0; i < dataSet.size(); i++) {
            showSet.addElement(dataSet.get(i));
        }

        jTableModel.setDataVector(showSet, columnNames);

        jTable.setModel(jTableModel);

        jScrollPane.setViewportView(jTable);

        jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JEasyTable.this.add(jScrollPane, BorderLayout.CENTER);

    }

    private void initPopupMenu() {


        jTable.addMouseListener(popupMenuListener);

    }


     /*__________________________set方法簇——————————————————————————————————*/


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

    public void setDatas(Vector<FieldsVector<String>> datas) {

        dataSet.removeAllElements();
        for (int i = 0; i < datas.size(); i++) {
            dataSet.addElement(datas.get(i));
        }
        updateShowSet();
        jTable.updateUI();

    }

    public void setColumnNames(Vector<String> columnName) {

        jTableModel.setColumnIdentifiers(columnName);
        columnNames = columnName;
        jTable.updateUI();

    }

    public void setAutoResizeMode(int mode) {
        jTable.setAutoResizeMode(mode);
    }

    public void setPopupMenuItemAction(int itemIndex, ActionListener actionListener) {

        if (0 <= itemIndex && itemIndex < popupMenuItems.size()) {
            popupMenuItems.get(itemIndex).addActionListener(actionListener);
        } else {
            System.out.println("没有这个菜单.");
        }

    }

    public void setPopupMenuItemAction(String itemName, ActionListener actionListener) {

        int index = -1;

        for (int i = 0; i < popupMenuItems.size(); i++) {

            if (popupMenuItems.get(i).getText().equals(itemName)) {

                index = i;
                break;

            }

        }

        setPopupMenuItemAction(index, actionListener);

    }

    public void setTableSelectedAction(ListSelectionListener Listener) {

        jTable.getSelectionModel().addListSelectionListener(Listener);

    }


     /*__________________________add方法簇——————————————————————————————————*/


    public void addPopupMenuItems(String ItemNames, ActionListener listener) {

        JMenuItem jMenuItem = new JMenuItem(ItemNames);
        jMenuItem.addActionListener(listener);
        jPopupMenu.add(jMenuItem);

    }

    public void addData(FieldsVector<String> data) {

        dataSet.addElement(data);
        jTable.updateUI();

    }

    public void addColumn(String name) {

        columnNames.add(name);
        jTable.updateUI();

    }


    /*__________________________insert方法簇——————————————————————————————————*/


    public void insertData(FieldsVector<String> data, int index) {

        dataSet.insertElementAt(data, index);

    }

    public void insertColumn(String name) {

    }


     /*__________________________remove方法簇——————————————————————————————————*/


    public void removeData(int i) {

    }


    /*__________________________get方法簇——————————————————————————————————*/


    public int getRowCount() {
        return jTable.getRowCount();
    }

    public int getSelectedRow() {

        return jTable.getSelectedRow();

    }

    public int getColumnIndex(String columnName) {

        try {
            return jTable.getColumn(columnName).getModelIndex();
        } catch (Exception e) {
            return -1;
        }

    }

    public String getValueAt(int x, int y) {

        return jTable.getValueAt(x, y).toString();

    }

    public Vector<String> getColumnNames() {
        return columnNames;
    }

    public FieldsVector<String> getSelectedData() {

        return showSet.get(jTable.getSelectedRow());

    }

    public TreeElement getSelectedTreeElement() {

        if (jTable.getSelectedRow() == -1) {
            return null;
        } else {
            return showSet.get(jTable.getSelectedRow()).element;
        }
    }

    public void searchData(Map<String, String> data) {

        Set<String> keySet = data.keySet();
        showSet.removeAllElements();


        for (FieldsVector<String> tmpdata : dataSet) {
            boolean condition = true;
            for (String str : keySet) {
                int index = this.getColumnIndex(str);
                if(index == -1) continue;
                String val = data.get(str);
                if(val == null || val.equals("")) continue;
                condition = tmpdata.get(index).equalsIgnoreCase(val);
                System.out.println(tmpdata.get(index));
                if(!condition) break;
            }
            if (condition) {

                showSet.addElement(tmpdata);

            }


        }

        updateTable();

    }


    /*__________________________更新方法簇——————————————————————————————————*/


    public void updateShowSet() {

        showSet.removeAllElements();
        for (int i = 0; i < dataSet.size(); i++) {
            showSet.addElement(dataSet.get(i));
        }

    }

    public void updateTable() {
        jTable.updateUI();
    }
}
