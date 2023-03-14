package cryptoanizer;

public interface ICryptoanizerCaesarConsole {
    void readFileToSourceTxt(String fileName);
    void encryptTxt(int key);
    int bruteForceSourceTxt(String text);
    int statAnalizSourceTxtByReferenceTxt(String cryptTxt, String planeTxt);
    void saveEncodeTxtToFile(String text);
//    int maxSymInd(String txt);
    String getSourceTxt();
    String getEncodeTxt();
//    void setSourceTxt(String text);//?
    void setEncodeTxt(String text);//?
    String getReferenceTxt();
    void setReferenceTxt(String text); //?
    void clear();
    String getAlphabet();
}
