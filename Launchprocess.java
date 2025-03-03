
import java.util.Scanner;

public class Launchprocess {
    private Spaceship spaceship; // Spaceship instance to access data

    // Constructor to receive spaceship data
    public Launchprocess(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public void startlaunch() {
        System.out.println("\nInitiating launch process for spaceship: " + spaceship.getName());
        System.out.println("Fuel Level: " + spaceship.getCurrentFuel() + "/" + spaceship.getFuelCapacity());
        System.out.println("Assigned Astronauts: " + String.join(", ", spaceship.getAstronauts()));
        System.out.println("\nCountdown started...");

        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // Delay of 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\n🚀 Liftoff! The spaceship " + spaceship.getName() + " has launched successfully!");
    }



public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Spaceship spaceship = new Spaceship("Apollo", 5000);

    spaceship.assignAstronauts(scanner);
    spaceship.loadFuel(scanner);
    spaceship.displaySpaceshipData();
   

    // Passing spaceship data to Launchprocess
    Launchprocess launch = new Launchprocess(spaceship);
    launch.startlaunch();

    scanner.close();
}


}
