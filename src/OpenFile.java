import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ice on 19.07.15.
 */
public class OpenFile {

    public FileReader file(String nameFale) throws IOException {
        JFileChooser fileopen = new JFileChooser();
        int retUa = fileopen.showDialog(null, nameFale);
        FileReader reader = null;
        if (retUa == JFileChooser.APPROVE_OPTION) {
            File fileUa = fileopen.getSelectedFile();
            reader = new FileReader(fileUa.getCanonicalFile());

        }
        return reader;

    }
}
