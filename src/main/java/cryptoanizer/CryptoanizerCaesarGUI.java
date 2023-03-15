package cryptoanizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Component.*;

public class CryptoanizerCaesarGUI implements ICryptoanizerCaesarGUI{
    private static ICryptoanizerCaesarConsole iccConsole;

    CryptoanizerCaesarGUI(ICryptoanizerCaesarConsole iccConsole) {
        this.iccConsole = iccConsole;
    }

    private JFrame window;
    private JButton encrypt;
    private JButton decrypt;
    private JButton bruteforce;
    private JButton statanalysis;
    private JButton reset;
    private JPanel textPanel;
    private JTextArea textAreaIn;
    private JTextArea textAreaOut;
    private JLabel fileLabel;
    private JButton fileLabelButton;
    private JLabel keyLabel;
    private JTextField keyField;
    private JLabel referenceLabel;
    private JButton referenceLabelButton;
    private String filePath;
    private String referencePath;
    private JFrame alert;
    private JPanel gridPanel;
    private Image image = Toolkit.getDefaultToolkit().getImage("Caesar.jpg");

    public static void main(String[] args) {
        CryptoanizerCaesarGUI ccg = new CryptoanizerCaesarGUI(iccConsole);
        ccg.mainWindow();
    }

    public void mainWindow() {
        window = new JFrame("Caesar");
        window.setIconImage(image);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//        mainPanel.setAlignmentX(LEFT_ALIGNMENT);

        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
//        toolPanel.setAlignmentX(LEFT_ALIGNMENT);
        JToolBar tb = new JToolBar();
        tb.setFloatable(false);
        tb.setAlignmentX(LEFT_ALIGNMENT);

        tb.add(makeButton("Encrypt", new EncryptButtonPress(this, iccConsole)));
        tb.add(makeButton("Decrypt", new DecryptButtonPress(this, iccConsole)));
        tb.add(makeButton("Bruteforce", new BruteforceButtonPress(this, iccConsole)));
        tb.add(makeButton("Statanalysis", new StatButtonPress(this, iccConsole)));
        tb.add(makeButton("Reset", new ResetButtonPress(this, iccConsole)));

        toolPanel.add(tb);
        toolPanel.add(Box.createVerticalStrut(5));

        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));

        textAreaIn = new JTextArea(20, 40);
        configureTextArea(textAreaIn);

        textAreaOut = new JTextArea(20, 40);
        configureTextArea(textAreaOut);

        fileLabel = new JLabel("Select a file for processing.");
        fileLabel.setPreferredSize(new Dimension(227, fileLabel.getPreferredSize().height));

        fileLabelButton = new JButton("...");
        fileLabelButton.addActionListener(new SourceFileSelect(this, iccConsole));

        keyLabel = new JLabel("Set key.");
        keyLabel.setPreferredSize(new Dimension(227, fileLabel.getPreferredSize().height));

        keyField = new JTextField(2);
        keyField.setMaximumSize(new Dimension(20, 20));

        referenceLabel = new JLabel("Select the file for the sample.");
        referenceLabel.setPreferredSize(new Dimension(227, fileLabel.getPreferredSize().height));

        referenceLabelButton = new JButton("...");
        referenceLabelButton.addActionListener(new ReferenceFileSelect(this, iccConsole));

        gridPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        gridPanel.setAlignmentX(LEFT_ALIGNMENT);

        addGridPanel(fileLabel);
        addGridPanel(fileLabelButton);
        addGridPanel(keyLabel);
        addGridPanel(keyField);
        addGridPanel(referenceLabel);
        addGridPanel(referenceLabelButton);

        gridPanel.setMaximumSize(new Dimension(gridPanel.getPreferredSize()));

        mainPanel.add(toolPanel);
        mainPanel.add(textPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(gridPanel);
        mainPanel.add(Box.createVerticalStrut(5));

        window.add(mainPanel);
        window.pack();
        window.setVisible(true);
    }

    public void setFileLabel(String filename) {
        fileLabel.setText(filename);
    }

    public void setTextAreaIn(String text) {
        textAreaIn.setText(text);
    }

    public void setTextAreaOut(String text) {
        textAreaOut.setText(text);
    }

    public void setReferenceLabel(String reference) {
        referenceLabel.setText(reference);
    }

    public String getKeyValue() {
        return keyField.getText();
    }

    public void setFilePath(String path) {
        filePath = path;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setReferencePath(String path) {
        referencePath = path;
    }

    public String getReferencePath() {
        return referencePath;
    }

    public JFrame getAlert() {
        return alert;
    }

    public void setKeyField(String text) {
        keyField.setText(text);
    }

    public void setKeyLabel(String text) {
        keyLabel.setText(text);
    }

    private JButton makeButton(String name, ActionListener action) {
        JButton button = new JButton(name);
        button.addActionListener(action);
        return button;
    }

    private void addGridPanel(JComponent component) {
        JPanel panel = new JPanel();//new FlowLayout(FlowLayout.LEFT));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(component);//, BorderLayout.SOUTH);
        panel.add(Box.createHorizontalGlue());
        gridPanel.add(panel);
    }

    public void alertDialog(String alert) {
        JOptionPane.showMessageDialog(window, alert);
    }

    private void configureTextArea(JTextArea textArea) {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
//        textAreaOut.setAlignmentX(LEFT_ALIGNMENT);
        textPanel.add(new JScrollPane(textArea));
    }
}