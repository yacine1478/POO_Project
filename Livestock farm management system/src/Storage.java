import java.util.*;

// Storage Class
class Storage {
    private int storageId;
    private int capacity;
    private int currentStock;
    private int manureQuantity;
    private HashMap<Integer, Product> products; // productId -> Product

    public Storage(int capacity) {
        this.storageId = generateRandomId();
        this.capacity = capacity;
        this.currentStock = 0;
        this.manureQuantity = 0;
        this.products = new HashMap<>();
    }

    private int generateRandomId() {
        Random rand = new Random();
        return 1000 + rand.nextInt(9000); // IDs from 1000 to 9999
    }

    // Add product to storage
    public boolean addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with this ID already exists!");
            return false;
        }

        if (currentStock + product.getQuantity() > capacity) {
            System.out.println("Not enough capacity in storage!");
            System.out.println("Available capacity: " + (capacity - currentStock));
            return false;
        }

        products.put(product.getProductId(), product);
        currentStock += product.getQuantity();
        System.out.println("✓ Product added successfully!");
        return true;
    }

    // Remove product from storage
    public boolean removeProduct(int productId) {
        if (products.containsKey(productId)) {
            Product removed = products.remove(productId);
            currentStock -= removed.getQuantity();
            System.out.println("✓ Product removed successfully!");
            System.out.println("Removed product: " + removed.getName());
            return true;
        } else {
            System.out.println("✗ Product with ID " + productId + " not found!");
            return false;
        }
    }

    // Edit product
    public boolean editProduct(int productId, String newName, int newQuantity) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            int oldQuantity = product.getQuantity();

            // Check if new quantity fits in storage
            int quantityDifference = newQuantity - oldQuantity;
            if (currentStock + quantityDifference > capacity) {
                System.out.println("Not enough capacity for this update!");
                System.out.println("Available capacity: " + (capacity - currentStock));
                return false;
            }

            product.setName(newName);
            product.setQuantity(newQuantity);
            currentStock += quantityDifference;

            System.out.println("✓ Product updated successfully!");
            System.out.println("Updated product: " + product);
            return true;
        } else {
            System.out.println("✗ Product with ID " + productId + " not found!");
            return false;
        }
    }

    // Update manure quantity
    public void updateManureQuantity(int quantity) {
        this.manureQuantity = quantity;
        System.out.println("✓ Manure quantity updated to: " + manureQuantity);
    }

    // Display all products in storage
    public void displayProducts() {
        System.out.println("\n--- PRODUCTS IN STORAGE ---");
        if (products.isEmpty()) {
            System.out.println("No products in storage!");
        } else {
            System.out.println("Total products: " + products.size());
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }

    // Display storage info
    public void displayStorageInfo() {
        System.out.println("\n=== STORAGE INFORMATION ===");
        System.out.println("Storage ID: " + storageId);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Stock: " + currentStock);
        System.out.println("Available Space: " + (capacity - currentStock));
        System.out.println("Manure Quantity: " + manureQuantity);
        System.out.println("Products Count: " + products.size());
    }

    // Search product by ID
    public Product searchProduct(int productId) {
        return products.get(productId);
    }

    // Getters
    public int getStorageId() { return storageId; }
    public int getCapacity() { return capacity; }
    public int getCurrentStock() { return currentStock; }
    public int getManureQuantity() { return manureQuantity; }
    public HashMap<Integer, Product> getProducts() { return products; }

    // Setters
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setManureQuantity(int manureQuantity) { this.manureQuantity = manureQuantity; }
}