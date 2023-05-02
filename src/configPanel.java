import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class configPanel extends JPanel implements ActionListener {
    JComboBox modeChoose;
    JLabel previewLabel;
    JButton startButton;
    JButton generateButton;
    JLabel summaryLabel;
    JTextField rowNumber;
    JTextField colNumber;
    configPanel(){
        this.setPreferredSize(new Dimension(400,800));  // setting size to 400x800px
        this.setBackground(Color.BLUE);                    // blue bgcolor
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));   // border layout inside config panel

        String[] algorithms = {"Greedy","Brute-force"};    // strings for ComboBox
        modeChoose = new JComboBox(algorithms);             // creating combo-box to choose algorithm mode

        //CHOSE ALGO SECTION
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JLabel algDescription = new JLabel("Choose algorithm:"); // Label next to combobox
        JPanel modePanel = new JPanel();
        modePanel.setBackground(Color.ORANGE);                  // orange bgcolor
        modePanel.add(algDescription);                             // adding items to subpanel
        modePanel.add(modeChoose);                           // adding items to subpanel
        this.add(modePanel);

        // GENERATE DATA SECTION
        JLabel dataDescription = new JLabel("Give problem size:"); // Label next to combobox
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null);
        dataPanel.setBackground(Color.BLUE);                  // orange bgcolor
        dataPanel.setPreferredSize(new Dimension(400,200));
        rowNumber = new JTextField();
        rowNumber.setFont(new Font("Consolas",Font.PLAIN,14));
        rowNumber.setText("Number of cities");
        rowNumber.setBounds(100,20,200,30);
        rowNumber.setHorizontalAlignment(JTextField.CENTER);
        colNumber = new JTextField();
        colNumber.setFont(new Font("Consolas",Font.PLAIN,14));
        colNumber.setText("Number of places");
        colNumber.setBounds(100,70,200,30);
        colNumber.setHorizontalAlignment(JTextField.CENTER);
        generateButton = new JButton();
        generateButton.setText("GENERATE");
        generateButton.setBounds(150,140,100,20);
        dataPanel.add(dataDescription);
        dataPanel.add(rowNumber);
        dataPanel.add(colNumber);
        dataPanel.add(generateButton);
        this.add(dataPanel);

        // MIDDLE SECTION
        previewLabel = new JLabel("ZADANIE");
        JPanel previewLabelPanel = new JPanel();
        previewLabelPanel.setPreferredSize(new Dimension(390, 200));
        previewLabelPanel.setBackground(Color.WHITE);
        previewLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,false));
        previewLabelPanel.add(previewLabel);
        JLabel prevDescription = new JLabel("Opis zadania:");
        JPanel previewPanel= new JPanel();
        previewPanel.setBackground(Color.PINK);
        previewPanel.setPreferredSize(new Dimension(400,300));
        previewPanel.add(prevDescription);
        previewPanel.add(previewLabelPanel);
        this.add(previewPanel);

        // BOTTOM SECTION
        // Button
        startButton = new JButton();
        startButton.setSize(new Dimension(100,50));
        startButton.setText("START");
        // Label with score
        summaryLabel = new JLabel("1010101010");
        JPanel summaryLabelPanel = new JPanel();
        summaryLabelPanel.setPreferredSize(new Dimension(390, 200));
        summaryLabelPanel.setBackground(Color.WHITE);
        summaryLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,false));
        summaryLabelPanel.add(summaryLabel);
        // Creating and adding items to bottom panel
        JPanel summaryPanel = new JPanel();
        summaryPanel.setBackground(Color.YELLOW);
        summaryPanel.setPreferredSize(new Dimension(400,300));
        summaryPanel.add(startButton);
        summaryPanel.add(summaryLabelPanel);
        this.add(summaryPanel);

        this.setVisible(true);                             // setting visibility of configPanel
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
