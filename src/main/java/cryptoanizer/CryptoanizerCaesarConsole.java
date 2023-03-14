package cryptoanizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CryptoanizerCaesarConsole implements ICryptoanizerCaesarConsole {
    private static String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,\":-!? ";
//    private static String errorMessage =
//        "Проверьте правильность введённых параметров.\n" +
//        "Для получения справки введите -help";
//    private static String helpMessage =
//        "-c <filename>  - Копирование файла.\n" +
//        "-e <key> <filename>  - Шифрование файла (0 < key <= 40).\n" +
//        "-d <key> <filename>  - Дешифрование файла (0 < key <= 40).\n" +
//        "-b <filename>  - Дешифрование файла (bruteforce).\n" +
//        "-s <cryptFilename> <referenceFilename>  - Дешифрование файла методом статистического анализа";
    private String sourceTxt;
    private String encodeTxt;
    private String referenceTxt;
    private ICryptoanizerCaesarGUI iccgui;

//    public static void main(String[] args) {
//        CryptoanizerCaesarConsole cryptC = new CryptoanizerCaesarConsole();
//        if (args.length == 0) {
//            System.err.println(errorMessage);
//            System.exit(1);
//        }
//        String progKey = args[0];
//        if (progKey.equals("-c")) {
//            if (args.length != 2) {
//                System.err.println(errorMessage);
//                System.exit(1);
//            }
//            String file = args[1];
//            cryptC.readFileToSourceTxt(file);
//            cryptC.saveEncodeTxtToFile(cryptC.sourceTxt);
//        } else if (progKey.equals("-e")) {
//            if (args.length != 3) {
//                System.err.println(errorMessage);
//                System.exit(1);
//            }
//            int encryptKey = Integer.parseInt(args[1]);
//            if (encryptKey >= alphabet.length()) {
//                System.err.println(errorMessage);
//                System.exit(1);
//            }
//            String file = args[2];
//            cryptC.readFileToSourceTxt(file);
//            cryptC.encryptTxt(encryptKey);
//            cryptC.saveEncodeTxtToFile(cryptC.encodeTxt);
//        } else if (progKey.equals("-d")) {
//            if (args.length != 3) {
//                System.err.println(errorMessage);
//                System.exit(1);
//            }
//            int encryptKey = Integer.parseInt(args[1]);
//            if (encryptKey >= alphabet.length()) {
//                System.err.println(errorMessage);
//                System.exit(1);
//            }
//            String file = args[2];
//            cryptC.readFileToSourceTxt(file);
//            cryptC.encryptTxt(-Math.abs(encryptKey));
//            cryptC.saveEncodeTxtToFile(cryptC.encodeTxt);
//        } else if (progKey.equals("-b")) {
//            if (args.length != 2) {
//                System.err.println(errorMessage);
//                System.exit(1);
//            }
//            String file = args[1];
//            cryptC.readFileToSourceTxt(file);
//            int key = cryptC.bruteForceSourceTxt(cryptC.sourceTxt);
//            cryptC.encryptTxt(key);
//            cryptC.saveEncodeTxtToFile(cryptC.encodeTxt);
//        } else if (progKey.equals("-s")) {
//            if (args.length != 3) {
//                System.err.println(errorMessage);
//                System.exit(1);
//            }
//            String cryptFile = args[1];
//            String planeFile = args[2];
//            cryptC.readFileToSourceTxt(cryptFile);
//            cryptC.encodeTxt = cryptC.sourceTxt;
//            cryptC.readFileToSourceTxt(planeFile);
//            cryptC.referenceTxt = cryptC.sourceTxt;
//            int key = cryptC.statAnalizSourceTxtByReferenceTxt(cryptC.encodeTxt, cryptC.referenceTxt);
//            cryptC.encryptTxt(-key);
//            cryptC.saveEncodeTxtToFile(cryptC.encodeTxt);
//        } else if (progKey.equals("-g")) {
//            CryptoanizerCaesarGUI ccg = new CryptoanizerCaesarGUI();
//            ccg.mainWindow();
//        } else if (progKey.equals("-help")) {
//            System.out.println(helpMessage);
//        } else {
//            System.out.println(helpMessage);
//        }
//    }

    public void readFileToSourceTxt(String fileName) {
        String res = null;
        try {
            res = Files.readString(Paths.get(fileName)).toUpperCase();
        } catch (IOException e) {
            System.err.println("Такого файла нет...");
            System.exit(1);
        }
        sourceTxt = res;
    }

    public void encryptTxt(int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceTxt.length(); i++) {
            char ch = sourceTxt.charAt(i);
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

    public int bruteForceSourceTxt(String text) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            int count = 0;
            encryptTxt(-i);
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

    public void saveEncodeTxtToFile(String text) {
        try {
            Files.writeString(Path.of("OutputFile.txt"), text);
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

//    public void setSourceTxt(String text) {
//        sourceTxt = text;
//    }

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
}
