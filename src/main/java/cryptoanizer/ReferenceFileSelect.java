package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ReferenceFileSelect implements ActionListener {
    public ICryptoanizerCaesarGUI iccGUI;
    public ICryptoanizerCaesarConsole iccConsole;

    public ReferenceFileSelect(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarConsole iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    iccGUI.setReferenceLabel(file.getAbsolutePath());
                    iccGUI.setReferencePath(file.getAbsolutePath());
                    iccConsole.readFileToSourceTxt(iccGUI.getReferencePath());
                    iccConsole.setReferenceTxt(iccConsole.getSourceTxt());
                    iccConsole.saveTxtToFile("reference.txt", iccConsole.getSourceTxt());
                    iccGUI.setKeyLabel("Set key.");
                }
    }
}
