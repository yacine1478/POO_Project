import java.util.*;

// Storage Manager Class
class StorageManager {
    private HashMap<Integer, Storage> storages;
    private Scanner scanner;

    public StorageManager(Scanner scanner) {
        storages = new HashMap<>();
        this.scanner = scanner;
    }

    // Add new storage
    public void addStorage() {
        System.out.println("\n=== ADD NEW STORAGE ===");
        System.out.print("Enter storage capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Storage storage = new Storage(capacity);
        storages.put(storage.getStorageId(), storage);

        System.out.println("\n✓ Storage added successfully!");
        System.out.println("Assigned Storage ID: " + storage.getStorageId());
    }

    // Delete storage
    public void deleteStorage() {
        System.out.println("\n=== DELETE STORAGE ===");
        System.out.print("Enter storage ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (storages.containsKey(id)) {
            Storage removed = storages.remove(id);
            System.out.println("\n✓ Storage deleted successfully!");
            System.out.println("Deleted Storage ID: " + removed.getStorageId());
            System.out.println("It contained " + removed.getProducts().size() + " products");
        } else {
            System.out.println("\n✗ Storage with ID " + id + " not found!");
        }
    }

    // Edit storage
    public void editStorage() {
        System.out.println("\n=== EDIT STORAGE ===");
        System.out.print("Enter storage ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (storages.containsKey(id)) {
            Storage storage = storages.get(id);

            System.out.println("\nCurrent storage info:");
            storage.displayStorageInfo();

            System.out.println("\nWhat would you like to edit?");
            System.out.println("1. Capacity");
            System.out.println("2. Manure Quantity");
            System.out.println("3. Both");
            System.out.print("Choose option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new capacity: ");
                    int newCapacity = scanner.nextInt();
                    scanner.nextLine();

                    if (newCapacity < storage.getCurrentStock()) {
                        System.out.println("✗ Cannot reduce capacity below current stock!");
                        System.out.println("Current stock: " + storage.getCurrentStock());
                    } else {
                        storage.setCapacity(newCapacity);
                        System.out.println("✓ Capacity updated successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter new manure quantity: ");
                    int newManure = scanner.nextInt();
                    scanner.nextLine();
                    storage.setManureQuantity(newManure);
                    break;

                case 3:
                    System.out.print("Enter new capacity: ");
                    newCapacity = scanner.nextInt();
                    System.out.print("Enter new manure quantity: ");
                    newManure = scanner.nextInt();
                    scanner.nextLine();

                    if (newCapacity < storage.getCurrentStock()) {
                        System.out.println("✗ Cannot reduce capacity below current stock!");
                    } else {
                        storage.setCapacity(newCapacity);
                        storage.setManureQuantity(newManure);
                        System.out.println("✓ Storage updated successfully!");
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        } else {
            System.out.println("\n✗ Storage with ID " + id + " not found!");
        }
    }

    // Select and manage a specific storage
    public void manageStorageProducts() {
        System.out.println("\n=== SELECT STORAGE ===");
        displayAllStorages();

        System.out.print("\nEnter storage ID to manage: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (storages.containsKey(id)) {
            Storage storage = storages.get(id);
            manageProductsInStorage(storage);
        } else {
            System.out.println("\n✗ Storage with ID " + id + " not found!");
        }
    }

    // Manage products inside a specific storage
    private void manageProductsInStorage(Storage storage) {
        while (true) {
            System.out.println("\n=== MANAGING STORAGE ID: " + storage.getStorageId() + " ===");
            storage.displayStorageInfo();

            System.out.println("\n--- PRODUCT MANAGEMENT ---");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Edit Product");
            System.out.println("4. View All Products");
            System.out.println("5. Search Product");
            System.out.println("6. Update Manure Quantity");
            System.out.println("7. Check Manure Quantity");
            System.out.println("8. Back to Main Menu");
            System.out.print("\nEnter your choice (1-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProductToStorage(storage);
                    break;
                case 2:
                    deleteProductFromStorage(storage);
                    break;
                case 3:
                    editProductInStorage(storage);
                    break;
                case 4:
                    storage.displayProducts();
                    System.out.print("\nPress Enter to continue...");
                    scanner.nextLine();
                    break;
                case 5:
                    searchProductInStorage(storage);
                    break;
                case 6:
                    updateManureInStorage(storage);
                    break;
                case 7:
                    checkManureQuantity(storage);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("✗ Invalid choice!");
            }
        }
    }

    private void addProductToStorage(Storage storage) {
        System.out.println("\n=== ADD PRODUCT TO STORAGE ===");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(name, quantity);
        storage.addProduct(product);

        if (storage.getProducts().containsKey(product.getProductId())) {
            System.out.println("Product ID: " + product.getProductId());
        }
    }

    private void deleteProductFromStorage(Storage storage) {
        System.out.println("\n=== DELETE PRODUCT FROM STORAGE ===");
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        storage.removeProduct(productId);
    }

    private void editProductInStorage(Storage storage) {
        System.out.println("\n=== EDIT PRODUCT IN STORAGE ===");
        System.out.print("Enter product ID to edit: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = storage.searchProduct(productId);
        if (product != null) {
            System.out.println("\nCurrent product details:");
            System.out.println(product);

            System.out.print("\nEnter new name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine();

            storage.editProduct(productId, newName, newQuantity);
        } else {
            System.out.println("✗ Product not found!");
        }
    }

    private void searchProductInStorage(Storage storage) {
        System.out.println("\n=== SEARCH PRODUCT ===");
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = storage.searchProduct(productId);
        if (product != null) {
            System.out.println("\n✓ Product found:");
            System.out.println(product);
        } else {
            System.out.println("\n✗ Product not found in this storage!");
        }
    }

    private void updateManureInStorage(Storage storage) {
        System.out.println("\n=== UPDATE MANURE QUANTITY ===");
        System.out.print("Enter new manure quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        storage.updateManureQuantity(quantity);
    }

    private void checkManureQuantity(Storage storage) {
        System.out.println("\n=== CHECK MANURE QUANTITY ===");
        System.out.println("Storage ID: " + storage.getStorageId());
        System.out.println("Current manure quantity: " + storage.getManureQuantity());
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    // Display all storages
    public void displayAllStorages() {
        System.out.println("\n=== ALL STORAGES ===");
        if (storages.isEmpty()) {
            System.out.println("No storages found!");
        } else {
            System.out.println("Total storages: " + storages.size());
            System.out.println("-------------------");
            for (Storage storage : storages.values()) {
                System.out.printf("Storage ID: %d | Capacity: %d | Current Stock: %d | Products: %d%n",
                                storage.getStorageId(),
                                storage.getCapacity(),
                                storage.getCurrentStock(),
                                storage.getProducts().size());
            }
        }
    }

    // Search storage by ID
    public void searchStorage() {
        System.out.println("\n=== SEARCH STORAGE ===");
        System.out.print("Enter storage ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (storages.containsKey(id)) {
            storages.get(id).displayStorageInfo();
        } else {
            System.out.println("\n✗ Storage with ID " + id + " not found!");
        }
    }

    // Method to handle storage management menu
    public void manageStorages() {
        while (true) {
            System.out.println("\n=== STORAGE MANAGEMENT ===");
            System.out.println("1. Add Storage");
            System.out.println("2. Delete Storage");
            System.out.println("3. Edit Storage");
            System.out.println("4. View All Storages");
            System.out.println("5. Search Storage");
            System.out.println("6. Manage Storage Products");
            System.out.println("7. Back to Main Menu");
            System.out.print("\nEnter your choice (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStorage();
                    break;
                case 2:
                    deleteStorage();
                    break;
                case 3:
                    editStorage();
                    break;
                case 4:
                    displayAllStorages();
                    break;
                case 5:
                    searchStorage();
                    break;
                case 6:
                    manageStorageProducts();
                    break;
                case 7:
                    return; // Back to main menu
                default:
                    System.out.println("\n✗ Invalid choice! Please try again.");
            }
        }
    }
}