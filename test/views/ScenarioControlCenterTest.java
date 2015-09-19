package views;

import data.DataAnalizer;
import data.TreeElement;
import utils.ColleagueManager;
import views.contralCenter.ScenarioControlCenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author: decaywood
 * @date: 2015/9/17 13:06
 */
public class ScenarioControlCenterTest {

    public static void main(String[] args) {

        File file = new File("./textFiles/SceneTestData.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String text = reader.readLine();
            stringBuilder.append(text);
            while (text != null) {
                text = reader.readLine();
                if (text != null && text.length() == 0) continue;
                stringBuilder.append(text);
            }
            TreeElement root = new DataAnalizer().readSource(stringBuilder.toString());
            new ScenarioControlCenter();
            ColleagueManager manager = ColleagueManager.Holder.MANAGER;
            manager.setData("JTreePanel", root);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
