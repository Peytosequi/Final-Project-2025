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
String DOB;
int Snumber;
double pay;
double weight;
//
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
    while (!(DOB = scanner.nextLine()).matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\\\d{4}$")) {
        System.out.println("Invalid date of birth. Please try again.");
        System.out.println("Enter date of birth: ");
    }

    System.out.print("Enter Serial number: ");
    Snumber = scanner.nextInt();

    System.out.print("Enter pay: ");
    pay = scanner.nextDouble();

    System.out.print("Enter weight: ");
    weight = scanner.nextDouble();

    scanner.close();
}













}