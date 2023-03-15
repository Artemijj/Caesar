package cryptoanizer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SourceFileSelect implements ActionListener {

    private ICryptoanizerCaesarConsole iccConsole;
    private ICryptoanizerCaesarGUI iccGUI;

    public SourceFileSelect(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarConsole iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    iccGUI.setFileLabel(file.getAbsolutePath());
                    iccGUI.setFilePath(file.getAbsolutePath());
                    iccConsole.readFileToSourceTxt(iccGUI.getFilePath());
                    iccConsole.setLoadedTxt(iccConsole.getSourceTxt());
                    iccGUI.setTextAreaIn(iccConsole.getSourceTxt());
                    iccConsole.saveTxtToFile("input.txt", iccConsole.getSourceTxt());
                    iccGUI.setKeyLabel("Set key.");
                }
    }
}
