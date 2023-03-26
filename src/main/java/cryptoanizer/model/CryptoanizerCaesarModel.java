package cryptoanizer.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CryptoanizerCaesarModel implements ICryptoanizerCaesarModel {
    private String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,\":-!? ";
    private String sourceTxt;
    private String encodeTxt;
    private String loadedTxt;
    private String referenceTxt;
    private boolean guiMark = false;

    public void readFileToSourceTxt(String fileName) {
        String res = null;
        try {
            res = Files.readString(Paths.get(fileName)).toUpperCase();
        } catch (IOException e) {
            System.err.println("No such file...");
            if (guiMark == false) {
                System.exit(1);
            }
        }
        sourceTxt = res;
    }

    public void encryptTxt(String text, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int chIndex = alphabet.indexOf(ch);
            if (chIndex != -1) {
                if (chIndex + key < 0) {
                    key = alphabet.length() + key;
                }
                int newKey = chIndex + key;
                if (newKey >= alphabet.length()) {
                    int pos = (newKey) - alphabet.length();
                    sb.append(alphabet.charAt(pos));
                } else {
                    sb.append(alphabet.charAt(newKey));
                }
            } else {
                sb.append(ch);
            }
        }
        encodeTxt = sb.toString();
    }

    public int bruteForceSourceTxt() {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            int count = 0;
            encryptTxt(sourceTxt, -i);
            String bf = encodeTxt;
            int dot = bf.split(". ", -1).length - 1;
            int comma = bf.split(", ", -1).length - 1;
            count = dot + comma;
            if (max < count) {
                max = count;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int statAnalizSourceTxtByReferenceTxt(String cryptTxt, String planeTxt) {
        int key = maxSymInd(cryptTxt) - maxSymInd(planeTxt);
        if (key < 0) {
            key = alphabet.length() + key;
        }
        return key;
    }

    public void saveTxtToFile(String fileName, String text) {
        try {
            Files.writeString(Path.of(fileName), text);
        } catch (IOException e) {
            System.err.println("Ошибка...");
            System.exit(1);
        }
    }

    public int maxSymInd(String txt) {
        int max = 0;
        int maxIndex = 0;
        int[] arr = new int[alphabet.length()];
        for (int i = 0; i < txt.length(); i++) {
            char ch = txt.charAt(i);
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                arr[index]++;
                if (arr[index] > max) {
                    max = arr[index];
                    maxIndex = index;
                }
            }
        }
        return maxIndex;
    }

    public String getSourceTxt() {
        return sourceTxt;
    }

    public String getEncodeTxt() {
        return encodeTxt;
    }

    public void setEncodeTxt(String text) {
        encodeTxt = text;
    }

    public String getReferenceTxt() {
        return referenceTxt;
    }

    public void setReferenceTxt(String text) {
        referenceTxt = text;
    }

    public void clear() {
        sourceTxt = "";
        encodeTxt = "";
        referenceTxt = "";
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setLoadedTxt(String text) {
        loadedTxt = text;
    }

    public String getLoadedTxt() {
        return loadedTxt;
    }

    public void setGuiMark(boolean mark) {
        guiMark = mark;
    }
}
