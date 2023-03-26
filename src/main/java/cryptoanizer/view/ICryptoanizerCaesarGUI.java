package cryptoanizer.view;

import javax.swing.*;

public interface ICryptoanizerCaesarGUI {
    void mainWindow();
    void  setFileLabel(String filename);
    String getFileLabel();
    void setTextAreaIn(String text);
    void setTextAreaOut(String text);
    void setReferenceLabel(String reference);
    String getReferenceLabel();
    String getKeyValue();
    void setFilePath(String path);
    String getFilePath();
    void setReferencePath(String path);
    String getReferencePath();
    void setKeyField(String text);
    void setKeyLabel(String text);
    void alertDialog(String alert);
    void resetEncryptButton(boolean bool);
    void resetDecryptButton(boolean bool);
    void resetBruteforceButton(boolean bool);
    void resetStatanalysisButton(boolean bool);
    void resetResetButton(boolean bool);
    void resetSaveOutputButton(boolean bool);
}
