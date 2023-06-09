import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetFrame extends JFrame implements ActionListener {
    private configPanel configPanel;
    private JMenuBar menuPanel;
    private SimulationPanel simulationPanel;
    private JButton startButton;
    private JButton generateButton;
    private DataGenerator problemData;


    SetFrame(){
        this.setTitle("Set cover problem");                       // set title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // exit if X-window pressed
        this.setSize(1920,1080);                       // 16:9 size 1600x900 pix
        this.setLayout(new BorderLayout());                       // using layout manager

        configPanel = new configPanel();
        this.add(configPanel,BorderLayout.WEST);                  // left aligned

        simulationPanel = new SimulationPanel(15,10);
        this.add(simulationPanel,BorderLayout.EAST);

        menuPanel = new JMenuBar();                               // creating menuBar
        JMenu fileMenu = new JMenu("File");                    // adding File option
        JMenu saveMenu = new JMenu("Save");                    // adding Save option
        menuPanel.add(fileMenu);                                  // adding options to panel
        menuPanel.add(saveMenu);
        this.setJMenuBar(menuPanel);                              // setting menu top

        this.startButton = this.configPanel.getStartButton();        // adding reference to start button to make it clickable
        this.generateButton = this.configPanel.getGenerateButton();  // adding reference to generate button to make it clickable
        generateButton.addActionListener(this);                  //adds event on click on both buttons
        startButton.addActionListener(this);

        this.setVisible(true);                                    //makes window visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==generateButton){
            if(Integer.parseInt(configPanel.getRowNumber().getText())<=0 || Integer.parseInt(configPanel.getColNumber().getText())<=0){
                JOptionPane.showMessageDialog(null,"Wrong value given!","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                this.problemData = new DataGenerator(Integer.parseInt(configPanel.getRowNumber().getText()),Integer.parseInt(configPanel.getColNumber().getText()));
                configPanel.getPreviewLabel().setText("<html>"+this.problemData.getData().replaceAll("\n","<br/>")+"</html>");
                this.remove(simulationPanel);
                simulationPanel=new SimulationPanel(Integer.parseInt(configPanel.getRowNumber().getText()),Integer.parseInt(configPanel.getColNumber().getText()),this.problemData);
                this.add(simulationPanel,BorderLayout.EAST);
                JOptionPane.showMessageDialog(null,"Example data generated!","Succes",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(e.getSource()==startButton){
            if(this.configPanel.getMode()==0){
                GreedyAlg greedySolution = new GreedyAlg(this.problemData);
                this.simulationPanel.paintSolution(greedySolution.getSolution());
                JOptionPane.showMessageDialog(null,"Problem solved gentle!","Succes",JOptionPane.INFORMATION_MESSAGE);
            }else{
                BruteForce bruteSolution = new BruteForce(this.problemData);
                this.simulationPanel.paintSolution(bruteSolution.getProblemSolution());
                JOptionPane.showMessageDialog(null,"Problem solved brutally!","Succes",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}
