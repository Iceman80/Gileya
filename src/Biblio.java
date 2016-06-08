import java.io.IOException;

/**
 * Created by ice on 19.07.15.
 */
public class Biblio {

   public void biblio() throws IOException {
       FindText findText = new FindText();
       findText.findTxt();
       for (String tmp : findText.text) {
           System.out.println(tmp);
       }
   }
}
