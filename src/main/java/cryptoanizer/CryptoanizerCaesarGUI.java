package cryptoanizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Component.*;

public class CryptoanizerCaesarGUI implements ICryptoanizerCaesarGUI{

    private JFrame window;
    private JButton encrypt;
    private JButton decrypt;
    private JButton bruteforce;
    private JButton statanalysis;
    private JButton reset;
    private JTextArea textArea;
    private JLabel fileLabel;
    private JButton fileLabelButton;
    private JLabel keyLabel;
    private JTextField keyField;
    private JLabel referenceLabel;
    private JButton referenceLabelButton;
//    private String loadedTxt;
//    private String referenceTxt;
    private String filePath;
    private String referencePath;
    private JFrame alert;
    private JPanel gridPanel;
    private Image image = Toolkit.getDefaultToolkit().getImage("Caesar.jpg");

    public static void main(String[] args) {
        CryptoanizerCaesarGUI ccg = new CryptoanizerCaesarGUI();
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

        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
        JToolBar tb = new JToolBar();
        tb.setFloatable(false);
        tb.setAlignmentX(LEFT_ALIGNMENT);

//        encrypt = new JButton("Encrypt");
//        encrypt.addActionListener(new EncryptButtonPress(this));
//        decrypt = new JButton("Decrypt");
//        decrypt.addActionListener(new DecryptButtonPress(this));
//        bruteforce = new JButton("Bruteforce");
//        bruteforce.addActionListener(new BruteforceButtonPress(this));
//        statanalysis = new JButton("Statanalysis");
//        statanalysis.addActionListener(new StatButtonPress(this));
//        reset = new JButton("Reset");
//        reset.addActionListener(new ResetButtonPress(this));

        tb.add(makeButton("Encrypt", new EncryptButtonPress(this)));
        tb.add(makeButton("Decrypt", new DecryptButtonPress(this)));
        tb.add(makeButton("Bruteforce", new BruteforceButtonPress(this)));
        tb.add(makeButton("Statanalysis", new StatButtonPress(this)));
        tb.add(makeButton("Reset", new ResetButtonPress(this)));

        toolPanel.add(tb);
        toolPanel.add(Box.createVerticalStrut(5));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textArea = new JTextArea(20, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(LEFT_ALIGNMENT);
        toolPanel.add(new JScrollPane(textArea));

//        JPanel filePanel = new JPanel();
//        filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.X_AXIS));

//        filePanel.add(Box.createHorizontalStrut(10));
        fileLabel = new JLabel("Select a file for processing.");
        fileLabel.setPreferredSize(new Dimension(227, fileLabel.getPreferredSize().height));

//        filePanel.add(fileLabel);
//        filePanel.add(Box.createHorizontalStrut(10));

        fileLabelButton = new JButton("...");
        fileLabelButton.addActionListener(new FileSelect(this));
//        filePanel.add(fileLabelButton);
//        filePanel.add(Box.createHorizontalGlue());

////        fileLabelButton.setPreferredSize(new Dimension(20, 20));

//        JPanel keyPanel = new JPanel();
//        keyPanel.setLayout(new BoxLayout(keyPanel, BoxLayout.X_AXIS));
//
//        keyPanel.add(Box.createHorizontalStrut(10));
        keyLabel = new JLabel("Set key.");
        keyLabel.setPreferredSize(new Dimension(227, fileLabel.getPreferredSize().height));
//        keyPanel.add(keyLabel);
//        keyPanel.add(Box.createHorizontalStrut(10));

        keyField = new JTextField(2);
        keyField.setMaximumSize(new Dimension(20, 20));
//        keyPanel.add(keyField);
//        keyPanel.add(Box.createHorizontalGlue());

//        JPanel referencePanel = new JPanel();
//        referencePanel.setLayout(new BoxLayout(referencePanel, BoxLayout.X_AXIS));
//
//        referencePanel.add(Box.createHorizontalStrut(10));
        referenceLabel = new JLabel("Select the file for the sample.");
        referenceLabel.setPreferredSize(new Dimension(227, fileLabel.getPreferredSize().height));
//        referencePanel.add(referenceLabel);
//        referencePanel.add(Box.createHorizontalStrut(10));

        referenceLabelButton = new JButton("...");
        referenceLabelButton.addActionListener(new ReferenceSelect(this));
//        referencePanel.add(referenceLabelButton);
//        referencePanel.add(Box.createHorizontalGlue());


        gridPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        gridPanel.setAlignmentX(LEFT_ALIGNMENT);

//        JPanel fileLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        fileLabelPanel.add(fileLabel);
//        gridPanel.add(fileLabelPanel);
//
//        JPanel fileLabelButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        fileLabelButtonPanel.add(fileLabelButton);
//        gridPanel.add(fileLabelButtonPanel);
//
//        JPanel keyLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        keyLabelPanel.add(keyLabel);
//        gridPanel.add(keyLabelPanel);
//
//        JPanel keyFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        keyFieldPanel.add(keyField);
//        gridPanel.add(keyFieldPanel);
//
//        JPanel referenceLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        referenceLabelPanel.add(referenceLabel);
//        gridPanel.add(referenceLabelPanel);
//
//        JPanel referenceLabelButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        referenceLabelButtonPanel.add(referenceLabelButton);
//        gridPanel.add(referenceLabelButtonPanel);

        addGridPanel(fileLabel);
        addGridPanel(fileLabelButton);
        addGridPanel(keyLabel);
        addGridPanel(keyField);
        addGridPanel(referenceLabel);
        addGridPanel(referenceLabelButton);


        gridPanel.setMaximumSize(new Dimension(gridPanel.getPreferredSize()));


//        gridPanel.add(fileLabel, makeConstraints(0, 0, 1, 4));
//        gridPanel.add(fileLabelButton, makeConstraints(5, 0, 1, 1));
//        gridPanel.add(keyLabel, makeConstraints(0, 2, 1, 4));
//        gridPanel.add(keyField, makeConstraints(5, 2, 1, 1));
//        gridPanel.add(referenceLabel, makeConstraints(0, 4, 1, 4));
//        gridPanel.add(referenceLabelButton, makeConstraints(5, 4, 1, 1));

        //JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //flowPanel.add(gridPanel);



//        JPanel bottomPanel = new JPanel();
//        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
////        System.out.println(bottomPanel.getMinimumSize().height);
//        bottomPanel.add(Box.createVerticalStrut(5));
//        filePanel.setMaximumSize(new Dimension(filePanel.getMaximumSize().width, 30));
//        bottomPanel.add(filePanel);
//        bottomPanel.add(Box.createVerticalStrut(5));
//        keyPanel.setMaximumSize(new Dimension(keyPanel.getMaximumSize().width, 30));
//        bottomPanel.add(keyPanel);
//        bottomPanel.add(Box.createVerticalStrut(5));
//        referencePanel.setMaximumSize(new Dimension(referencePanel.getMaximumSize().width, 30));
//        bottomPanel.add(referencePanel);
//        bottomPanel.add(Box.createVerticalStrut(5));

        mainPanel.add(toolPanel);
//        mainPanel.add(bottomPanel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(gridPanel);
        mainPanel.add(Box.createVerticalStrut(5));

        window.add(mainPanel);
        window.pack();
        window.setVisible(true);
    }

//    public void alertWindow() {
//        alert = new JFrame("Wrong key.");
//        alert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        alert.setSize(300, 200);
//        alert.setLocationRelativeTo(null);
//        JPanel alertPanel = new JPanel();
//        alertPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
//        alertPanel.setAlignmentX(CENTER_ALIGNMENT);
//        alertPanel.setLayout(new BoxLayout(alertPanel, BoxLayout.Y_AXIS));
//        alertPanel.add(Box.createVerticalStrut(10));
//        JLabel alertLabel1 = new JLabel("The key can be");
//        alertLabel1.setAlignmentX(CENTER_ALIGNMENT);
//        JLabel alertLabel2 = new JLabel("a whole positive number");
//        alertLabel2.setAlignmentX(CENTER_ALIGNMENT);
//        JLabel alertLabel3 = new JLabel("from 1 to 40.");
//        alertLabel3.setAlignmentX(CENTER_ALIGNMENT);
//        JButton alertButton = new JButton("Close");
//        alertButton.setAlignmentX(CENTER_ALIGNMENT);
//        alertButton.addActionListener(new AlertClose(this));
//
//        JPanel horizPanel = new JPanel();
//        horizPanel.setLayout(new BoxLayout(horizPanel, BoxLayout.X_AXIS));
//        alertPanel.add(alertLabel1);
//        alertPanel.add(Box.createVerticalStrut(3));
//        alertPanel.add(alertLabel2);
//        alertPanel.add(Box.createVerticalStrut(3));
//        alertPanel.add(alertLabel3);
//        alertPanel.add(Box.createVerticalStrut(10));
//        alertPanel.add(alertButton);
////        alertPanel.add(Box.createVerticalStrut(10));
//
//        horizPanel.add(alertPanel);
//        alert.add(horizPanel);
////        alert.pack();
//        alert.setVisible(true);
//    }

    public void setFileLabel(String filename) {
        fileLabel.setText(filename);
    }

    public void setTextArea(String text) {
        textArea.setText(text);
    }

//    public void setLoadedTxt(String txt) {
//        loadedTxt = txt;
//    }
//
//    public String getLoadedTxt() {
//        return loadedTxt;
//    }

    public void setReferenceLabel(String reference) {
        referenceLabel.setText(reference);
    }

//    public void setReferenceTxt(String txt) {
//        referenceTxt = txt;
//    }
//
//    public String getReferenceTxt() {
//        return referenceTxt;
//    }

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

//    private GridBagConstraints makeConstraints(int a, int b, int c, int d) {
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.weightx = 0;
//        constraints.weighty = 0;
//        constraints.gridx = a;
//        constraints.gridy = b;
//        constraints.gridheight = c;
//        constraints.gridwidth = d;
//        return constraints;
//    }

    private void addGridPanel(JComponent component) {
        JPanel panel = new JPanel();//new FlowLayout(FlowLayout.LEFT));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//        panel.setAlignmentY(CENTER_ALIGNMENT);
//        component.setAlignmentY(LEFT_ALIGNMENT);
        panel.add(component);//, BorderLayout.SOUTH);
        panel.add(Box.createHorizontalGlue());
        gridPanel.add(panel);
    }

    public void alertDialog() {
        JOptionPane.showMessageDialog(window, "The key can be a whole positive number from 1 to 40.");
    }
}