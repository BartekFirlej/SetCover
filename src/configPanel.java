import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class configPanel extends JPanel {
    private JComboBox modeChoose;
    private JLabel previewLabel;
    private JButton startButton;
    private JButton generateButton;
    private JLabel summaryLabel;
    private JTextField rowNumber;
    private JTextField colNumber;
    public int getMode(){
        return this.modeChoose.getSelectedIndex();
    }

    public JComboBox getModeChoose() {
        return modeChoose;
    }

    public JLabel getPreviewLabel() {
        return previewLabel;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JLabel getSummaryLabel() {
        return summaryLabel;
    }
    public JTextField getRowNumber() {
        return rowNumber;
    }
    public JTextField getColNumber() {
        return colNumber;
    }

    configPanel(){
        this.setPreferredSize(new Dimension(400,900));  // setting size to 400x800px
        this.setBackground(Color.BLUE);                    // blue bgcolor
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));   // border layout inside config panel
        String[] algorithms = {"GREEDY","BRUTE-FORCE"};    // strings for ComboBox
        modeChoose = new JComboBox(algorithms);             // creating combo-box to choose algorithm mode

        //CHOSE ALGO SECTION
        JPanel modePanel = new JPanel();                              // top panel of config panel
        JLabel algDescription = new JLabel("Choose algorithm:"); // Label next to combobox
        modePanel.setBackground(new Color(173,216,230,220));                  // light-blue bgcolor
        modePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));          // border of section
        algDescription.setFont(new Font("Helvetica",Font.PLAIN,18));            //font of text
        modeChoose.setFont(new Font("Helvetica",Font.BOLD,18));            // font of mode picker
        modePanel.add(algDescription);                             // adding items to subpanel
        modePanel.add(modeChoose);                           // adding items to subpanel
        this.add(modePanel);                                // adding panel to frame

        // GENERATE DATA SECTION
        JLabel dataDescription = new JLabel("Give problem size:"); // Label next to combobox
        dataDescription.setFont(new Font("Helvetica",Font.PLAIN,18));            //font of text
        JPanel dataPanel = new JPanel();                                               //creates 2nd panel with data
        dataPanel.setLayout(null);                                                    // inside of this panel i put items manually
        dataPanel.setBackground(new Color(173,216,230,220));                  // light blue bgcolor
        dataPanel.setPreferredSize(new Dimension(400,130));                  //size of panel
        dataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));      //border of panel
        rowNumber = new JTextField();                                                   //textfield for rows number
        rowNumber.setFont(new Font("Consolas",Font.PLAIN,18));               // font type for textfield
        rowNumber.setText("Number of cities");                                        // "placeholder"
        rowNumber.setBounds(100,20,200,30);                          // size and place of textfield
        rowNumber.setHorizontalAlignment(JTextField.CENTER);                             // center text in textfield
        colNumber = new JTextField();                                               //textfield for cols number
        colNumber.setFont(new Font("Consolas",Font.PLAIN,18));                // font type
        colNumber.setText("Number of places");                                       //"placeholder"
        colNumber.setBounds(100,70,200,30);                         // size and place
        colNumber.setHorizontalAlignment(JTextField.CENTER);                          // center text in textfields
        generateButton = new JButton();                                               // Generate button
        generateButton.setText("GENERATE");                                           // Text in button
        generateButton.setBounds(120,120,150,40);                  // size and place of button
        generateButton.setFont(new Font("Helvetica",Font.BOLD,18));        // font in button
        generateButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));  // border of button
        generateButton.setBackground(Color.LIGHT_GRAY);                                  // bgcolor of BUTTON
        generateButton.setFocusable(false);                                              // removes frame from string inside button
        dataPanel.add(dataDescription);                                             //adding items to panel
        dataPanel.add(rowNumber);
        dataPanel.add(colNumber);
        dataPanel.add(generateButton);
        this.add(dataPanel);                                                        // adding panel to the frame

        // MIDDLE - PREVIEW
        JPanel previewPanel= new JPanel();                                      //creating panel
        previewLabel = new JLabel();                               // label with text to show task
        JPanel previewLabelPanel = new JPanel();                                 // panel for label to make static size
        previewLabelPanel.setPreferredSize(new Dimension(390, 350));
        previewLabelPanel.setBackground(Color.WHITE);
        previewLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,false));
        previewLabelPanel.add(previewLabel);
        JLabel prevDescription = new JLabel("Task preview:");            // title label
        prevDescription.setFont(new Font("Helvetica",Font.BOLD,18));  //font for title
        previewPanel.setBackground(new Color(173,216,230,220));   //bbackground color
        previewPanel.setPreferredSize(new Dimension(400,360));    //size
        previewPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1)); // border for middle section
        previewPanel.add(prevDescription);                                    // adding text labels
        previewPanel.add(previewLabelPanel);
        this.add(previewPanel);                                         // adding middle section to frame

        // BOTTOM SECTION
        JPanel summaryPanel = new JPanel();                                   // summary - bottom panel
        summaryPanel.setBackground(new Color(173,216,230,220));       // bgcolor
        summaryPanel.setPreferredSize(new Dimension(400,330));        //size
        summaryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));      //border of panel
        // Button
        startButton = new JButton();                                        // creating start button
        startButton.setPreferredSize(new Dimension(150,40));            // size of start button
        startButton.setText("START");                                        // text inside of button
        startButton.setFont(new Font("Helvetica",Font.BOLD,18));        // font in button
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));  // border of button
        startButton.setBackground(Color.LIGHT_GRAY);                                  // bgcolor of BUTTON
        startButton.setFocusable(false);
        // Label with score
        summaryLabel = new JLabel("1010101010");                             // label for summary text
        JPanel summaryLabelPanel = new JPanel();                                      // panel to make size of summary label
        summaryLabelPanel.setPreferredSize(new Dimension(390, 306));        // size
        summaryLabelPanel.setBackground(Color.WHITE);                                  // bgcolor
        summaryLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3,false));      //border
        summaryLabelPanel.add(summaryLabel);                                              // adding label to panel
        summaryPanel.add(startButton);                      // adding border and subpanel to panel
        summaryPanel.add(summaryLabelPanel);
        this.add(summaryPanel);                      // adding panel to frame

        this.setVisible(true);                             // setting visibility of configPanel
    }


}
