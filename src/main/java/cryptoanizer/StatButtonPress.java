package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarConsole iccConsole;//cryptoanizerCaesar = new CryptoanizerCaesar();
    private int key;

    public StatButtonPress(ICryptoanizerCaesarGUI iccGUI) {
        this.iccGUI = iccGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        key = iccConsole.statAnalizSourceTxtByReferenceTxt(iccConsole.getSourceTxt(), iccConsole.getReferenceTxt());
        iccConsole.encryptTxt(-key);
        iccConsole.saveEncodeTxtToFile(iccConsole.getEncodeTxt());
        iccGUI.setTextArea(iccConsole.getEncodeTxt());
        iccGUI.setKeyField(String.valueOf(key));
        iccGUI.setKeyLabel("Founded key -");
    }
}
