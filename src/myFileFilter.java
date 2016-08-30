import java.io.File;

/**
 * Created by vladislav on 06.02.2016.
 */
public class myFileFilter extends javax.swing.filechooser.FileFilter {
    String ext, description;

    public String getDescription() {
        return description;
    }
    myFileFilter(String ext, String description) {
        this.ext = ext;
    }
    public boolean accept(File f) {
        if(f != null) {
            if(f.isDirectory()) {
                return true;
            }
            return f.toString().endsWith(ext);
        }
        return false;
    }
}