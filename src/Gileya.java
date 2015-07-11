/**
 * Created by ice on 11.07.15.
 */


        import java.io.*;
        import java.util.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;
        import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;

public class Gileya {
    public static void main(String[] args) throws IOException {
        ArrayList<String> text = new ArrayList<>();
        int i;

//        FileWriter fileWriter = new FileWriter("ZMIST.txt");
//        fileWriter.write("2 4 7 9");
//        fileWriter.close();
        FileReader reader = new FileReader("ZMIST.txt");
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            String st = (scanner.nextLine());

            Pattern patern1 = Pattern.compile("[А-Я,І,Є,A-Z]\\.\\s[А-Я,A-Z,І,Є]\\.\\s");
            Matcher mat1 = patern1.matcher(st);

            Pattern patern2 = Pattern.compile("[А-Я,A-Z,І,Є]\\.\\s");
            Matcher mat2 = patern2.matcher(st);

            if (mat1.find()) {
                String start = st.substring(0, mat1.end());
                String end = st.substring(mat1.end());
                String fin = start + "[" + end + "]\n";
                text.add(fin);
            } else if (mat2.find()) {
                String start = st.substring(0, mat2.end());
                String end = st.substring(mat2.end());
                String fin = start + "[" + end + "]\n";
                text.add(fin);
            }


        }
        FileWriter fileWriter = new FileWriter("ZMIST111.txt");

        fileWriter.write(text.toString());
        fileWriter.close();

        System.out.println(text);
        text.stream().forEach((tmp) -> {
            System.out.println(tmp);
        });
    }
}
