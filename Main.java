import java.util.Scanner;

public class Main extends Astronaut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        Protect p = new Protect();
        
        
        do {
            System.out.println("\nAvailable operations:");
            System.out.println("1. Manage password");
            System.out.println("2. Manage astronauts");
            System.out.println("3. Manage spaceships");
            System.out.println("4. Launch");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Consume invalid input
                continue;
            }
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Managing password...");
                    FileManager f = new FileManager(); 
                    f.retrieveData();


                    break;
                case 2:
                    System.out.println("Managing astronauts...");

                    break;
                case 3:
                    System.out.println("Managing spaceships...");
                    
                    break;
                case 4:
                    System.out.println("Initiating launch process...");
                    Launchprocess launch = new Launchprocess();
                    launch.startlaunch();


                    break;
                case 5:
                System.out.println("Exiting program. Goodbye!");

                 break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        
         scanner.close();
       
        
    }
} 
