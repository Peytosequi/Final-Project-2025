import java.util.Scanner;
public class Astronaut{
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
public void inputAstronautData() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter name: ");
    name = scanner.nextLine();

    System.out.print("Enter email: ");
    while (!(email = scanner.nextLine()).matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
        System.out.println("Invalid email format. Please try again.");
        System.out.print("Enter email: ");
    }

    System.out.print("Enter phone: ");
    phone = scanner.nextLine();

    System.out.print("Enter Next of Kin (NOK): ");
    NOK = scanner.nextLine();

    System.out.print("Enter status: ");
    status = scanner.nextLine();

    System.out.print("Enter Date of Birth (DOB): ");
    DOB = scanner.nextInt();

    System.out.print("Enter Serial number: ");
    Snumber = scanner.nextInt();

    System.out.print("Enter pay: ");
    pay = scanner.nextDouble();

    System.out.print("Enter weight: ");
    weight = scanner.nextDouble();
}




public static void main(String[] args) {
    Astronaut astronaut = new Astronaut();
    astronaut.inputAstronautData();
    System.out.println("Name: " + astronaut.name);
    System.out.println("Email: " + astronaut.email);
    System.out.println("Phone: " + astronaut.phone);
    System.out.println("Next of Kin (NOK): " + astronaut.NOK);
    System.out.println("Status: " + astronaut.status);
    System.out.println("Date of Birth (DOB): " + astronaut.DOB);
    System.out.println("Serial number: " + astronaut.Snumber);
    System.out.println("Pay: " + astronaut.pay);
    System.out.println("Weight: " + astronaut.weight);








}
}


















