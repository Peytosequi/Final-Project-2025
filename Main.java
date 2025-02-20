import java.util.Scanner;



public class Main extends Astronaut  {
    public static void main(String[] args) {
    

      Scanner scanner = new Scanner(System.in);
      int choice;
      do {
        System.out.println("Available operations:");
        System.out.println("1. Mangage password");
        System.out.println("2. Refuel");
        System.out.println("3. Launch");
        System.out.println("4. Exit");
        System.out.println("5. Exit");
        System.out.print("\nEnter your choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
            
                break;
            case 2:
            System.out.println("hello world2");
                break;
            case 3:
            System.out.println("hello world3");    
                break;
            case 4:
            System.out.println("hello world4");
                break;
            case 5: 

            break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
 
    
     

    } while (choice != 5);
} 
}
