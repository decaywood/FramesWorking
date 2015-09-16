package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: decaywood
 * @date: 2015/9/15 18:26
 */
public class AnalizerTest {



    public static void main(String[] args) throws IOException {
        File file = new File("./textFiles/SceneTestData.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String text = reader.readLine();
        stringBuilder.append(text);
        while (text != null) {
            text = reader.readLine();
            if(text != null && text.length() == 0) continue;
            stringBuilder.append(text);
        }
        TreeElement root = new DataAnalizer().readSource(stringBuilder.toString());

    }
}
