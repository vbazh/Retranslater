import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by vladislav on 06.02.2016.
 */
public class Translater implements ActionListener {
    JTextArea filelist, newfilelist;
    OpenFile openfile;
    String PATH;
    JScrollPane scrolllist,scrollnewlist;


    Translater(){
        JFrame mainframe = new JFrame("Retranslater");
        mainframe.setLayout(new FlowLayout());
        mainframe.setSize(1200,700);
        mainframe.setResizable(false);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        filelist = new JTextArea();
        newfilelist = new JTextArea();

        scrolllist = new JScrollPane(filelist);
        scrolllist.setPreferredSize(new Dimension(500,700));
        scrollnewlist = new JScrollPane(newfilelist);
        scrollnewlist.setPreferredSize(new Dimension(500,700));

        JButton openButton = new JButton("Choose");
        JButton translateButton = new JButton("Translate");


        openButton.addActionListener(this);
        translateButton.addActionListener(this);



        mainframe.add(openButton);
        mainframe.add(translateButton);

        mainframe.add(scrolllist);
        mainframe.add(scrollnewlist);

        mainframe.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getActionCommand().equals("Choose")) {
                openfile = new OpenFile();
                filelist.setText(openfile.files[0].getName());
                for (int i = 1; i < openfile.files.length; i++) {
                    filelist.append("\n");
                    filelist.append(openfile.files[i].getName());
                }
                PATH = openfile.files[0].getParent();
                PATH = PATH+"\\";
                System.out.println(PATH);
            }
            if (ae.getActionCommand().equals("Translate")){

                for (int i=0; i<openfile.files.length; i++) {
                    File file = new File(PATH +Transliterator.transliterate(openfile.files[i].getName()));
                    System.out.println("transliterated");
                    openfile.files[i].renameTo(file);

                    newfilelist.append(file.getName());
                    newfilelist.append("\n");



                }

            }
        } catch (Exception exc) {
        }

    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Translater();

            }
        });




    }

}
