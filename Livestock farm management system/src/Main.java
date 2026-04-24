import java.util.Scanner;

public class Main {
    private AnimalManager manager;
    private Scanner sc;

    public Main(Scanner sc) {
        this.manager = new AnimalManager();
        this.sc = sc;
    }

    public void run() {

        while (true) {

            System.out.println("\n=== Animal Management System ===");
            System.out.println("1. Add Animal");
            System.out.println("2. Show Animals");
            System.out.println("3. Search Animal");
            System.out.println("4. Update Animal");
            System.out.println("5. Delete Animal");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                int id = generateRandomId();

                System.out.print("Type: ");
                String type = sc.next();

                System.out.print("Age: ");
                int age = sc.nextInt();

                System.out.print("Weight: ");
                double weight = sc.nextDouble();

                System.out.print("Health: ");
                String health = sc.next();

                Animal a = new Animal(id, type, age, weight, health);
                manager.addAnimal(a);
            }

            else if (choice == 2) {
                manager.showAnimals();
            }

            else if (choice == 3) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                manager.searchAnimal(id);
            }

            else if (choice == 4) {
                System.out.print("ID: ");
                int id = sc.nextInt();

                System.out.print("New Type: ");
                String type = sc.next();

                System.out.print("New Health: ");
                String health = sc.next();

                manager.updateAnimal(id, type, health);
            }

            else if (choice == 5) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                manager.deleteAnimal(id);
            }

            else if (choice == 6) {
                System.out.println("\nReturning to main menu...");
                break;
            }

            else {
                System.out.println("Invalid choice");
            }
        }
    }

    private int generateRandomId() {
        java.util.Random rand = new java.util.Random();
        return 1000 + rand.nextInt(9000); // IDs from 1000 to 9999
    }
}