/**
 * Created by ice on 11.07.15.
 */

import java.io.IOException;

public class Gileya {
    public static void main(String[] args) throws IOException {
        FindText findText = new FindText();
        findText.findTxt();

        for (String tmp : findText.text) {
            System.out.println(tmp);
        }
    }
}