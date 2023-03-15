package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonPress implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;
    private ICryptoanizerCaesarConsole iccConsole;

    public ResetButtonPress(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarConsole iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        iccGUI.setTextAreaIn("");
        iccGUI.setTextAreaOut("");
        iccGUI.setFileLabel("Select a file for processing.");
        iccGUI.setKeyLabel("Set key.");
        iccGUI.setKeyField("");
        iccGUI.setReferenceLabel("Select the file for the sample.");
        iccGUI.setFilePath("");
        iccGUI.setReferencePath("");
        iccConsole.clear();
    }
}
