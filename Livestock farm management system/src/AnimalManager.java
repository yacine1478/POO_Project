import java.util.ArrayList;

public class AnimalManager {

    private ArrayList<Animal> animals = new ArrayList<>();

    // ➕ Add Animal
    public void addAnimal(Animal a) {
        animals.add(a);
        System.out.println("Animal added successfully");
    }

    // 📋 Show Animals
    public void showAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals found");
            return;
        }

        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    // 🔍 Search
    public void searchAnimal(int id) {
        for (Animal a : animals) {
            if (a.getId() == id) {
                System.out.println("Found: " + a);
                return;
            }
        }
        System.out.println("Animal not found");
    }

    // ❌ Delete
    public void deleteAnimal(int id) {
        animals.removeIf(a -> a.getId() == id);
        System.out.println("Animal deleted if existed");
    }

    // ✏️ Update
    public void updateAnimal(int id, String newType, String newHealth) {
        for (Animal a : animals) {
            if (a.getId() == id) {
                a.setType(newType);
                a.setHealthStatus(newHealth);
                System.out.println("Animal updated");
                return;
            }
        }
        System.out.println("Animal not found");
    }
}