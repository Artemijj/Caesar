package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileSelect implements ActionListener {

    private ICryptoanizerCaesar icc;
    private ICryptoanizerCaesarGUI iccgui;

    public FileSelect(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
//        this.icc = icc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    iccgui.setFileLabel(file.getAbsolutePath());
                    iccgui.setFilePath(file.getAbsolutePath());
                    icc.readFileToString(iccgui.getFilePath());
//                    icc.setSourceTxt(icc.getSourceTxt());
                    iccgui.setTextArea(icc.getSourceTxt());
                    iccgui.setKeyLabel("Set key.");
                }
    }
}
