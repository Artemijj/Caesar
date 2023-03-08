package cryptoanizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CryptoanizerCaesar {
    private static String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.,\":-!? ";
    private static String errorMessage =
            "Проверьте правильность введённых параметров.\n" +
                    "Для получения справки введите -help";
    private static String helpMessage =
            "-c <filename>  - Копирование файла.\n" +
                    "-e <key> <filename>  - Шифрование файла (0 < key <= 40).\n" +
                    "-e <-key> <filename>  - Дешифрование файла (0 > key >= -40).\n" +
                    "-b <filename>  - Дешифрование файла (bruteforce).\n" +
                    "-s <cryptFilename> <planeFilename  - Дешифрование файла методом статистического анализа";
    public String sourceTxt;
    public String encodeTxt;
//    public String decodeTxt;

    public static void main(String[] args) {
        CryptoanizerCaesar cryptC = new CryptoanizerCaesar();
        if (args.length == 0) {
            System.err.println(errorMessage);
            System.exit(1);
        }
        String progKey = args[0];
        if (progKey.equals("-c")) {
            if (args.length != 2) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String file = args[1];
            cryptC.readFileToString(file);
            cryptC.saveStringToFile(cryptC.sourceTxt);
        } else if (progKey.equals("-e")) {
            if (args.length != 3) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            int encryptKey = Integer.parseInt(args[1]);
            if (encryptKey >= alphabet.length()) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String file = args[2];
            cryptC.readFileToString(file);
            cryptC.encryptString(cryptC.sourceTxt, encryptKey);
            cryptC.saveStringToFile(cryptC.encodeTxt);
        } else if (progKey.equals("-d")) {
            if (args.length != 3) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            int encryptKey = Integer.parseInt(args[1]);
            if (encryptKey >= alphabet.length()) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String file = args[2];
            cryptC.readFileToString(file);
            cryptC.encryptString(cryptC.sourceTxt, -Math.abs(encryptKey));
            cryptC.saveStringToFile(cryptC.encodeTxt);
        } else if (progKey.equals("-b")) {
            if (args.length != 2) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String file = args[1];
            cryptC.readFileToString(file);
            int key = cryptC.bruteForce(cryptC.sourceTxt);
            cryptC.encryptString(cryptC.sourceTxt, key);
            cryptC.saveStringToFile(cryptC.encodeTxt);
        } else if (progKey.equals("-s")) {
            if (args.length != 3) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String cryptFile = args[1];
            String planeFile = args[2];
            cryptC.readFileToString(cryptFile);
            cryptC.encodeTxt = cryptC.sourceTxt;
            cryptC.readFileToString(planeFile);
            int key = cryptC.statAnaliz(cryptC.encodeTxt, cryptC.sourceTxt);
            cryptC.encryptString(cryptC.encodeTxt, -key);
            cryptC.saveStringToFile(cryptC.encodeTxt);
        } else if (progKey.equals("-g")) {
            CryptoanizerCaesarGUI ccg = new CryptoanizerCaesarGUI();
            ccg.mainWindow();
        } else if (progKey.equals("-help")) {
            System.out.println(helpMessage);
        } else {
            System.out.println(helpMessage);
        }
    }

    public void readFileToString(String fileName) {
        String res = null;
        try {
            res = Files.readString(Paths.get(fileName)).toUpperCase();
        } catch (IOException e) {
            System.err.println("Такого файла нет...");
            System.exit(1);
        }
        sourceTxt = res;
    }

    public void encryptString(String text, int key) {
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

    public int bruteForce(String text) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            int count = 0;
            encryptString(text, -i);
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

    public int statAnaliz(String cryptTxt, String planeTxt) {
        int key = maxSymInd(cryptTxt) - maxSymInd(planeTxt);
        if (key < 0) {
            key = alphabet.length() + key;
        }
        return key;
    }

    public void saveStringToFile(String text) {
        try {
            Files.writeString(Path.of("OutputFile.txt"), text);
        } catch (IOException e) {
            System.err.println("Ошибка...");
            System.exit(1);
        }
    }

    private int maxSymInd(String txt) {
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
}
