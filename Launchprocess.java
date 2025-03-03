
public class Launchprocess {
    private Spaceship spaceship;
    private double fuelBurnRate = 10; // Base fuel burn rate (pounds per second)
    private double speed = 0; // Speed starts at 0 m/s
    private double distance = 0; // Distance starts at 0 meters
    private static final double TIME_STEP = 1; // 1 second per iteration
    private static final double TARGET_DISTANCE = 70000; // Minimum success distance
    private static final double SPEED_LIMIT = 3000; // Max speed limit in m/s
    private static final double SPEED_MULTIPLIER = .15; // Slower speed increase (change this value to adjust)

    // Constructor
    public Launchprocess(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public void startlaunch() {
        System.out.println("\n🚀 Initiating launch for spaceship: " + spaceship.getName());
        System.out.println("Fuel Level: " + spaceship.getCurrentFuel() + "/" + spaceship.getFuelCapacity() + " pounds");
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

        System.out.println("\n🚀 Liftoff! The spaceship " + spaceship.getName());

        double currentFuel = spaceship.getCurrentFuel();

        // Acceleration phase
        while (currentFuel >= fuelBurnRate) {
            currentFuel -= fuelBurnRate; // Reduce fuel

            // Slower speed increase with a lower multiplier
            speed += fuelBurnRate * SPEED_MULTIPLIER;
            if (speed > SPEED_LIMIT) {
                speed = SPEED_LIMIT; // Limit speed to 3000 m/s
            }

            distance += speed * TIME_STEP; // Increase distance

            // Adjust burn rate based on speed, but it won't affect speed after cap
            fuelBurnRate = 10 + (speed / 100) * 2; 

            System.out.printf("Speed: %.2f m/s | Distance: %.2f meters | Fuel Remaining: %.2f pounds%n \r", speed, distance, currentFuel);

            if (distance >= TARGET_DISTANCE) {
                System.out.println("\n🎉 MISSION SUCCESS! The spaceship has reached " + TARGET_DISTANCE + " meters.");
                return;
            }

            try {
                Thread.sleep(1000); // Simulate 1-second intervals
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // If fuel runs out before reaching 70,000 meters
        System.out.println("\n❌ MISSION FAILURE! The spaceship only reached " + distance + " meters before fuel depletion.");
    }

 
}
