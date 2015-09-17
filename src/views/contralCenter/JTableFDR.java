package views.contralCenter;

import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import views.generalComponents.JEasyTable;

import java.util.List;
import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-17
 */

public class JTableFDR extends JEasyTable implements Colleague<List<TreeElement>> {

    public JTableFDR() {

        this(new Vector<String>(), new Vector<Vector<String>>());

    }

    public JTableFDR(String borderTitle) {

        this(borderTitle, new Vector<String>(), new Vector<Vector<String>>(), true);

    }

    public JTableFDR(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JTableFDR(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JTableFDR(String borderTitle, Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        super(borderTitle, tableColumnName, tableDatas, popupMenuEnable);
        ColleagueManager.Holder.MANAGER.register("JTableFDRForControlCenter", JTableFDR.this);

    }


    @Override
    public void setData(List<TreeElement> data) {
        for (TreeElement element : data) {
            System.out.println(" FDR " + element.toString());
        }
    }

    @Override
    public void update() {

    }

}
