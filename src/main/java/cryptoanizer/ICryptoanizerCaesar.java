package cryptoanizer;

public interface ICryptoanizerCaesar {
    void readFileToString(String fileName);
    void encryptString(String text, int key);
    int bruteForce(String text);
    int statAnaliz(String cryptTxt, String planeTxt);
    void saveStringToFile(String text);
    int maxSymInd(String txt);
    String getSourceTxt();
    String getEncodeTxt();
    void setSourceTxt(String text);
    void setEncodeTxt(String text);
    String getReferenceTxt();
    void setReferenceTxt(String text);
}
