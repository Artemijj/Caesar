package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileSelect implements ActionListener {

    private ICryptoanizerCaesarConsole iccConsole;
    private ICryptoanizerCaesarGUI iccGUI;

    public FileSelect(ICryptoanizerCaesarGUI iccGUI) {
        this.iccGUI = iccGUI;
//        this.icc = icc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    iccGUI.setFileLabel(file.getAbsolutePath());
                    iccGUI.setFilePath(file.getAbsolutePath());
                    iccConsole.readFileToSourceTxt(iccGUI.getFilePath());
                    iccGUI.setTextArea(iccConsole.getSourceTxt());
                    iccGUI.setKeyLabel("Set key.");
                }
    }
}
