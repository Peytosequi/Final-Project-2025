import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Astronaut {
 //Astronaut is a class that contains the following attributes:
String name;
String email;
String phone;
//NOK= Next of Kin
String NOK;
String status;
//DOB= Date of Birth
int DOB;
int Snumber;
double pay;
double weight;

 // Static variable to keep track of the serial number count
 private static int serialNumberCounter = 1;
  // Constructor to initialize the serial number
  public Astronaut() {
    this.Snumber = serialNumberCounter++;
}
public void inputAstronautData() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter name: ");
    name = scanner.nextLine();

    System.out.print("Enter email: ");
    while (!(email = scanner.nextLine()).matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
        System.out.println("Invalid email format. Please try again.");
        System.out.print("Enter email: ");
    }

    System.out.print("Enter phone (format: (000)-000-0000): ");
    while (!(phone = scanner.nextLine()).matches("^\\(\\d{3}\\)-\\d{3}-\\d{4}$")) {
        System.out.println("Invalid phone format. Please try again.");
        System.out.print("Enter phone (format: (000)-000-0000): ");
    }
    

    System.out.print("Enter Next of Kin (NOK): ");
    NOK = scanner.nextLine();

    System.out.print("Enter status: ");
    status = scanner.nextLine();

    System.out.print("Enter Date of Birth (DOB): ");
    DOB = scanner.nextInt();

    System.out.print("Enter pay: ");
    pay = scanner.nextDouble();

    System.out.print("Enter weight: ");
    weight = scanner.nextDouble();

   
}
    // Write data to PriviteAstronaut.tx
public void writeDataToFile() {
    try (FileWriter writer = new FileWriter("PriviteAstronaut.txt", true)) {
        writer.write("Name: " + name + "\n");
        writer.write("Email: " + email + "\n");
        writer.write("Phone: " + phone + "\n");
        writer.write("Next of Kin: " + NOK + "\n");
        writer.write("Status: " + status + "\n");
        writer.write("Date of Birth: " + DOB + "\n");
        writer.write("Serial Number: " + Snumber + "\n");
        writer.write("Pay: " + pay + "\n");
        writer.write("Weight: " + weight + "\n");
        writer.write("-------------------------------\n");
    } catch (IOException e) {
        System.out.println("An error occurred while writing to the file.");
        e.printStackTrace();
    }
}













}