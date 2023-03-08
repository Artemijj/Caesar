package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileSelect implements ActionListener {

    public int key;
    public String filePath;
    public String encryptedTxt;
    public String referenceTxt;
    public CryptoanizerCaesar cryptoanizerCaesar = new CryptoanizerCaesar();
//    public CryptoanizerCaesarGUI ccg = new CryptoanizerCaesarGUI();
    public ICryptoanizerCaesarGUI iccgui;

    public FileSelect(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
//                    System.out.println(file.toString());
//                    ccg.fileLabel.setText(file.getAbsolutePath());
                    iccgui.setFileName(file.getAbsolutePath());
                    filePath = file.getAbsolutePath();
                    System.out.println(filePath);
                    cryptoanizerCaesar.readFileToString(filePath);
///                    ccg.textArea.setText(cryptoanizerCaesar.sourceTxt);
                }
    }
}
