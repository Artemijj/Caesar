package cryptoanizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertClose implements ActionListener {
    private ICryptoanizerCaesarGUI iccgui;

    public AlertClose(ICryptoanizerCaesarGUI iccgui) {
        this.iccgui = iccgui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        iccgui.getAlert().removeAll();
        iccgui.getAlert().dispose();
    }
}
