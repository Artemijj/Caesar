package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarConsole iccConsole;
    private int key;

    public EncryptButtonPress(ICryptoanizerCaesarGUI iccGUI) {
        this.iccGUI = iccGUI;
//        this.icc = icc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String getValue = iccGUI.getKeyValue();
        key = Integer.parseInt(getValue);
        if (key > 0 && key < 41) {
            iccConsole.readFileToSourceTxt(iccGUI.getFilePath());
            iccConsole.encryptTxt(key);
            iccConsole.saveEncodeTxtToFile(iccConsole.getEncodeTxt());
            iccGUI.setTextArea(iccConsole.getEncodeTxt());
        } else {
//            iccgui.alertWindow();
            iccGUI.alertDialog();
        }
    }
}
