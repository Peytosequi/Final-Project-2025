import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Scanner;

public class Protect extends Astronaut {

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

    public String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }
}
