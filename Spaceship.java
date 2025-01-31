import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Spaceship {
    
    // Spaceship is a class that contains the following attributes: 
    private String name; // Ship name
    private List<String> astronauts; // Astronauts assigned to the ship
    private double fuel; // Fuel capacity of ship (in pounds)
    private double currentFuel; // Current fuel in the spaceship

    // Method to assign astronauts
    public Spaceship(String name, double fuelCapacity) {
        this.name = name;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = 0; // To start, no fuel loaded
        this.astronauts = new ArrayList<>();
    }

    // Method to assign astronauts
    public void assignAstronauts(Scanner scanner) {
        System.out.print("Enter astronaut names. Please separate by comma: ");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        for (String name : names){
            astronauts.add(name.trim());
        }
        System.out.println("Astronauts assigned successfully!")
    }

    // Method to load fuel
    public void loadFuel(Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter fuel amount to load (in pounds): ");
            try {
                double fuelAmount = scanner.nextDouble();
                if (fuelAmount <= 0) {
                    System.out.println("Fuel must be a positive value.");
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
    }

    // Method to display spaceship information
    public void displaySpaceshipData() {
        System.out.println("\n🚀 Spaceship Information:");
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
        scanner.nextLine(); // Consume leftover newline
        return new Spaceship(name, fuelCapacity);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Adding a spaceship
        System.out.println("🌌 Welcome to the Spaceship Management System! 🚀");
        Spaceship spaceship = addSpaceship(scanner);

        // Assign astronauts
        spaceship.assignAstronauts(scanner);

        // Load fuel
        spaceship.loadFuel(scanner);

        // Display spaceship data
        spaceship.displaySpaceshipData();

        scanner.close(); // Close scanner at the end
    }
}