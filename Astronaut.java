import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Astronaut {
 //Astronaut is a class that  contains the following attributes:
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

    System.out.print("Enter Date of Birth (DOB) (format: mm/dd/yyyy): ");
    String dobInput = scanner.nextLine();
    while (!dobInput.matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$")) {
        System.out.println("Invalid DOB format. Please try again.");
        System.out.print("Enter Date of Birth (DOB) (format: mm/dd/yyyy): ");
        dobInput = scanner.nextLine();
    } 
    String[] dobParts = dobInput.split("/");
    DOB = Integer.parseInt(dobParts[2] + dobParts[0] + dobParts[1]);

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

public void deleteAstronautData() {
    try (BufferedReader reader = new BufferedReader(new FileReader("PriviteAstronaut.txt"))) {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        List<String> names = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith("Name: ")) {
                names.add(lines.get(i).substring(6));
            }
        }

        if (names.isEmpty()) {
            System.out.println("No astronauts found.");
            return;
        }

        System.out.println("Astronauts:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the astronaut to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        if (index < 0 || index >= names.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.print("Type 'DELETE' to confirm or 'CANCEL' to cancel: ");
        String confirmation = scanner.nextLine();

        if (!confirmation.equalsIgnoreCase("DELETE")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        String nameToDelete = names.get(index);
        try (FileWriter writer = new FileWriter("PriviteAstronaut.txt")) {
            boolean skip = false;
            for (String l : lines) {
                if (l.equals("Name: " + nameToDelete)) {
                    skip = true;
                }
                if (skip && l.startsWith("-------------------------------")) {
                    skip = false;
                    continue;
                }
                if (!skip) {
                    writer.write(l + "\n");
                }
            }
        }

        System.out.println("Astronaut " + nameToDelete + " deleted successfully.");
    } catch (IOException e) {
        System.out.println("An error occurred while reading or writing to the file.");
        e.printStackTrace();
    }
}




public void AstronautMenu (){
Scanner scan = new Scanner(System.in);
int choice;
System.out.println("Wecome to the system");
System.out.println(" what do you want to do today?");
System.out.println("1. create a new Astronaut"+ "\n 2. Deleate an astronaut");
choice=scan.nextInt();
if(choice==1){
    inputAstronautData();  
}
if( choice==2){
deleteAstronautData();
}
else{
   System.out.println("That is not an option");
}


}