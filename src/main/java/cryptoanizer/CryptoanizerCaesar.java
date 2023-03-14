package cryptoanizer;

public class CryptoanizerCaesar {
    private static String errorMessage =
            "Проверьте правильность введённых параметров.\n" +
            "Для получения справки введите -help";
    private static String helpMessage =
            "-c <filename>  - Копирование файла.\n" +
            "-e <key> <filename>  - Шифрование файла (0 < key <= 40).\n" +
            "-d <key> <filename>  - Дешифрование файла (0 < key <= 40).\n" +
            "-b <filename>  - Дешифрование файла (bruteforce).\n" +
            "-s <cryptFilename> <referenceFilename>  - Дешифрование файла методом статистического анализа";

    private static ICryptoanizerCaesarConsole cryptoanizerCaesarConsole = new CryptoanizerCaesarConsole();
    private static ICryptoanizerCaesarGUI cryptoanizerCaesarGUI = new CryptoanizerCaesarGUI();

    public static void main(String[] args) {
//        CryptoanizerCaesarConsole cryptC = new CryptoanizerCaesarConsole();
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
            cryptoanizerCaesarConsole.readFileToSourceTxt(file);
            cryptoanizerCaesarConsole.saveEncodeTxtToFile(cryptoanizerCaesarConsole.getSourceTxt());
        } else if (progKey.equals("-e")) {
            if (args.length != 3) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            int encryptKey = Integer.parseInt(args[1]);
            if (encryptKey >= cryptoanizerCaesarConsole.getAlphabet().length()) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String file = args[2];
            cryptoanizerCaesarConsole.readFileToSourceTxt(file);
            cryptoanizerCaesarConsole.encryptTxt(encryptKey);
            cryptoanizerCaesarConsole.saveEncodeTxtToFile(cryptoanizerCaesarConsole.getEncodeTxt());
        } else if (progKey.equals("-d")) {
            if (args.length != 3) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            int encryptKey = Integer.parseInt(args[1]);
            if (encryptKey >= cryptoanizerCaesarConsole.getAlphabet().length()) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String file = args[2];
            cryptoanizerCaesarConsole.readFileToSourceTxt(file);
            cryptoanizerCaesarConsole.encryptTxt(-Math.abs(encryptKey));
            cryptoanizerCaesarConsole.saveEncodeTxtToFile(cryptoanizerCaesarConsole.getEncodeTxt());
        } else if (progKey.equals("-b")) {
            if (args.length != 2) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String file = args[1];
            cryptoanizerCaesarConsole.readFileToSourceTxt(file);
            int key = cryptoanizerCaesarConsole.bruteForceSourceTxt(cryptoanizerCaesarConsole.getSourceTxt());
            cryptoanizerCaesarConsole.encryptTxt(key);
            cryptoanizerCaesarConsole.saveEncodeTxtToFile(cryptoanizerCaesarConsole.getEncodeTxt());
        } else if (progKey.equals("-s")) {
            if (args.length != 3) {
                System.err.println(errorMessage);
                System.exit(1);
            }
            String cryptFile = args[1];
            String planeFile = args[2];
            cryptoanizerCaesarConsole.readFileToSourceTxt(cryptFile);
            cryptoanizerCaesarConsole.setEncodeTxt(cryptoanizerCaesarConsole.getSourceTxt());
            cryptoanizerCaesarConsole.readFileToSourceTxt(planeFile);
            cryptoanizerCaesarConsole.setReferenceTxt(cryptoanizerCaesarConsole.getSourceTxt());
            int key = cryptoanizerCaesarConsole.statAnalizSourceTxtByReferenceTxt(cryptoanizerCaesarConsole.getEncodeTxt(), cryptoanizerCaesarConsole.getReferenceTxt());
            cryptoanizerCaesarConsole.encryptTxt(-key);
            cryptoanizerCaesarConsole.saveEncodeTxtToFile(cryptoanizerCaesarConsole.getEncodeTxt());
        } else if (progKey.equals("-g")) {
            cryptoanizerCaesarGUI.mainWindow();
        } else if (progKey.equals("-help")) {
            System.out.println(helpMessage);
        } else {
            System.out.println(helpMessage);
        }
    }
}
