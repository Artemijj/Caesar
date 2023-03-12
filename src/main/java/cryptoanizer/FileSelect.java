package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileSelect implements ActionListener {

//    private String filePath;
    private CryptoanizerCaesar cryptoanizerCaesar = new CryptoanizerCaesar();
//    public CryptoanizerCaesarGUI ccg = new CryptoanizerCaesarGUI();
    private ICryptoanizerCaesarGUI iccgui;

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
                    iccgui.setFileLabel(file.getAbsolutePath());
//                    eFileLabel.setText(file.getAbsolutePath());
                    iccgui.setFilePath(file.getAbsolutePath());
//                    System.out.println(filePath);
                    cryptoanizerCaesar.readFileToString(iccgui.getFilePath());
                    iccgui.setLoadedTxt(cryptoanizerCaesar.getSourceTxt());
///                    iccgui.textArea.setText(cryptoanizerCaesar.sourceTxt);
                    iccgui.setTextArea(cryptoanizerCaesar.getSourceTxt());
                    iccgui.setKeyLabel("Set key.");
                }
    }
}
