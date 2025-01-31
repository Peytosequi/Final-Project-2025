import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Spaceship {
    
    // Spaceship is a class that contains the following attributes: 
    String name; // Ship name
    List<String> astronauts; // Astronauts assigned to ship
    double fuel; // Fuel capacity of ship
    double currentFuel; // Current fuel in the spaceship

    // Constructor to initialize the astronauts list
    public Spaceship() {
        astronauts = new ArrayList<>();
    }

    // Method to input spaceship data
    public void inputSpaceshipData() {
        Scanner scanner = new Scanner(System.in);

        // Input for spaceship name
        System.out.println("Enter Spaceship's name: ");
        name = scanner.nextLine();

        // Input for spaceship fuel capactiry
        System.out.print("Enter spaceship's fuel capacity (in liters): ");
        boolean validFuel = false;
        while (!validFuel) {
            try {
                fuel = scanner.nextDouble();
                if (fuel <= 0) {
                    System.out.println("Fuel capacity must be a positive number. Please try again.");
                } else {
                    validFuel = true;  // Exit loop if valid input
                }
            } catch (InputMismatchException e) {
                // Handle non-numeric input (letters or other invalid data)
                System.out.println("Invalid input! Please enter a numeric value for fuel capacity.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        // Input for astronauts assigned to the spaceship
        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter number of astronauts: ");
        int numAstronauts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numAstronauts; i++) {
            System.out.print("Enter name of astronaut " + (i + 1) + ": ");
            astronauts.add(scanner.nextLine());
        }

        // Closing the scanner object
        scanner.close();
    }

    // Method to display spaceship data
    public void displaySpaceshipData() {
        System.out.println("\nSpaceship Information:");
        System.out.println("Spaceship Name: " + name);
        System.out.println("Fuel Capacity: " + fuel + " liters");
        System.out.println("Astronauts assigned to the spaceship: ");
        for (String astronaut : astronauts) {
            System.out.println("- " + astronaut);
        }
    }

    public static void main(String[] args) {
        // Create spaceship object and input data
        Spaceship spaceship = new Spaceship();
        spaceship.inputSpaceshipData();

        // Display spaceship data
        spaceship.displaySpaceshipData();
    }

    // Method to add a spaceship to the system
    public void addSpaceship() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Spaceship's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter spaceship's fuel capacity (in liters): ");
        double fuelCapacity = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Create spaceship object with the provided name and fuel capacity
        Spaceship spaceship = new Spaceship();
        spaceship.name = name;
        spaceship.fuel = fuelCapacity;

        // Add spaceship to the system (this part depends on how you manage spaceships in your system)
        // For example, you might have a list of spaceships in a class that manages them
    }
}
