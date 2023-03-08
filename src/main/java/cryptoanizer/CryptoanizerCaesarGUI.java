package cryptoanizer;

import javax.swing.*;
import java.awt.*;

public class CryptoanizerCaesarGUI implements ICryptoanizerCaesarGUI{
    public JButton encrypt;
    public JButton decrypt;
    public JButton bruteforce;
    public JButton statanalysis;
    public JButton help;
    public JTextArea textArea;
    public JLabel fileLabel;
    public JButton fileLabelButton;
    public JLabel keyLabel;
    public JTextField keyField;
    public JLabel referenceLabel;
    public JButton referenceLabelButton;
    public ICryptoanizerCaesarGUI ccg = new CryptoanizerCaesarGUI();

    public static void main(String[] args) {
//        CryptoanizerCaesarGUI ccg = new CryptoanizerCaesarGUI();
//        ccg.mainWindow();
    }

    public void mainWindow() {
        JFrame window = new JFrame("Caesar");
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
        JToolBar tb = new JToolBar();
        tb.setFloatable(false);
        tb.setAlignmentX(Component.LEFT_ALIGNMENT);

        encrypt = new JButton();
        encrypt.setText("Encrypt");
        decrypt = new JButton();
        decrypt.setText("Decrypt");
        bruteforce = new JButton();
        bruteforce.setText("Bruteforce");
        statanalysis = new JButton();
        statanalysis.setText("Statanalysis");
        help = new JButton();
        help.setText("Help");

        tb.add(encrypt);
        tb.add(decrypt);
        tb.add(bruteforce);
        tb.add(statanalysis);
        tb.add(help);

        toolPanel.add(tb);
        toolPanel.add(Box.createVerticalStrut(5));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textArea = new JTextArea(20, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        toolPanel.add(new JScrollPane(textArea));

        JPanel filePanel = new JPanel(new FlowLayout( FlowLayout.LEFT ));
//        filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.X_AXIS));

        filePanel.add(Box.createHorizontalStrut(10));
        fileLabel = new JLabel("Выберите файл для обработки.");

        filePanel.add(fileLabel);
        filePanel.add(Box.createHorizontalStrut(10));

        fileLabelButton = new JButton("...");
        fileLabelButton.addActionListener(new FileSelect(ccg));
        filePanel.add(fileLabelButton);

        JPanel keyPanel = new JPanel(new FlowLayout( FlowLayout.LEFT ));

        keyPanel.add(Box.createHorizontalStrut(10));
        keyLabel = new JLabel("Введите ключ.");
        keyLabel.setPreferredSize(fileLabel.getPreferredSize());
        keyPanel.add(keyLabel);
        keyPanel.add(Box.createHorizontalStrut(10));

        keyField = new JTextField(2);
        keyPanel.add(keyField);

        JPanel referencePanel = new JPanel(new FlowLayout( FlowLayout.LEFT ));

        referencePanel.add(Box.createHorizontalStrut(10));
        referenceLabel = new JLabel("Выберите файл для образца.");
        referenceLabel.setPreferredSize(fileLabel.getPreferredSize());
        referencePanel.add(referenceLabel);
        referencePanel.add(Box.createHorizontalStrut(10));

        referenceLabelButton = new JButton("...");
        referencePanel.add(referenceLabelButton);

        mainPanel.add(toolPanel);
        mainPanel.add(filePanel);
        mainPanel.add(keyPanel);
        mainPanel.add(referencePanel);

        window.add(mainPanel);
        window.pack();
        window.setVisible(true);
    }

    @Override
    public void setFileName(String filename) {

        fileLabel.setText(filename);
    }
}