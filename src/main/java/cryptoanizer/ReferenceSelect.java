package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ReferenceSelect implements ActionListener {
    public ICryptoanizerCaesarGUI iccGUI;
    public ICryptoanizerCaesarConsole iccConsole;//cryptoanizerCaesar = new CryptoanizerCaesar();

    public ReferenceSelect(ICryptoanizerCaesarGUI iccGUI) {
        this.iccGUI = iccGUI;
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
                }
    }
}
