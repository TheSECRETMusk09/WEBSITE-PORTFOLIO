import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    String fullName;
    String employeeNumber;

    Employee(String fullName, String employeeNumber) {
        this.fullName = fullName;
        this.employeeNumber = employeeNumber;
    }

    void displayEmployee() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Employee Number: " + employeeNumber);
    }
}

public class LAB05_ACTIVITY2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        boolean flag = true;

        while (flag) {
            System.out.println("\n--------------------- Employee Management System ---------------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.next();
                    System.out.print("Enter Employee Number: ");
                    String employeeNumber = scanner.next();
                    Employee newEmployee = new Employee(fullName, employeeNumber);
                    employees.add(newEmployee);
                    break;
                case 2:
                    if (!employees.isEmpty()) {
                        Employee deletedEmployee = employees.remove(employees.size() - 1);
                        System.out.println("\nDeleted Employee:");
                        deletedEmployee.displayEmployee();
                    } else {
                        System.out.println("\nNo employee to delete.");
                    }
                    break;
                case 3:
                    if (!employees.isEmpty()) {
                        System.out.println("\nEmployee List:");
                        for (Employee employee : employees) {
                            employee.displayEmployee();
                            System.out.println();
                        }
                    } else {
                        System.out.println("\nNo employee in the list.");
                    }
                    break;
                case 4:
                    if (!employees.isEmpty()) {
                        System.out.println("\nTop Employee:");
                        employees.get(employees.size() - 1).displayEmployee();
                    } else {
                        System.out.println("\nNo employee in the list.");
                    }
                    break;
                case 5:
                    System.out.println("\nExiting...");
                    flag = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please choose a valid option.");
            }
            System.out.print("\nDo you want to continue? (yes/no): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("no")) {
                flag = false;
            }
        }
        scanner.close();
    }
}
