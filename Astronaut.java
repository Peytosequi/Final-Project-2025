import java.sql.*;
import java.util.Scanner;

public class Astronaut {
    // Fields can be final if necessary
    private final String name;
    private final String email;
    private final String phone;
    private final String NOK;
    private final String status;
    private final String DOB;
    private final double pay;
    private final double weight;

    // Default Constructor (Allows Subclasses to Call It)
    public Astronaut() {
        this.name = "Unknown";
        this.email = "unknown@example.com";
        this.phone = "(000)000-0000";
        this.NOK = "Unknown";
        this.status = "On Earth";
        this.DOB = "01/01/1970";
        this.pay = 0.0;
        this.weight = 0.0;
    }

    // Parameterized Constructor
    public Astronaut(String name, String email, String phone, String NOK, String status, String DOB, double pay, double weight) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.NOK = NOK;
        this.status = status;
        this.DOB = DOB;
        this.pay = pay;
        this.weight = weight;
    }

    // Database connection method
    private static Connection connect() {
        String url = "jdbc:sqlite:mission_control.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }

    // Create table if not exists
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS astronauts ("
                   + "serialNumber INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "name TEXT NOT NULL,"
                   + "email TEXT NOT NULL UNIQUE,"
                   + "phone TEXT NOT NULL,"
                   + "NOK TEXT,"
                   + "status TEXT,"
                   + "DOB TEXT,"
                   + "pay REAL,"
                   + "weight REAL"
                   + ");";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Astronaut table ready.");
        } catch (SQLException e) {
            System.out.println("Error creating astronaut table: " + e.getMessage());
        }
    }

    // Insert astronaut into database
    public void saveToDatabase() {
        String sql = "INSERT INTO astronauts(name, email, phone, NOK, status, DOB, pay, weight) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, NOK);
            pstmt.setString(5, status);
            pstmt.setString(6, DOB);
            pstmt.setDouble(7, pay);
            pstmt.setDouble(8, weight);
            pstmt.executeUpdate();
            System.out.println("Astronaut " + name + " added successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving astronaut: " + e.getMessage());
        }
    }

    // Delete astronaut from database
    public static void deleteAstronaut(String name) {
        String sql = "DELETE FROM astronauts WHERE name = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Astronaut " + name + " deleted.");
            } else {
                System.out.println("Astronaut not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting astronaut: " + e.getMessage());
        }
    }

    // Display all astronauts
    public static void listAstronauts() {
        String sql = "SELECT serialNumber, name, status FROM astronauts";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("===== Astronaut Roster =====");
            while (rs.next()) {
                System.out.println(rs.getInt("serialNumber") + " | " + rs.getString("name") + " | " + rs.getString("status"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving astronauts: " + e.getMessage());
        }
    }

    // Menu for astronaut management
    public static void astronautMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== Astronaut Management ====");
            System.out.println("1. Add Astronaut");
            System.out.println("2. Delete Astronaut");
            System.out.println("3. View Astronauts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Email: ");
                    String email;
                    while (!(email = scanner.nextLine()).matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                        System.out.println("Invalid email format. Try again.");
                        System.out.print("Enter Email: ");
                    }

                    System.out.print("Enter Phone (format: (000)-000-0000): ");
                    String phone;
                    while (!(phone = scanner.nextLine()).matches("^\\(\\d{3}\\)-\\d{3}-\\d{4}$")) {
                        System.out.println("Invalid phone format. Try again.");
                        System.out.print("Enter Phone (format: (000)-000-0000): ");
                    }

                    System.out.print("Enter Next of Kin (NOK): ");
                    String NOK = scanner.nextLine();

                    System.out.print("Enter Status (In Space / On Earth): ");
                    String status = scanner.nextLine();

                    System.out.print("Enter DOB (mm/dd/yyyy): ");
                    String DOB = scanner.nextLine();

                    System.out.print("Enter Pay Rate: ");
                    double pay = scanner.nextDouble();

                    System.out.print("Enter Weight: ");
                    double weight = scanner.nextDouble();

                    Astronaut astronaut = new Astronaut(name, email, phone, NOK, status, DOB, pay, weight);
                    astronaut.saveToDatabase();
                    break;

                case 2:
                    System.out.print("Enter Name of Astronaut to Delete: ");
                    String deleteName = scanner.nextLine();
                    deleteAstronaut(deleteName);
                    break;

                case 3:
                    listAstronauts();
                    break;

                case 4:
                    System.out.println("Exiting Astronaut Management.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        createTable(); // Ensure table exists
        astronautMenu();
    }
}