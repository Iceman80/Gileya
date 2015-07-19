import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by ice on 19.07.15.
 */
public class OpenFile {


    public FileReader fileUa() throws FileNotFoundException {
        JFileChooser fileopenUa = new JFileChooser();
        int retUa = fileopenUa.showDialog(null, "Открыть файл Зміст");
        FileReader readerUa = null;
        if (retUa == JFileChooser.APPROVE_OPTION) {
            File fileUa = fileopenUa.getSelectedFile();
            readerUa = new FileReader(fileUa.getName());

        }
        return readerUa;

    }


    public FileReader fileEn() throws FileNotFoundException {
        JFileChooser fileopenEn = new JFileChooser();
        int retEn = fileopenEn.showDialog(null, "Открыть файл CONTENT.txt");
        FileReader readerEn = null;
        if (retEn == JFileChooser.APPROVE_OPTION) {
            File fileEn = fileopenEn.getSelectedFile();
            readerEn = new FileReader(fileEn.getName());
        }
        return readerEn;
    }
}
