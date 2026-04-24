public class Animal {

    private int id;
    private String type;     // Cow, Sheep, Goat...
    private int age;
    private double weight;
    private String healthStatus;

    public Animal(int id, String type, int age, double weight, String healthStatus) {
        this.id = id;
        this.type = type;
        this.age = age;
        this.weight = weight;
        this.healthStatus = healthStatus;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Type: " + type +
                " | Age: " + age +
                " | Weight: " + weight +
                " | Health: " + healthStatus;
    }
}