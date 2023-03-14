package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccgui;
    private CryptoanizerCaesar cryptoanizerCaesar = new CryptoanizerCaesar();

    public ResetButtonPress(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        iccgui.setTextArea("");
        iccgui.setFileLabel("Select a file for processing.");
        iccgui.setKeyLabel("Set key.");
        iccgui.setKeyField("");
        iccgui.setReferenceLabel("Select the file for the sample.");
//        iccgui.setLoadedTxt("");
//        iccgui.setReferenceTxt("");
        iccgui.setFilePath("");
        iccgui.setReferencePath("");
        cryptoanizerCaesar.setSourceTxt("");
        cryptoanizerCaesar.setEncodeTxt("");
        cryptoanizerCaesar.setReferenceTxt("");
    }
}
