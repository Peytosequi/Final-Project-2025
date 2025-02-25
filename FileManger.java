import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;




public class FileManger {



    private static final String STORAGE_FILE = "StorageData.txt";
    
    public void StorageSystem() {
        ensureFileExists();
    }  
    
    
    private void ensureFileExists() {
        File file = new File(STORAGE_FILE);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Storage file created.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the storage file.");
            e.printStackTrace();
        }
    }
    public  void storeData(String data) {
        try (FileWriter writer = new FileWriter(STORAGE_FILE, false)) { // Overwrite mode
            writer.write(data + "\n");
            System.out.println("Data stored successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing data.");
            e.printStackTrace();
        }
    }
    
    public String retrieveData() {
        try {
            return new String(Files.readAllBytes(Paths.get(STORAGE_FILE)));
        } catch (IOException e) {
            System.out.println("An error occurred while retrieving data.");
            e.printStackTrace();
            return "";
        }
    }
    
    public void clearData() {
        try (FileWriter writer = new FileWriter(STORAGE_FILE)) { // Overwrite file
            writer.write("");
            System.out.println("Storage cleared successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while clearing storage.");
            e.printStackTrace();
        }
    }

    void storeData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


