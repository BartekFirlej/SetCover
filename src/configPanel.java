import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class configPanel extends JPanel implements ActionListener {
    JPanel modePanel;
    JComboBox modeChoose;

    JPanel previewPanel;
    JLabel previewLabel;
    JButton startButton;
    JPanel summaryPanel;
    JLabel summaryLabel;
    configPanel(){
        this.setPreferredSize(new Dimension(400,800));  // setting size to 400x800px
        this.setBackground(Color.BLUE);                    // blue bgcolor
        this.setLayout(new BorderLayout());                // border layout inside config panel

        String[] algorithms = {"Greedy","Brute-force"};    // strings for ComboBox
        modeChoose = new JComboBox(algorithms);             // creating combo-box to choose algorithm mode

        // TOP SECTION
        JLabel algDescription = new JLabel("Wybierz algorytm:"); // Label next to combobox
        modePanel = new JPanel();
        modePanel.setBackground(Color.ORANGE);                  // orange bgcolor
        modePanel.add(algDescription);                             // adding items to subpanel
        modePanel.add(modeChoose);                           // adding items to subpanel
        this.add(modePanel,BorderLayout.NORTH);            // adding subpanel to the top of left panel

        // MIDDLE SECTION
        previewLabel = new JLabel("ZADANIE");
        JPanel previewLabelPanel = new JPanel();
        previewLabelPanel.setPreferredSize(new Dimension(390, 200));
        previewLabelPanel.setBackground(Color.WHITE);
        previewLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,false));
        previewLabelPanel.add(previewLabel);

        JLabel prevDescription = new JLabel("Opis zadania:");
        previewPanel= new JPanel();
        previewPanel.setBackground(Color.PINK);
        previewPanel.setPreferredSize(new Dimension(400,400));
        previewPanel.add(prevDescription);
        previewPanel.add(previewLabelPanel);
        this.add(previewPanel,BorderLayout.CENTER);

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
        summaryPanel = new JPanel();
        summaryPanel.setBackground(Color.YELLOW);
        summaryPanel.setPreferredSize(new Dimension(400,400));
        summaryPanel.add(startButton);
        summaryPanel.add(summaryLabelPanel);
        this.add(summaryPanel,BorderLayout.SOUTH);

        this.setVisible(true);                             // setting visibility of configPanel
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
