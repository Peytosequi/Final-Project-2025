import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Scanner;

public class Protect extends Astronaut {

    // Assuming getAstronautData() should return some data about the astronaut
    private String getAstronautData() {
        // Replace with actual data retrieval logic
        return "Astronaut Data";
    }

    private static final String PASSWORD_FILE = "password.txt";
    private static final int PASSWORD_LENGTH = 12;

    public void PriviteFile() {
        try {
            File privite = new File("PriviteAstronaut.txt");
            if (privite.createNewFile()) {
                System.out.println("File created: " + privite.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        writeDataToFile();
    }

    public void writeDataToFile() {
        try (FileWriter writer = new FileWriter("PriviteAstronaut.txt", true)) { // Open file in append mode
            writer.write(getAstronautData());
            writer.write("-------------------------------\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public void generateAndSavePassword() {
        String password = generateRandomPassword(PASSWORD_LENGTH);
        try (FileWriter writer = new FileWriter(PASSWORD_FILE)) {
            writer.write(password);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the password to the file.");
            e.printStackTrace();
        }
        System.out.println("Generated Password: " + password);
    }

    public boolean verifyPassword() {
        String savedPassword;
        try {
            savedPassword = new String(Files.readAllBytes(Paths.get(PASSWORD_FILE)));
        } catch (IOException e) {
            System.out.println("An error occurred while reading the password file.");
            e.printStackTrace();
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password: ");
        String inputPassword = scanner.nextLine();

        return savedPassword.equals(inputPassword);
    }

    private String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }

    private String encryptData(String data, int shift) {
      StringBuilder encrypted = new StringBuilder();

      for (char c : data.toCharArray()) {
        encrypted.append((char) (c + shift));
      }

      return encrypted.toString();
    }

    public void decryptAndDisplayData() {
      if (!verifyPassword()) {
        System.out.println("Incorrect password. Access denied.");
        return;
      }

      String encryptedData;
      try {
        encryptedData = new String(Files.readAllBytes(Paths.get("PriviteAstronaut.txt")));
      } catch (IOException e) {
        System.out.println("An error occurred while reading the encrypted data file.");
        e.printStackTrace();
        return;
      }

      String decryptedData = decryptData(encryptedData, PASSWORD_LENGTH);
      System.out.println("Decrypted Data: " + decryptedData);
    }

    private String decryptData(String data, int shift) {
      StringBuilder decrypted = new StringBuilder();

      for (char c : data.toCharArray()) {
        decrypted.append((char) (c - shift));
      }

      return decrypted.toString();
    }
}
