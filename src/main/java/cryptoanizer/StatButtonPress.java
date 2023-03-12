package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccgui;
    private CryptoanizerCaesar cryptoanizerCaesar = new CryptoanizerCaesar();
    private int key;

    public StatButtonPress(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        key = cryptoanizerCaesar.statAnaliz(iccgui.getLoadedTxt(), iccgui.getReferenceTxt());
        cryptoanizerCaesar.encryptString(iccgui.getLoadedTxt(), -key);
        cryptoanizerCaesar.saveStringToFile(cryptoanizerCaesar.getEncodeTxt());
        iccgui.setTextArea(cryptoanizerCaesar.getEncodeTxt());
        iccgui.setKeyField(String.valueOf(key));
        iccgui.setKeyLabel("Founded key -");
    }
}
