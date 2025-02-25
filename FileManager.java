import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {

    private static final String STORAGE_FILE = "StorageData.txt";

    public FileManager() {
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

    public void storeData(String data) {
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

    // Simulated method that provides data from another source
    private String getDataFromSource() {
        return "Sample data retrieved from another method.";
    }

    // Method to fetch data from another method and store it in the file
    public void fetchAndStoreData() {
        String data = getDataFromSource(); // Retrieve data from another method
        storeData(data); // Store the retrieved data
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.fetchAndStoreData(); // Fetch and store data
        System.out.println("Stored Data: " + fileManager.retrieveData()); // Retrieve and print stored data
    }
}