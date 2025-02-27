import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    private static final String STORAGE_FILE = "StorageData.txt";
    private static final String SOURCE_FILE = "SourceData.txt";

    public FileManager() {
        ensureFileExists(STORAGE_FILE);
    }

    private void ensureFileExists(String filename) {
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println(filename + " created.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating " + filename);
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
            String data = new String(Files.readAllBytes(Paths.get(STORAGE_FILE))).trim();
            return data.isEmpty() ? null : data;
        } catch (IOException e) {
            System.out.println("An error occurred while retrieving data.");
            e.printStackTrace();
            return null;
        }
    }

    public void clearData() {
        storeData("");
        System.out.println("Storage cleared successfully.");
    }

    private String fetchDataFromFile() {
        try {
            return new String(Files.readAllBytes(Paths.get(SOURCE_FILE))).trim();
        } catch (IOException e) {
            System.out.println("An error occurred while reading source file.");
            e.printStackTrace();
            return null;
        }
    }

    public void fetchAndStoreData() {
        String existingData = retrieveData();
        if (existingData == null) { // If no data stored, fetch from source
            String newData = fetchDataFromFile();
            if (newData != null) {
                storeData(newData);
                System.out.println("Fetched data from source and stored it.");
            } else {
                System.out.println("No data available in source file.");
            }
        } else {
            System.out.println("Data already stored. No need to fetch from source.");
        }
    }
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.fetchAndStoreData(); // Fetch and store data
        String storedData = fileManager.retrieveData();
        System.out.println("Stored Data:");
        if (storedData != null) {
            System.out.println(storedData);
        } else {
            System.out.println("No data found.");
        }
    }
}

