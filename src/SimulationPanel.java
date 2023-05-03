import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel {
    int colNumber;
    int rowNumber;
    JButton[][] arr;
    SimulationPanel(int cols, int rows) {
        this.colNumber = cols;
        this.rowNumber = rows;                                    // creating right panel
        this.setPreferredSize(new Dimension(1500, 800)); //size 1200x800px
        this.setBackground(Color.RED);                  // red bgcolor
        this.setLayout(new GridLayout(rowNumber, colNumber));

        this.arr = new JButton[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arr[i][j] = new JButton("1");
                arr[i][j].setVisible(true);
                this.add(arr[i][j]);
            }
        }
        this.setVisible(true);
    }


    }

