import java.util.Scanner;
public class Spaceship {
// Spaceship is a class that contains the following attributes: 
String name; // Ship name
String astronauts; // Astronauts assigned to ship
double fuel; // Fuel capacity of ship
public void inputSpaceshipData() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter Spaceship's name: ");
    name = scanner.nextLine();

    System.out.println("Enter ship's fuel capacity:");
    fuel = scanner.nextDouble();
    






    }
}
