package GUI;
import java.io.File;
/*
 * Created by Юлия on 27.04.2017.
 */
class FileFilter extends javax.swing.filechooser.FileFilter {
    private String ext, description;

    FileFilter(String ext) {
        this.ext = ext;
    }

    public String getDescription() {
        return description;
    }

    //В этом методе может быть любая проверка файла
    public boolean accept(File f) {
        return f != null && (f.isDirectory() || f.toString().endsWith(ext));
    }
}
