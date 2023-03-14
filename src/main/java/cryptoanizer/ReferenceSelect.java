package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ReferenceSelect implements ActionListener {
    public ICryptoanizerCaesarGUI iccgui;
    public ICryptoanizerCaesar icc;//cryptoanizerCaesar = new CryptoanizerCaesar();

    public ReferenceSelect(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    iccgui.setReferenceLabel(file.getAbsolutePath());
                    iccgui.setReferencePath(file.getAbsolutePath());
                    icc.readFileToString(iccgui.getReferencePath());
                    icc.setReferenceTxt(icc.getSourceTxt());
                }
    }
}
