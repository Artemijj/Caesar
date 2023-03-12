package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccgui;
    private CryptoanizerCaesar cryptoanizerCaesar = new CryptoanizerCaesar();
    private int key;

    public EncryptButtonPress(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String getValue = iccgui.getKeyValue();
        key = Integer.parseInt(getValue);
        if (key > 0 && key < 41) {
            cryptoanizerCaesar.readFileToString(iccgui.getFilePath());
            cryptoanizerCaesar.encryptString(iccgui.getLoadedTxt(), key);
            cryptoanizerCaesar.saveStringToFile(cryptoanizerCaesar.getEncodeTxt());
            iccgui.setTextArea(cryptoanizerCaesar.getEncodeTxt());
        } else {
            iccgui.alertWindow();
        }
    }
}
