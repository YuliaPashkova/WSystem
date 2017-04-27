package GUI;
import java.io.File;
/*
 * Created by Юлия on 27.04.2017.
 */
public class FileFilter extends javax.swing.filechooser.FileFilter {
    String ext, description;

    FileFilter(String ext, String description) {
        this.ext = ext;
    }

    public String getDescription() {
        return description;
    }

    //В этом методе может быть любая проверка файла
    public boolean accept(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                return true;
            }
            return f.toString().endsWith(ext);
        }
        return false;
    }
}
