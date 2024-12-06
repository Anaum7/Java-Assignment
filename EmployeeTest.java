class Employee {
    private String name;
    private String id;
    private double basicSalary;
    private double hraAllowance;
    private double bonus;

    // Constructor
    public Employee(String name, String id, double basicSalary, double hraAllowance) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
        this.hraAllowance = hraAllowance;
        this.bonus = 0; // Initialize bonus to 0
    }

    // Method to calculate gross salary
    public double calculateGrossSalary() {
        return basicSalary + hraAllowance + bonus;
    }

    // Method to apply bonus
    public void applyBonus(double bonus) {
        this.bonus += bonus; // Add bonus to existing bonus
    }

    // Method to print updated salary details
    public void printSalaryDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA Allowance: " + hraAllowance);
        System.out.println("Bonus: " + bonus);
        System.out.println("Gross Salary: " + calculateGrossSalary());
        System.out.println("-----------------------------");
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        // Create multiple Employee objects
        Employee emp1 = new Employee("Alice", "E001", 50000, 15000);
        Employee emp2 = new Employee("Bob", "E002", 60000, 20000);
        Employee emp3 = new Employee("Charlie", "E003", 55000, 18000);

        // Apply bonuses
        emp1.applyBonus(5000);
        emp2.applyBonus(7000);
        emp3.applyBonus(6000);

        // Print salary details for each employee
        emp1.printSalaryDetails();
        emp2.printSalaryDetails();
        emp3.printSalaryDetails();
    }
}
