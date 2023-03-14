package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BruteforceButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarConsole iccConsole;
    private int key;

    public BruteforceButtonPress(ICryptoanizerCaesarGUI iccGUI) {
        this.iccGUI = iccGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        iccConsole.readFileToSourceTxt(iccGUI.getFilePath());
        key = iccConsole.bruteForceSourceTxt(iccConsole.getSourceTxt());
        iccConsole.encryptTxt(-key);
        iccConsole.saveEncodeTxtToFile(iccConsole.getEncodeTxt());
        iccGUI.setTextArea(iccConsole.getEncodeTxt());
        iccGUI.setKeyField(String.valueOf(key));
        iccGUI.setKeyLabel("Founded key -");
    }
}
