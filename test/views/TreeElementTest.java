package views;

import data.DataAnalizer;
import data.TreeElement;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author: decaywood
 * @date: 2015/9/16 20:19
 */
public class TreeElementTest extends  AbstractTestFrame {
    @Override
    protected void init() {
        File file = new File("./textFiles/SceneTestData.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String text = reader.readLine();
            stringBuilder.append(text);
            while (text != null) {
                text = reader.readLine();
                if(text != null && text.length() == 0) continue;
                stringBuilder.append(text);
            }
            TreeElement root = new DataAnalizer().readSource(stringBuilder.toString());
            setLayout(new BorderLayout());
            final JTree jTree = new JTree(root);
            add(jTree, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TreeElementTest();
    }
}
