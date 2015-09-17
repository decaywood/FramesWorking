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

public class JTableTrack extends JEasyTable implements Colleague<TreeElement> {

    public JTableTrack() {

        this(new Vector<String>(), new Vector<Vector<String>>());

    }

    public JTableTrack(String borderTitle) {

        this(borderTitle, new Vector<String>(), new Vector<Vector<String>>(), true);

    }

    public JTableTrack(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas) {

        this(tableColumnName, tableDatas, true);

    }

    public JTableTrack(Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        this(null, tableColumnName, tableDatas, popupMenuEnable);

    }

    public JTableTrack(String borderTitle, Vector<String> tableColumnName, Vector<Vector<String>> tableDatas, boolean popupMenuEnable) {

        super(borderTitle, tableColumnName, tableDatas, popupMenuEnable);
        ColleagueManager.Holder.MANAGER.register("JTableTrackforControlCenter", JTableTrack.this);

    }

    @Override
    public void setData(TreeElement data) {



    }

    @Override
    public void update() {

    }

}
