package views.contralCenter;

import data.TreeElement;
import utils.Colleague;
import utils.ColleagueManager;
import views.generalComponents.JEasyTable;

import java.util.Vector;

/**
 * @author mamamiyear
 * @date 15-9-17
 */

public class JTableMSG extends JEasyTable implements Colleague<TreeElement> {

    public JTableMSG() {

        this(new Vector<String>(), new Vector<Vector<String>>());

    }

    public JTableMSG(String borderTitle) {

        this(borderTitle, new Vector<String>(), new Vector<Vector<String>>(), true);

    }

    public JTableMSG(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JTableMSG(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JTableMSG(String borderTitle, Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        super(borderTitle, tableColumnName, tableDatas, popupMenuEnable);
        ColleagueManager.Holder.MANAGER.register("JTableMSGforControlCenter", JTableMSG.this);

    }

    @Override
    public void setData(TreeElement data) {



    }

    @Override
    public void update() {

    }
}
