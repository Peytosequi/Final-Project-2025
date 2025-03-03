import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Spaceship {

    // Data Fields
    private static String name; // Ship Name
<<<<<<< HEAD
    private static double fuelCapacity; // Fuel Capacity (in pounds)
    private static double currentFuel; // Current Fuel Level
    private List<String> astronauts; // List of Assigned Astronauts
=======
        private static double fuelCapacity; // Fuel Capacity (in pounds)
            private static double currentFuel; // Current Fuel Level
                private List<String> astronauts; // List of Assigned Astronauts
                public String getName() {
                    return name;
                }
                
                public double getFuelCapacity() {
                    return fuelCapacity;
                }
                
                public double getCurrentFuel() {
                    return currentFuel;
                }
                
                public List<String> getAstronauts() {
                    return astronauts;
                }
                // Constructor
                public Spaceship(String name, double fuelCapacity) {
                    this.name = name;
                    this.fuelCapacity = fuelCapacity;
                    this.currentFuel = 0; // Initially, no fuel loaded
                    this.astronauts = new ArrayList<>();
                }
            
                // Default constructor
                public Spaceship() {
                    // Initialization code
                }
            
                // Method to assign astronauts
                public void assignAstronauts(Scanner scanner) {
                    System.out.print("Enter astronaut names (separated by commas): ");
                    String input = scanner.nextLine();
                    String[] names = input.split(",");
                    for (String astronaut : names) {
                        astronauts.add(astronaut.trim());
                    }
                    System.out.println(" Astronauts assigned successfully!");
                }
            
                // Method to load fuel
                public void loadFuel(Scanner scanner) {
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.print("Enter fuel amount to load (in pounds): ");
                        try {
                            double fuelAmount = scanner.nextDouble();
                            if (fuelAmount <= 0) {
                                System.out.println(" Fuel amount must be positive.");
                            } else if (fuelAmount + currentFuel > fuelCapacity) {
                                System.out.println(" Cannot load beyond fuel capacity.");
                            } else {
                                currentFuel += fuelAmount;
                                System.out.println(" Successfully loaded " + fuelAmount + " pounds of fuel.");
                                validInput = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(" Invalid input! Please enter a numeric value.");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }
                    scanner.nextLine(); // Consume newline character
                }
            
                // Method to display spaceship information
                public void displaySpaceshipData() {
                    System.out.println("\n Spaceship Information:");
                    System.out.println("Ship Name: " + name);
                    System.out.println("Fuel Capacity: " + fuelCapacity + " pounds");
                    System.out.println("Current Fuel Level: " + currentFuel + " pounds");
                    System.out.println("Assigned Astronauts: " + (astronauts.isEmpty() ? "None" : String.join(", ", astronauts)));
                }
            
                // Method to create and return a spaceship
                public static Spaceship addSpaceship(Scanner scanner) {
                    System.out.print("Enter Spaceship Name: ");
                    String name = scanner.nextLine();
            
                    double fuelCapacity = 0;
                    boolean validFuel = false;
                    while (!validFuel) {
                        System.out.print("Enter Fuel Capacity (in pounds): ");
                        try {
                            fuelCapacity = scanner.nextDouble();
                            if (fuelCapacity <= 0) {
                                System.out.println(" Fuel capacity must be positive.");
                            } else {
                                validFuel = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(" Invalid input! Please enter a numeric value.");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }
                    scanner.nextLine(); 
                    return new Spaceship(name, fuelCapacity);
                }
            
                // Main method
        @SuppressWarnings("ConvertToTryWithResources")
                public static void  spaceshipstart() {
                    Scanner scanner = new Scanner(System.in);
                    
                    // Adding a spaceship
                    System.out.println(" Welcome to the Spaceship Management System! ");
                    Spaceship spaceship = addSpaceship(scanner);
            
                    // Assign astronauts
                    spaceship.assignAstronauts(scanner);
            
                    // Load fuel
                    spaceship.loadFuel(scanner);
            
                    // Display spaceship data
                    spaceship.displaySpaceshipData();
    
                    try {
         BufferedWriter f = new BufferedWriter(new FileWriter("PrivateSpaceship.txt",true));
            f.write(name);
        f.close();
>>>>>>> 53acf37dbd7feba609d1a66c790650ae10298fd2

    public String getName() {
        return name;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public List<String> getAstronauts() {
        return astronauts;
    }

    // Constructor
    public Spaceship(String name, double fuelCapacity) {
        this.name = name;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = 0; // Initially, no fuel loaded
        this.astronauts = new ArrayList<>();
    }

    // Default constructor
    public Spaceship() {
        // Initialization code
    }

    // Method to assign astronauts
    public void assignAstronauts(Scanner scanner) {
        List<String> availableAstronauts = readAstronautsFromFile();
        if (availableAstronauts.isEmpty()) {
            System.out.println("No astronauts available to assign.");
            return;
        }

        System.out.println("Available astronauts:");
        for (int i = 0; i < availableAstronauts.size(); i++) {
            System.out.println((i + 1) + ". " + availableAstronauts.get(i));
        }

        System.out.print("Enter the names of the astronauts to assign (separated by commas): ");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        for (String name : names) {
            name = name.trim();
            if (availableAstronauts.contains(name)) {
                astronauts.add(name);
            } else {
                System.out.println("Astronaut not found: " + name);
            }
        }
        System.out.println("Astronauts assigned successfully!");
    }

    // Method to read astronauts from file
    private List<String> readAstronautsFromFile() {
        List<String> astronauts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("PriviteAstronaut.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("TmFtZTog")) { // Base64 encoded "Name: "
                    String decodedLine = new String(Base64.getDecoder().decode(line));
                    astronauts.add(decodedLine.substring(6)); // Remove "Name: " prefix
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return astronauts;
    }

    // Method to load fuel
    public void loadFuel(Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter fuel amount to load (in pounds): ");
            try {
                double fuelAmount = scanner.nextDouble();
                if (fuelAmount <= 0) {
                    System.out.println("Fuel amount must be positive.");
                } else if (fuelAmount + currentFuel > fuelCapacity) {
                    System.out.println("Cannot load beyond fuel capacity.");
                } else {
                    currentFuel += fuelAmount;
                    System.out.println("Successfully loaded " + fuelAmount + " pounds of fuel.");
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consume newline character
    }

    // Method to display spaceship information
    public void displaySpaceshipData() {
        System.out.println("\nSpaceship Information:");
        System.out.println("Ship Name: " + name);
        System.out.println("Fuel Capacity: " + fuelCapacity + " pounds");
        System.out.println("Current Fuel Level: " + currentFuel + " pounds");
        System.out.println("Assigned Astronauts: " + (astronauts.isEmpty() ? "None" : String.join(", ", astronauts)));
    }

    // Method to create and return a spaceship
    public static Spaceship addSpaceship(Scanner scanner) {
        System.out.print("Enter Spaceship Name: ");
        String name = scanner.nextLine();

        double fuelCapacity = 0;
        boolean validFuel = false;
        while (!validFuel) {
            System.out.print("Enter Fuel Capacity (in pounds): ");
            try {
                fuelCapacity = scanner.nextDouble();
                if (fuelCapacity <= 0) {
                    System.out.println("Fuel capacity must be positive.");
                } else {
                    validFuel = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.nextLine(); 
        return new Spaceship(name, fuelCapacity);
    }

    // Encode data using Base64
    private static String encodeData(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    // Write spaceship data to PrivatebSpaceship.txt
    public void writeDataToFile() {
        try (FileWriter writer = new FileWriter("PrivatebSpaceship.txt", true)) {
            writer.write(encodeData("Name: " + name) + "\n");
            writer.write(encodeData("Fuel Capacity: " + fuelCapacity) + "\n");
            writer.write(encodeData("Current Fuel: " + currentFuel) + "\n");
            writer.write(encodeData("Astronauts: " + String.join(", ", astronauts)) + "\n");
            writer.write("-------------------------------\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to delete a spaceship from file
    public static void deleteSpaceship(Scanner scanner) {
        List<String> spaceships = readSpaceshipsFromFile();
        if (spaceships.isEmpty()) {
            System.out.println("No spaceships available to delete.");
            return;
        }

        System.out.println("Available spaceships:");
        for (int i = 0; i < spaceships.size(); i++) {
            System.out.println((i + 1) + ". " + spaceships.get(i));
        }

        System.out.print("Enter the number of the spaceship to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= spaceships.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        String spaceshipToDelete = spaceships.get(index);
        try (BufferedReader reader = new BufferedReader(new FileReader("PrivatebSpaceship.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("PrivatebSpaceship_temp.txt"))) {
            String line;
            boolean skip = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals(encodeData("Name: " + spaceshipToDelete))) {
                    skip = true;
                }
                if (skip && line.startsWith("-------------------------------")) {
                    skip = false;
                    continue;
                }
                if (!skip) {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the file.");
            e.printStackTrace();
        }

        // Rename temp file to original file
        try {
            java.nio.file.Files.delete(java.nio.file.Paths.get("PrivatebSpaceship.txt"));
            java.nio.file.Files.move(java.nio.file.Paths.get("PrivatebSpaceship_temp.txt"), java.nio.file.Paths.get("PrivatebSpaceship.txt"));
        } catch (IOException e) {
            System.out.println("An error occurred while renaming the file.");
            e.printStackTrace();
        }

        System.out.println("Spaceship " + spaceshipToDelete + " deleted successfully.");
    }

    // Method to read spaceships from file
    private static List<String> readSpaceshipsFromFile() {
        List<String> spaceships = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("PrivatebSpaceship.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("TmFtZTog")) { // Base64 encoded "Name: "
                    String decodedLine = new String(Base64.getDecoder().decode(line));
                    spaceships.add(decodedLine.substring(6)); // Remove "Name: " prefix
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return spaceships;
    }

    // Main method
    @SuppressWarnings("ConvertToTryWithResources")


    public static void spaceshipstart() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
            System.out.println("\nSpaceship Management System");
            System.out.println("1. Create a new spaceship");
            System.out.println("2. Delete a spaceship");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Adding a spaceship
                    Spaceship spaceship = addSpaceship(scanner);

                    // Assign astronauts
                    spaceship.assignAstronauts(scanner);

                    // Load fuel
                    spaceship.loadFuel(scanner);

                    // Display spaceship data
                    spaceship.displaySpaceshipData();

                    // Write spaceship data to file
                    spaceship.writeDataToFile();
                    break;
                case 2:
                    // Deleting a spaceship
                    deleteSpaceship(scanner);
                    break;
                case 3:
                    System.out.println("Exiting Spaceship Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        
    }


}



