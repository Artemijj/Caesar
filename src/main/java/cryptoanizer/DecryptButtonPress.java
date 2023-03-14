package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecryptButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarConsole iccConsole;//cryptoanizerCaesar = new CryptoanizerCaesar();
    private int key;

    public DecryptButtonPress(ICryptoanizerCaesarGUI iccGUI) {
        this.iccGUI = iccGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String getValue = iccGUI.getKeyValue();
        key = Integer.parseInt(getValue);
        if (key > 0 && key < 41) {
            iccConsole.readFileToSourceTxt(iccGUI.getFilePath());
            iccConsole.encryptTxt(-Math.abs(key));
            iccConsole.saveEncodeTxtToFile(iccConsole.getEncodeTxt());
            iccGUI.setTextArea(iccConsole.getEncodeTxt());
        } else {
//            iccgui.alertWindow();
            iccGUI.alertDialog();
        }
    }
}
