package cryptoanizer.controller;

import cryptoanizer.view.ICryptoanizerCaesarGUI;
import cryptoanizer.model.ICryptoanizerCaesarModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveOutputButtonPress implements ActionListener {
    private ICryptoanizerCaesarModel iccConsole;
    private ICryptoanizerCaesarGUI iccGUI;

    public SaveOutputButtonPress(ICryptoanizerCaesarGUI iccGUI, ICryptoanizerCaesarModel iccConsole) {
        this.iccGUI = iccGUI;
        this.iccConsole = iccConsole;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser filesave = new JFileChooser();
        filesave.setDialogTitle("Save file");
        int ret = filesave.showSaveDialog(null);
        filesave.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (ret == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filesave.getSelectedFile()))){
                writer.write(iccConsole.getEncodeTxt());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
