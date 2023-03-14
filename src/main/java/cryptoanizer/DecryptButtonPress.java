package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecryptButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccgui;
    private ICryptoanizerCaesar icc;//cryptoanizerCaesar = new CryptoanizerCaesar();
    private int key;

    public DecryptButtonPress(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String getValue = iccgui.getKeyValue();
        key = Integer.parseInt(getValue);
        if (key > 0 && key < 41) {
            icc.readFileToString(iccgui.getFilePath());
            icc.encryptString(icc.getSourceTxt(), -Math.abs(key));
            icc.saveStringToFile(icc.getEncodeTxt());
            iccgui.setTextArea(icc.getEncodeTxt());
        } else {
//            iccgui.alertWindow();
            iccgui.alertDialog();
        }
    }
}
