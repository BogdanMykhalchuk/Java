package JavaRush.MultiThreading.HTMLEditor;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Dreawalker on 30.04.2017.
 */
public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        String fileName = f.getName();
        if(f.isDirectory() || fileName.substring(fileName.length() - 5).toLowerCase().equals(".html") ||
                fileName.substring(fileName.length() - 4).toLowerCase().equals(".htm"))  {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
