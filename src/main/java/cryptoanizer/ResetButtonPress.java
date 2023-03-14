package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarConsole iccConsole;

    public ResetButtonPress(ICryptoanizerCaesarGUI iccGUI) {
        this.iccGUI = iccGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        iccGUI.setTextArea("");
        iccGUI.setFileLabel("Select a file for processing.");
        iccGUI.setKeyLabel("Set key.");
        iccGUI.setKeyField("");
        iccGUI.setReferenceLabel("Select the file for the sample.");
//        iccgui.setLoadedTxt("");
//        iccgui.setReferenceTxt("");
        iccGUI.setFilePath("");
        iccGUI.setReferencePath("");
        iccConsole.clear();
    }
}
