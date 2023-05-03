import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel {
    int colNumber;
    int rowNumber;
    JButton[][] arr;
    SimulationPanel( int rows,int cols,DataGenerator ExampleData) {
        this.colNumber = cols;
        this.rowNumber = rows;
        this.setPreferredSize(new Dimension(1500, 800));
        this.setLayout(new GridLayout(rowNumber, colNumber,2,2));

        this.arr = new JButton[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arr[i][j] = new JButton(Integer.toString(ExampleData.arr[i][j]));
                arr[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                arr[i][j].setBackground(Color.LIGHT_GRAY);
                arr[i][j].setFocusable(false);
                arr[i][j].setFont(new Font("Consolas",Font.BOLD,14));
                arr[i][j].setVisible(true);
                this.add(arr[i][j]);
            }
        }
        this.setVisible(true);
    }

    SimulationPanel(int rows, int cols) {
        this.colNumber = cols;
        this.rowNumber = rows;
        this.setPreferredSize(new Dimension(1500, 800));
        /*this.setBackground(Color.RED);
        this.setLayout(new GridLayout(rowNumber, colNumber));

        this.arr = new JButton[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arr[i][j] = new JButton(" ");
                arr[i][j].setVisible(true);
                this.add(arr[i][j]);
            }
        }*/
        this.setVisible(true);
    }
    }

