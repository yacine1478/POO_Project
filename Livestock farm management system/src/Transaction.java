import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    private int id;
    private String type; //--"Buy" or "Sell"
    private String date;
    private String animalType;
    private int quantity;
    private double totalPrice;
    private String partnerName; //--Name of seller or buyer

    public Transaction(int id, String type, String date, String animalType, int quantity, double totalPrice, String partnerName) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.animalType = animalType;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.partnerName = partnerName;
    }

    @Override
    public String toString() {
        return "Transaction #" + id +
               " | Type: " + type +
               " | Date: " + date +
               " | Animal: " + animalType +
               " | Quantity: " + quantity +
               " | Price: " + totalPrice +
               " | Partner: " + partnerName;
    }

    public String getDate() { return date; }
    public String getAnimalType() { return animalType; }
}

class TransactionManager {
    private ArrayList<Transaction> transactions;
    private Scanner scanner;
    private int nextId = 1;

    public TransactionManager(Scanner scanner) {
        this.scanner = scanner;
        this.transactions = new ArrayList<>();
    }

    public void manageTransactions() {
        while (true) {
            System.out.println("\n=== ANIMAL TRANSACTIONS MANAGEMENT ===");
            System.out.println("1. Add New Transaction");
            System.out.println("2. View All Transactions");
            System.out.println("3. Search by Date");
            System.out.println("4. Search by Animal Type");
            System.out.println("5. Delete Transaction");
            System.out.println("6. Back to Main Menu");
            System.out.print("\nEnter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTransaction();
                case 2 -> viewTransactions();
                case 3 -> searchByDate();
                case 4 -> searchByAnimalType();
                case 5 -> deleteTransaction();
                case 6 -> { return; }
                default -> System.out.println("✗ Invalid choice!");
            }
        }
    }

    private void addTransaction() {
        System.out.println("\n=== ADD NEW TRANSACTION ===");
        System.out.print("Enter type (Buy/Sell): ");
        String type = scanner.nextLine();

        System.out.print("Enter date (e.g., 2026-04-25): ");
        String date = scanner.nextLine();

        System.out.print("Enter animal type: ");
        String animalType = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter total price: ");
        double totalPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter partner name (Buyer/Seller): ");
        String partnerName = scanner.nextLine();

        Transaction transaction = new Transaction(nextId++, type, date, animalType, quantity, totalPrice, partnerName);
        transactions.add(transaction);
        System.out.println("✓ Transaction added successfully!");
    }

    private void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    private void searchByDate() {
        System.out.print("Enter date to search: ");
        String date = scanner.nextLine();
        for (Transaction t : transactions) {
            if (t.getDate().equals(date)) {
                System.out.println(t);
            }
        }
    }

    private void searchByAnimalType() {
        System.out.print("Enter animal type to search: ");
        String animalType = scanner.nextLine();
        for (Transaction t : transactions) {
            if (t.getAnimalType().equalsIgnoreCase(animalType)) {
                System.out.println(t);
            }
        }
    }

    private void deleteTransaction() {
        viewTransactions();
        if (transactions.isEmpty()) return;

        System.out.print("Enter transaction ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        transactions.removeIf(t -> t.toString().contains("Transaction #" + id));
        System.out.println("Transaction deleted successfully!");
    }
}
