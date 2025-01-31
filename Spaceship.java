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
    System.out.print("Enter spaceship's fuel capacity (in pounds): ");
        boolean validFuel = false;
        while (!validFuel) {
            System.out.print("Enter spaceship's fuel capacity (in pounds): ");
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
        System.out.println("Enter astronauts assigned to the spaceship (separate names with commas): ");
        String astronautInput = scanner.nextLine();
        String[] astronautArray = astronautInput.split(",");
        
        // Add astronauts to the list
        for (String astronaut : astronautArray) {
            astronauts.add(astronaut.trim()); // remove extra spaces
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
    


// Method to add a spaceship to the system
public static Spaceship addSpaceship() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter Spaceship's name: ");
    String name = scanner.nextLine();

    System.out.print("Enter spaceship's fuel capacity (in pounds): ");
    double fuelCapacity = scanner.nextDouble();

    // Create spaceship object with the provided name and fuel capacity
    return new Spaceship(name, fuelCapacity);


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Adding a new spaceship
    System.out.println("Spaceship Management System");
    Spaceship spaceship = addSpaceship();

    // Assigning astronauts
    spaceship.assignAstronauts();

    // Loading fuel
    spaceship.loadFuel();

    // Displaying spaceship data
    spaceship.displaySpaceshipData();
    }
}
