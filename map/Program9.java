import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Employee class to represent each employee's information
class Employee {
    private String name;
    private String department;

    // Constructor to initialize employee details
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getters for employee details
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Department: " + department;
    }
}

// EmployeeRecords class to manage employee records using a HashMap
public class Program9 {
    private HashMap<Integer, Employee> employeeMap;

    // Constructor to initialize the HashMap
    public Program9() {
        employeeMap = new HashMap<>();
    }

    // Method to add an employee record
    public void addEmployee(int id, String name, String department) {
        Employee employee = new Employee(name, department);
        employeeMap.put(id, employee);
        System.out.println("Employee added: " + id + " -> " + employee);
    }

    // Method to search for an employee by ID
    public void searchEmployeeById(int id) {
        if (employeeMap.containsKey(id)) {
            Employee employee = employeeMap.get(id);
            System.out.println("Employee found: " + id + " -> " + employee);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Method to display all employee records
    public void displayAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employee records found.");
        } else {
            System.out.println("All employee records:");
            for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
                System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // Main method to run the employee records management system
    public static void main(String[] args) {
        Program9 records = new Program9();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Records Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee department: ");
                    String department = scanner.nextLine();
                    records.addEmployee(id, name, department);
                    break;

                case 2:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    records.searchEmployeeById(searchId);
                    break;

                case 3:
                    records.displayAllEmployees();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
