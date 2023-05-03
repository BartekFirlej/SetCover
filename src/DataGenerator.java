import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DataGenerator {
    int rows; // number of rows - cities
    int cols; // number of cols - possible places
    public int[][] arr; // array informing does city has acces via this place
    DataGenerator(int rows, int cols){       // generates data with given size and checks is correct
        this.rows=rows;
        this.cols=cols;
        this.arr=new int[rows][cols];
        this.generateData();
        this.checkData();
    }

    public int getRowsNumber() {
        return this.rows;
    }

    public int getColsNumber() {
        return this.cols;
    }

    public int[][] getArr() {
        return arr;
    }

    DataGenerator(String filePath){                      // reads frorows txt file generated data
        try{
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            this.rows=sc.nextInt();
            this.cols=sc.nextInt();
            this.arr = new int[rows][cols];
            for(int i=0;i<this.rows;i++){
                for(int j=0;j<this.cols;j++){
                    this.arr[i][j]=sc.nextInt();
                }
            }
        }
        catch (IOException e) {
            System.out.println("Plik nie istnieje");
        }
    }
    void generateData(){                       // generates randorows 2d array of m n size
        Random r = new Random();
        for(int i=0;i<this.rows;i++)
            for(int j=0;j<this.cols;j++)
                arr[i][j]=r.nextInt(0,2);
    }

    void checkData(){
        Random r = new Random();       // check if there is 1 in every row
        for(int i=0;i<rows;i++){          // does every city has acces in any position
            for(int j=0;j<cols;j++)
                if(arr[i][j]==1)break;
            arr[i][r.nextInt(0,cols)]=1;
        }
    }

    void printData() {            //print data in console
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }

    String  getData(){
        StringBuilder text= new StringBuilder();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                text.append(arr[i][j]);
                text.append(" ");
            }
            text.append("\n");
        }
        return text.toString();
    }

    void exportData(String filePath) throws IOException {      // write data to text file
        try{
            PrintWriter outputWriter = new PrintWriter(filePath);
            outputWriter.println(this.rows);
            outputWriter.println(this.cols);
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    outputWriter.print(arr[i][j]);
                    outputWriter.print(' ');
                }
                outputWriter.println();
            }
            outputWriter.close();
        }
        catch (IOException e){
            System.out.println("Plik nie istnieje");
        }
    }
}
