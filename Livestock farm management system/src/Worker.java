import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Worker {
    private int id;
    private String name;
    private int age;
    private String role;
    private double salary;

    // Constructor
    public Worker(String name, int age, String role, double salary) {
        this.id = generateRandomId();
        this.name = name;
        this.age = age;
        this.role = role;
        this.salary = salary;
    }

    // Generate random ID (4-5 digits)
    private int generateRandomId() {
        Random rand = new Random();
        return 1000 + rand.nextInt(90000); // IDs from 1000 to 90999
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setRole(String role) { this.role = role; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Role: %s | Salary: $%.2f",
                           id, name, age, role, salary);
    }
}