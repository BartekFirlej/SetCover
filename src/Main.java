import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //SetFrame mainProgram = new SetFrame();
        //DataGenerator newData = new DataGenerator("dane.txt");
        //mainProgram.getConfigPanel().getColNumber();
        //int tab[]={1,2,3,4};
        DataGenerator newData = new DataGenerator(5,5);
        BruteForce Prob=new BruteForce(newData);
    }
}