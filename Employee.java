import java.util.ArrayList;
import java.util.Scanner;

// Employee Class
class Employee {
    private int id;
    private String name;
    private double basicSalary;

    // Constructor
    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Calculate Salary with example deductions and allowances
    public double calculateSalary() {
        double hra = 0.2 * basicSalary; // 20% HRA
        double da = 0.1 * basicSalary; // 10% DA
        double deductions = 0.1 * basicSalary; // 10% deductions
        return basicSalary + hra + da - deductions;
    }
}

// Payroll System Class
public class PayrollSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Payroll System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Payroll");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayPayroll();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // Method to add an employee
    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        Employee employee = new Employee(id, name, basicSalary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    // Method to display the payroll
    private static void displayPayroll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("\nPayroll Details:");
        System.out.printf("%-10s %-20s %-15s %-15s%n", "ID", "Name", "Basic Salary", "Net Salary");
        for (Employee employee : employees) {
            System.out.printf("%-10d %-20s %-15.2f %-15.2f%n",
                    employee.getId(),
                    employee.getName(),
                    employee.getBasicSalary(),
                    employee.calculateSalary());
        }
    }
}
