import javax.swing.*;
import java.io.File;

/**
 * Created by vladislav on 06.02.2016.
 */



public class OpenFile extends JFrame {
    public static File[] files;
    OpenFile(){
        setBounds(0,0,500,500);
        JFileChooser dialog = new JFileChooser();
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setApproveButtonText("Choose");
        dialog.setDialogTitle("Choose file for changing");
        dialog.setDialogType(JFileChooser.OPEN_DIALOG);
        dialog.setMultiSelectionEnabled(true);
        dialog.setFileFilter(new myFileFilter(".mp3",""));

        dialog.showOpenDialog(this);
        files = dialog.getSelectedFiles();

        //setVisible(true);
    }
}
