import java.util.Scanner;

public class Managment {
    private static Scanner scanner;
    private static WorkerManager workerManager;
    private static StorageManager storageManager;
    private static GestionVisites gestionVisites;
    private static TransactionManager transactionManager;

    public static void managment(){
        scanner = new Scanner(System.in);
        workerManager = new WorkerManager(scanner);
        storageManager = new StorageManager(scanner);
        gestionVisites = new GestionVisites(scanner);
        transactionManager = new TransactionManager(scanner);
        Main animalManager = new Main(scanner);
        int choice;
        boolean isRunning = true ;
        while (isRunning) {
        System.out.println("*****************");
        System.out.println("1. Manage the Workers");
        System.out.println("*****************");
        System.out.println("2. Manage the Storage");
        System.out.println("*****************");
        System.out.println("3. History of Medical Treatments");
        System.out.println("*****************");
        System.out.println("4. Manage Animals");
        System.out.println("*****************");
        System.out.println("5. Manage the History of buy and sell");
        System.out.println("*****************");
        System.out.println("7. Exit");
        System.out.println("*****************");
        System.out.printf("- enter your choice (1-6) - ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1 -> workerManager.manageWorkers();
            case 2 -> storageManager.manageStorages();
            case 3 -> manageVeterinaryVisits();
            case 4 -> animalManager.run();
            case 5 -> transactionManager.manageTransactions();
            case 6 -> isRunning = false;
            default -> System.out.println("invalid choice");


            }
        }
    }
    
    private static void manageVeterinaryVisits() {
        while (true) {
            System.out.println("\n=== VETERINARY VISITS MANAGEMENT ===");
            System.out.println("1. Add New Veterinary Visit");
            System.out.println("2. View All Visits");
            System.out.println("3. Search by Date");
            System.out.println("4. Search by Veterinarian");
            System.out.println("5. Delete Visit");
            System.out.println("6. Back to Main Menu");
            System.out.print("\nEnter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addVeterinaryVisit();
                    break;
                case 2:
                    gestionVisites.afficherVisites();
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                    break;
                case 3:
                    searchByDate();
                    break;
                case 4:
                    searchByVeterinarian();
                    break;
                case 5:
                    deleteVisit();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        }
    }

    private static void addVeterinaryVisit() {
        System.out.println("\n=== ADD NEW VETERINARY VISIT ===");
        
        System.out.print("Enter visit date (e.g., 2026-04-24): ");
        String date = scanner.nextLine();

        System.out.print("Enter veterinarian name: ");
        String nomVeterinaire = scanner.nextLine();

        System.out.print("Enter animal type (Cow, Sheep, Goat, etc.): ");
        String animalType = scanner.nextLine();

        System.out.print("Enter animal ID: ");
        int animalId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter diagnostic: ");
        String diagnostic = scanner.nextLine();

        System.out.print("Enter treatment: ");
        String traitement = scanner.nextLine();

        VisiteVeterinaire visite = new VisiteVeterinaire(date, nomVeterinaire, diagnostic, traitement, animalType, animalId);
        gestionVisites.ajouterVisite(visite);
    }

    private static void searchByDate() {
        System.out.println("\n=== SEARCH BY DATE ===");
        System.out.print("Enter date to search (e.g., 2026-04-24): ");
        String date = scanner.nextLine();
        gestionVisites.rechercherParDate(date);
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void searchByVeterinarian() {
        System.out.println("\n=== SEARCH BY VETERINARIAN ===");
        System.out.print("Enter veterinarian name: ");
        String nomVeterinaire = scanner.nextLine();
        gestionVisites.rechercherParVeterinaire(nomVeterinaire);
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void deleteVisit() {
        System.out.println("\n=== DELETE VETERINARY VISIT ===");
        gestionVisites.afficherVisites();

        if (gestionVisites.getVisitesCount() == 0) {
            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
            return;
        }

        System.out.print("\nEnter visit number to delete: ");
        int visitNumber = scanner.nextInt();
        scanner.nextLine();
        gestionVisites.supprimerVisite(visitNumber - 1);
    }
}
