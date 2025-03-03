import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Spaceship {

    // Data Fields
    private static String name; // Ship Name
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
         BufferedWriter f = new BufferedWriter(new FileWriter("PrivatebSpaceship.txt",true));
            f.write(name);
        f.close();

    
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    
  }  

        
                 // Close scanner at the end }
            
                public static void main(String[] args){
                Scanner s = new Scanner(System.in);
                int choice = 1;
                spaceshipstart();
                                  
                do {
                    System.out.println("You currently have" + currentFuel + "/" + fuelCapacity);
            System.out.println("1. Manage password");
            System.out.println("2. Manage astronauts");
            System.out.println("3. Manage spaceships");
            System.out.println("5. continue");
            System.out.print("\nEnter your choice: ");
            
            if (!s.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                s.next(); // Consume invalid input
                continue;
            }
            
            choice = s.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Managing password...");
                    


                    break;
                case 2:
                    System.out.println("Managing astronauts...");

                    break;
                case 3:
                    System.out.println("Managing spaceships...");
                    
                    break;
                case 4:
                    System.out.println("Initiating launch process...");
                  


                    break;
                case 5:
                System.out.println("continue next to next program");

                 break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        
         s.close();
       
    } 
    }

        
    
