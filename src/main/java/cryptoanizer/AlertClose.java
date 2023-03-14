package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertClose implements ActionListener {
    private ICryptoanizerCaesarGUI iccGUI;

    public AlertClose(ICryptoanizerCaesarGUI iccGUI) {
        this.iccGUI = iccGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        iccGUI.getAlert().removeAll();
        iccGUI.getAlert().dispose();
    }
}
