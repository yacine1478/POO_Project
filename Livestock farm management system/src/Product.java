import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Product Class
class Product {
    private int productId;
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.productId = generateRandomId();
        this.name = name;
        this.quantity = quantity;
    }

    private int generateRandomId() {
        Random rand = new Random();
        return 10000 + rand.nextInt(90000); // IDs from 10000 to 99999
    }

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("Product ID: %d | Name: %s | Quantity: %d",
                           productId, name, quantity);
    }
}