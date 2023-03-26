package cryptoanizer.controller;

import cryptoanizer.view.ICryptoanizerCaesarGUI;
import cryptoanizer.model.ICryptoanizerCaesarModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ReferenceFileSelect implements ActionListener {
    public ICryptoanizerCaesarGUI iccGUI;
    public ICryptoanizerCaesarModel iccConsole;

    public ReferenceFileSelect(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarModel iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    iccGUI.setReferenceLabel(file.getAbsolutePath());
                    iccGUI.setReferencePath(file.getAbsolutePath());
                    iccConsole.readFileToSourceTxt(iccGUI.getReferencePath());
                    iccConsole.setReferenceTxt(iccConsole.getSourceTxt());
                    iccConsole.saveTxtToFile("reference.txt", iccConsole.getSourceTxt());
                    iccGUI.setKeyLabel("Set key.");
                    if (!iccGUI.getReferenceLabel().equals("Select the file for the sample.")) {
                        iccGUI.resetStatanalysisButton(true);
                        iccGUI.resetEncryptButton(false);
                        iccGUI.resetDecryptButton(false);
                        iccGUI.resetBruteforceButton(false);
                        iccGUI.resetResetButton(true);
                    }
                }
    }
}
