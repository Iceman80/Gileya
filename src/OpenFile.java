import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ice on 19.07.15.
 */
public class OpenFile {


    public FileReader fileUa() throws IOException {
        JFileChooser fileopenUa = new JFileChooser();
        int retUa = fileopenUa.showDialog(null, "Открыть файл Зміст");
        FileReader readerUa = null;
        if (retUa == JFileChooser.APPROVE_OPTION) {
            File fileUa = fileopenUa.getSelectedFile();
            readerUa = new FileReader(fileUa.getCanonicalFile());

        }
        return readerUa;

    }


    public FileReader fileEn() throws IOException {
        JFileChooser fileopenEn = new JFileChooser();
        int retEn = fileopenEn.showDialog(null, "Открыть файл CONTENT.txt");
        FileReader readerEn = null;
        if (retEn == JFileChooser.APPROVE_OPTION) {
            File fileEn = fileopenEn.getSelectedFile();
            readerEn = new FileReader(fileEn.getCanonicalFile());
        }
        return readerEn;
    }
}
