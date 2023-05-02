import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //new SetFrame();
        //new configPanel();
        DataGenerator newData = new DataGenerator("dane.txt");
        newData.printData();
    }
}