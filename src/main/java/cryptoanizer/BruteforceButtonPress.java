package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BruteforceButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccgui;
    private CryptoanizerCaesar cryptoanizerCaesar = new CryptoanizerCaesar();
    private int key;

    public BruteforceButtonPress(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        cryptoanizerCaesar.readFileToString(iccgui.getFilePath());
        key = cryptoanizerCaesar.bruteForce(cryptoanizerCaesar.getSourceTxt());
        cryptoanizerCaesar.encryptString(cryptoanizerCaesar.getSourceTxt(), -key);
        cryptoanizerCaesar.saveStringToFile(cryptoanizerCaesar.getEncodeTxt());
        iccgui.setTextArea(cryptoanizerCaesar.getEncodeTxt());
        iccgui.setKeyField(String.valueOf(key));
        iccgui.setKeyLabel("Founded key -");
    }
}
