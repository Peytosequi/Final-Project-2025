import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class FileManager {

    
  public static void main(String[] args) {
    String bro = "HELLO WORLD";
    try {
     BufferedWriter f = new BufferedWriter(new FileWriter("test.txt"));
        f.write(bro);
        f.close();

    
    } catch (IOException e) {
        e.printStackTrace();
    }
    
  }  
}

