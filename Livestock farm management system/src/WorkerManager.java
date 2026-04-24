import java.util.*;

class WorkerManager {
    private HashMap<Integer, Worker> workers;
    private Scanner scanner;

    public WorkerManager(Scanner scanner) {
        workers = new HashMap<>();
        this.scanner = scanner;
    }

    // Add worker
    public void addWorker() {
        System.out.println("\n=== ADD NEW WORKER ===");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter role: ");
        String role = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Worker worker = new Worker(name, age, role, salary);
        workers.put(worker.getId(), worker);

        System.out.println("\n✓ Worker added successfully!");
        System.out.println("Assigned ID: " + worker.getId());
    }

    // Delete worker
    public void deleteWorker() {
        System.out.println("\n=== DELETE WORKER ===");
        System.out.print("Enter worker ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (workers.containsKey(id)) {
            Worker removed = workers.remove(id);
            System.out.println("\n✓ Worker deleted successfully!");
            System.out.println("Deleted worker: " + removed.getName());
        } else {
            System.out.println("\n✗ Worker with ID " + id + " not found!");
        }
    }

    // Edit worker
    public void editWorker() {
        System.out.println("\n=== EDIT WORKER ===");
        System.out.print("Enter worker ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (workers.containsKey(id)) {
            Worker worker = workers.get(id);
            System.out.println("\nCurrent details:");
            System.out.println(worker);
            System.out.println("\nWhat would you like to edit?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Role");
            System.out.println("4. Salary");
            System.out.println("5. All fields");
            System.out.print("Choose option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    worker.setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new age: ");
                    worker.setAge(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Enter new role: ");
                    worker.setRole(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter new salary: ");
                    worker.setSalary(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Enter new name: ");
                    worker.setName(scanner.nextLine());
                    System.out.print("Enter new age: ");
                    worker.setAge(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Enter new role: ");
                    worker.setRole(scanner.nextLine());
                    System.out.print("Enter new salary: ");
                    worker.setSalary(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Invalid option!");
                    return;
            }

            System.out.println("\n✓ Worker updated successfully!");
            System.out.println("Updated details:");
            System.out.println(worker);

        } else {
            System.out.println("\n✗ Worker with ID " + id + " not found!");
        }
    }

    // Display all workers
    public void displayAllWorkers() {
        System.out.println("\n=== ALL WORKERS ===");
        if (workers.isEmpty()) {
            System.out.println("No workers found!");
        } else {
            System.out.println("Total workers: " + workers.size());
            System.out.println("-------------------");
            for (Worker worker : workers.values()) {
                System.out.println(worker);
            }
        }
    }

    // Search worker by ID
    public void searchWorker() {
        System.out.println("\n=== SEARCH WORKER ===");
        System.out.print("Enter worker ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (workers.containsKey(id)) {
            System.out.println("\nWorker found:");
            System.out.println(workers.get(id));
        } else {
            System.out.println("\n✗ Worker with ID " + id + " not found!");
        }
    }

    // Method to handle worker management menu
    public void manageWorkers() {
        while (true) {
            System.out.println("\n=== WORKER MANAGEMENT ===");
            System.out.println("1. Add Worker");
            System.out.println("2. Delete Worker");
            System.out.println("3. Edit Worker");
            System.out.println("4. View All Workers");
            System.out.println("5. Search Worker by ID");
            System.out.println("6. Back to Main Menu");
            System.out.print("\nEnter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    deleteWorker();
                    break;
                case 3:
                    editWorker();
                    break;
                case 4:
                    displayAllWorkers();
                    break;
                case 5:
                    searchWorker();
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("\n✗ Invalid choice! Please try again.");
            }
        }
    }
}