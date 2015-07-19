import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ice on 19.07.15.
 */
public class FindText {

    ArrayList<String> text = new ArrayList<>();
    OpenFile openFileUa=new OpenFile();
    OpenFile openFileEn=new OpenFile();

    public void findTxt() throws FileNotFoundException {
        String endEn;
        Scanner scannerUa = new Scanner(openFileUa.fileUa());
        Scanner scannerEn = new Scanner(openFileEn.fileEn());
        while (scannerUa.hasNext() && scannerEn.hasNext()) {
            String stUa = (scannerUa.nextLine());
            String stEn = (scannerEn.nextLine());

            Pattern patern1 = Pattern.compile("[А-Я,І,Є,A-Z]\\.\\s[А-Я,A-Z,І,Є]\\.\\s");
            Matcher mat1 = patern1.matcher(stUa);
            Pattern patern1En = Pattern.compile("[A-Z]\\.\\s[A-Z]\\.\\s");
            Matcher mat1En = patern1En.matcher(stEn);


            Pattern patern2 = Pattern.compile("[А-Я,A-Z,І,Є]\\.\\s");
            Matcher mat2 = patern2.matcher(stUa);
            Pattern patern2En = Pattern.compile("[A-Z]\\.\\s");
            Matcher mat2En = patern2En.matcher(stEn);
            Pattern patern3En = Pattern.compile("[A-Z][a-z]\\.\\s");
            Matcher mat3En = patern3En.matcher(stEn);

            if (mat1.find()) {
                String start = stUa.substring(0, mat1.end());
                String endUa = stUa.substring(mat1.end());
                //  String endEn = stEn.substring(mat1En.end());
                if (mat1En.find()) {
                    endEn = stEn.substring(mat1En.end());
                    String fin = start + "[" + endUa + "]{" + endEn + "}";
                    text.add(fin);
                } else if (mat2En.find()) {
                    endEn = stEn.substring(mat2En.end());
                    String fin = start + "[" + endUa + "]{" + endEn + "}";
                    text.add(fin);
                } else if (mat3En.find()) {
                    endEn = stEn.substring(mat2En.end());
                    String fin = start + "[" + endUa + "]{" + endEn + "}";
                    text.add(fin);
                }
            } else if (mat2.find()) {
                String start = stUa.substring(0, mat2.end());
                String endUa = stUa.substring(mat2.end());
                if (mat1En.find()) {
                    endEn = stEn.substring(mat1En.end());
                    String fin = start + "[" + endUa + "]{" + endEn + "}";
                    text.add(fin);
                } else if (mat2En.find()) {
                    endEn = stEn.substring(mat2En.end());
                    String fin = start + "[" + endUa + "]{" + endEn + "}";
                    text.add(fin);
                } else if (mat3En.find()) {
                    endEn = stEn.substring(mat3En.end());
                    String fin = start + "[" + endUa + "]{" + endEn + "}";
                    text.add(fin);
                }
            }


        }
    }

    @Override
    public String toString() {
        return "FindText{" +
                "text=" + text +
                '}';
    }
}
