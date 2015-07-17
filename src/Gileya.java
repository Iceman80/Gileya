/**
 * Created by ice on 11.07.15.
 */


import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;

public class Gileya {
    public static void main(String[] args) throws IOException {
        ArrayList<String> text = new ArrayList<>();

//        FileWriter fileWriter = new FileWriter("ZMIST.txt");
//        fileWriter.write("2 4 7 9");
//        fileWriter.close();
        JFileChooser fileopenUa = new JFileChooser();
        int retUa = fileopenUa.showDialog(null, "Открыть файл Зміст");
        if (retUa == JFileChooser.APPROVE_OPTION) {
            File fileUa = fileopenUa.getSelectedFile();
            FileReader readerUa = new FileReader(fileUa.getName());

            JFileChooser fileopenEn = new JFileChooser();
            int retEn = fileopenEn.showDialog(null, "Открыть файл CONTENT.txt");
            if (retEn == JFileChooser.APPROVE_OPTION) {
                File fileEn = fileopenEn.getSelectedFile();
                FileReader readerEn = new FileReader(fileEn.getName());
    /*
     * Какие-то действия.
     */

                String endEn;
                Scanner scannerUa = new Scanner(readerUa);
                Scanner scannerEn = new Scanner(readerEn);
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
//        try {
//            FileWriter fileWriter = new FileWriter("ZMIST111.txt");
//
//            fileWriter.write(text.toString());
//            fileWriter.close();
//        } catch (IOException e) {
//            System.out.println("Ошибка записи файла");
//        }

//        System.out.println(text);
                text.stream().forEach((tmp) -> {
                    System.out.println(tmp);
                });
            }
        }
    }
}
