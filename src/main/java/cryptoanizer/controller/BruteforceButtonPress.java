package cryptoanizer.controller;

import cryptoanizer.view.ICryptoanizerCaesarGUI;
import cryptoanizer.model.ICryptoanizerCaesarModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BruteforceButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarModel iccConsole;
    private int key;

    public BruteforceButtonPress(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarModel iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        iccConsole.readFileToSourceTxt(iccGUI.getFilePath());
        key = iccConsole.bruteForceSourceTxt();
        iccConsole.encryptTxt(iccConsole.getSourceTxt(), -key);
        iccConsole.saveTxtToFile("decrypt.txt", iccConsole.getEncodeTxt());
        iccGUI.setTextAreaOut(iccConsole.getEncodeTxt());
        iccGUI.setKeyField(String.valueOf(key));
        iccGUI.setKeyLabel("Founded key -");
        iccGUI.resetSaveOutputButton(true);
    }
}
