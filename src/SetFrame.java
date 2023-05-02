import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;

public class SetFrame extends JFrame {
    configPanel configPanel;
    JMenuBar menuPanel;
    JPanel simulationPanel;
    SetFrame(){
        this.setTitle("Set cover problem");                       // set title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // exit if X-window pressed
        this.setSize(1600,900);                       // 16:9 size 1600x900 pix
        this.setLayout(new BorderLayout());                       // using layout manager

        configPanel = new configPanel();
        this.add(configPanel,BorderLayout.WEST);                  // left aligned

        simulationPanel = new JPanel();                           // creating right panel
        simulationPanel.setPreferredSize(new Dimension(1200,800)); //size 1200x800px
        simulationPanel.setBackground(Color.RED);                  // red bgcolor
        this.add(simulationPanel,BorderLayout.EAST);              // right aligned

        menuPanel = new JMenuBar();                               // creating menuBar
        JMenu fileMenu = new JMenu("File");                    // adding File option
        JMenu saveMenu = new JMenu("Save");                    // adding Save option
        menuPanel.add(fileMenu);                                  // adding options to panel
        menuPanel.add(saveMenu);
        this.setJMenuBar(menuPanel);                              // setting menu top

        this.setVisible(true);                                    //makes window visible
    }
}
