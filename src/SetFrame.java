import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetFrame extends JFrame implements ActionListener {
    private configPanel configPanel;
    private JMenuBar menuPanel;
    private JPanel simulationPanel;

    public configPanel getConfigPanel() {
        return configPanel;
    }

    public JMenuBar getMenuPanel() {
        return menuPanel;
    }

    public JPanel getSimulationPanel() {
        return simulationPanel;
    }

    public JButton startButton;
    public JButton generateButton;

    SetFrame(){
        this.setTitle("Set cover problem");                       // set title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // exit if X-window pressed
        this.setSize(1920,1080);                       // 16:9 size 1600x900 pix
        this.setLayout(new BorderLayout());                       // using layout manager

        configPanel = new configPanel();
        this.add(configPanel,BorderLayout.WEST);                  // left aligned

        /*simulationPanel = new JPanel();                           // creating right panel
        simulationPanel.setPreferredSize(new Dimension(1200,800)); //size 1200x800px
        simulationPanel.setBackground(Color.RED);                  // red bgcolor
        this.add(simulationPanel,BorderLayout.EAST);              // right aligned
*/
        simulationPanel = new SimulationPanel(15,10);
        this.add(simulationPanel,BorderLayout.EAST);

        menuPanel = new JMenuBar();                               // creating menuBar
        JMenu fileMenu = new JMenu("File");                    // adding File option
        JMenu saveMenu = new JMenu("Save");                    // adding Save option
        menuPanel.add(fileMenu);                                  // adding options to panel
        menuPanel.add(saveMenu);
        this.setJMenuBar(menuPanel);                              // setting menu top

        this.startButton = this.configPanel.getStartButton();
        this.generateButton = this.configPanel.getGenerateButton();
        generateButton.addActionListener(this);

        startButton.addActionListener(this);
        this.setVisible(true);                                    //makes window visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==generateButton){
            if(Integer.parseInt(configPanel.getRowNumber().getText())<=0 || Integer.parseInt(configPanel.getColNumber().getText())<=0){
                JOptionPane.showMessageDialog(null,"Wrong value given!","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                DataGenerator newData = new DataGenerator(Integer.parseInt(configPanel.getRowNumber().getText()),Integer.parseInt(configPanel.getColNumber().getText()));
                configPanel.getPreviewLabel().setText("<html>"+newData.getData().replaceAll("\n","<br/>")+"</html>");
                this.remove(simulationPanel);
                simulationPanel=new SimulationPanel(Integer.parseInt(configPanel.getRowNumber().getText()),Integer.parseInt(configPanel.getColNumber().getText()));
                this.add(simulationPanel,BorderLayout.EAST);
                JOptionPane.showMessageDialog(null,"Example data generated!","Succes",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(e.getSource()==startButton){
            System.out.println("START");
        }
    }
}
