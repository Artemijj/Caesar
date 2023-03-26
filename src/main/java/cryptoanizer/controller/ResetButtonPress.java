package cryptoanizer.controller;

import cryptoanizer.view.ICryptoanizerCaesarGUI;
import cryptoanizer.model.ICryptoanizerCaesarModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarModel iccConsole;

    public ResetButtonPress(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarModel iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        iccGUI.setTextAreaIn("");
        iccGUI.setTextAreaOut("");
        iccGUI.setFileLabel("Select a file for processing.");
        iccGUI.setKeyLabel("Set key.");
        iccGUI.setKeyField("");
        iccGUI.setReferenceLabel("Select the file for the sample.");
        iccGUI.setFilePath("");
        iccGUI.setReferencePath("");
        iccConsole.clear();
        iccGUI.resetEncryptButton(false);
        iccGUI.resetDecryptButton(false);
        iccGUI.resetBruteforceButton(false);
        iccGUI.resetStatanalysisButton(false);
        iccGUI.resetResetButton(false);
        iccGUI.resetSaveOutputButton(false);
    }
}
