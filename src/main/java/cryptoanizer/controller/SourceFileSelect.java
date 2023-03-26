package cryptoanizer.controller;

import cryptoanizer.view.ICryptoanizerCaesarGUI;
import cryptoanizer.model.ICryptoanizerCaesarModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SourceFileSelect implements ActionListener {

    private ICryptoanizerCaesarModel iccConsole;
    private ICryptoanizerCaesarGUI iccGUI;

    public SourceFileSelect(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarModel iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    iccGUI.setFileLabel(file.getAbsolutePath());
                    iccGUI.setFilePath(file.getAbsolutePath());
                    iccConsole.readFileToSourceTxt(iccGUI.getFilePath());
                    iccConsole.setLoadedTxt(iccConsole.getSourceTxt());
                    iccGUI.setTextAreaIn(iccConsole.getSourceTxt());
                    iccConsole.saveTxtToFile("input.txt", iccConsole.getSourceTxt());
                    iccGUI.setKeyLabel("Set key.");
                    if (!iccGUI.getFileLabel().equals("Select a file for processing.")) {
                        iccGUI.resetEncryptButton(true);
                        iccGUI.resetDecryptButton(true);
                        iccGUI.resetBruteforceButton(true);
                        iccGUI.resetResetButton(true);
                    }
                }
    }
}
