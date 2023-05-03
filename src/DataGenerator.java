import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DataGenerator {
    int m; // number of rows - cities
    int n; // number of cols - possible places
    int[][] arr; // array informing does city has acces via this place
    DataGenerator(int m, int n){       // generates data with given size and checks is correct
        this.m=m;
        this.n=n;
        this.arr=new int[m][n];
        this.generateData();
        this.checkData();
    }
    DataGenerator(String filePath){                      // reads from txt file generated data
        try{
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            this.m=sc.nextInt();
            this.n=sc.nextInt();
            this.arr = new int[m][n];
            for(int i=0;i<this.m;i++){
                for(int j=0;j<this.n;j++){
                    this.arr[i][j]=sc.nextInt();
                }
            }
        }
        catch (IOException e) {
            System.out.println("Plik nie istnieje");
        }
    }
    void generateData(){                       // generates random 2d array of m n size
        Random r = new Random();
        for(int i=0;i<this.m;i++)
            for(int j=0;j<this.n;j++)
                arr[i][j]=r.nextInt(0,2);
    }

    void checkData(){
        Random r = new Random();       // check if there is 1 in every row
        for(int i=0;i<m;i++){          // does every city has acces in any position
            for(int j=0;j<n;j++)
                if(arr[i][j]==1)break;
            arr[i][r.nextInt(0,n)]=1;
        }
    }

    void printData() {            //print data in console
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }

    String  getData(){
        StringBuilder text= new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
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
            outputWriter.println(this.m);
            outputWriter.println(this.n);
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
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
