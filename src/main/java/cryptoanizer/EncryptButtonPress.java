package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarConsole iccConsole;
    private int key;

    public EncryptButtonPress(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarConsole iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String getValue = iccGUI.getKeyValue();
        try {
            key = Integer.parseInt(getValue);
            if (key > 0 && key < 41) {
                iccConsole.readFileToSourceTxt(iccGUI.getFilePath());
                iccConsole.encryptTxt(iccConsole.getSourceTxt(), key);
                iccConsole.saveTxtToFile("crypt.txt", iccConsole.getEncodeTxt());
                iccGUI.setTextAreaOut(iccConsole.getEncodeTxt());
            } else {
//            iccgui.alertWindow();
                iccGUI.alertDialog("The key can be a whole positive number from 1 to 40.");
            }
        } catch (NumberFormatException err) {
            iccGUI.alertDialog("It is necessary to enter the positive number from 1 to 40.");
        }
    }
}
