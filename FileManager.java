import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class FileManager {

    
  public static void main(String[] args) {
    String bro = "\nhello world";
    try {
     BufferedWriter f = new BufferedWriter(new FileWriter("test.txt",true));
        f.write(bro);
        f.close();

    
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    
  }  
}

