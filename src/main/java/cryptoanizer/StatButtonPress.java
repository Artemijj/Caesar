package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccgui;
    private ICryptoanizerCaesar icc;//cryptoanizerCaesar = new CryptoanizerCaesar();
    private int key;

    public StatButtonPress(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        key = icc.statAnaliz(icc.getSourceTxt(), icc.getReferenceTxt());
        icc.encryptString(icc.getSourceTxt(), -key);
        icc.saveStringToFile(icc.getEncodeTxt());
        iccgui.setTextArea(icc.getEncodeTxt());
        iccgui.setKeyField(String.valueOf(key));
        iccgui.setKeyLabel("Founded key -");
    }
}
