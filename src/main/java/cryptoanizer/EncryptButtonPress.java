package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccgui;
    private ICryptoanizerCaesar icc;
    private int key;

    public EncryptButtonPress(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
//        this.icc = icc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String getValue = iccgui.getKeyValue();
        key = Integer.parseInt(getValue);
        if (key > 0 && key < 41) {
            icc.readFileToString(iccgui.getFilePath());
            icc.encryptString(icc.getSourceTxt(), key);
            icc.saveStringToFile(icc.getEncodeTxt());
            iccgui.setTextArea(icc.getEncodeTxt());
        } else {
//            iccgui.alertWindow();
            iccgui.alertDialog();
        }
    }
}
