import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class SimulationPanel extends JPanel {
    private int colNumber;
    private int rowNumber;
    private JButton[][] arr;

    public int getColNumber() {
        return colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public JButton[][] getArr() {
        return arr;
    }

    SimulationPanel(int rows, int cols, DataGenerator ExampleData) {
        this.colNumber = cols;                                          // initiate number of rows and cols
        this.rowNumber = rows;
        this.setPreferredSize(new Dimension(1500, 800));          // set size
        this.setLayout(new GridLayout(rowNumber, colNumber,2,2));    // set grid mesh
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));     // add border to section
        this.arr = new JButton[rowNumber][colNumber];                          // initialize array of buttons
        for (int i = 0; i < rowNumber; i++) {                                  // for each row
            for (int j = 0; j < colNumber; j++) {                                // for each col
                arr[i][j] = new JButton(Integer.toString(ExampleData.arr[i][j]));     // add button to arr
                arr[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));     // set its border
                arr[i][j].setBackground(Color.LIGHT_GRAY);                            // set its bgcolor
                arr[i][j].setFocusable(false);                                      // without border after click
                arr[i][j].setFont(new Font("Consolas",Font.BOLD,14));     // font-style
                arr[i][j].setVisible(true);                                         // makes it visible
                this.add(arr[i][j]);                                                //add button to grid
            }
        }
        this.setVisible(true);                                                // set this panel visible
    }

    SimulationPanel(int rows, int cols) {
        this.colNumber = cols;
        this.rowNumber = rows;
        this.setPreferredSize(new Dimension(1500, 800));
        this.setVisible(true);
    }
    public void paintSolution(Set<Integer> problemSolution){                       // paint buttons with solution given by algo
        for(int i :problemSolution)
            for(int j=0;j<rowNumber;j++)
                this.arr[j][i].setBackground(Color.GREEN);
    }
}

