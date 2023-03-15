package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarConsole iccConsole;
    private int key;

    public StatButtonPress(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarConsole iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        key = iccConsole.statAnalizSourceTxtByReferenceTxt(iccConsole.getLoadedTxt(), iccConsole.getReferenceTxt());
        iccConsole.encryptTxt(iccConsole.getLoadedTxt(), -key);
        iccConsole.saveTxtToFile("decrypt.txt", iccConsole.getEncodeTxt());
        iccGUI.setTextAreaOut(iccConsole.getEncodeTxt());
        iccGUI.setKeyField(String.valueOf(key));
        iccGUI.setKeyLabel("Founded key -");
    }
}
