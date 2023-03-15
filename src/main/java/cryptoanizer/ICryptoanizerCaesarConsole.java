package cryptoanizer;

public interface ICryptoanizerCaesarConsole {
    void readFileToSourceTxt(String fileName);
    void encryptTxt(String text, int key);
    int bruteForceSourceTxt(String text);
    int statAnalizSourceTxtByReferenceTxt(String cryptTxt, String planeTxt);
    void saveTxtToFile(String fileName, String text);
    String getSourceTxt();
    String getEncodeTxt();
    void setEncodeTxt(String text);
    String getReferenceTxt();
    void setReferenceTxt(String text);
    void clear();
    String getAlphabet();
    void setLoadedTxt(String text);
    String getLoadedTxt();
}
