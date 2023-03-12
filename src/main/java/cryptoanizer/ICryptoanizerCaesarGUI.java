package cryptoanizer;

import javax.swing.*;

public interface ICryptoanizerCaesarGUI {
    void  setFileLabel(String filename);
    void setTextArea(String text);
    void setLoadedTxt(String txt);
    String getLoadedTxt();
    void setReferenceLabel(String reference);
    void setReferenceTxt(String txt);
    String getReferenceTxt();
    String getKeyValue();
    void setFilePath(String path);
    String getFilePath();
    void setReferencePath(String path);
    String getReferencePath();
    void alertWindow();
    JFrame getAlert();
    void setKeyField(String text);
    void setKeyLabel(String text);
}
