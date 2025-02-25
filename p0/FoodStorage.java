package p0;

import java.util.ArrayList;
import java.time.LocalDate;

public class FoodStorage {
    private String name;
    private float temperature;
    private ArrayList<Food> expiredFoods;
    private ArrayList<Food> foods;
    private ArrayList<Food> expiringFoods;

    // Constructor
    public FoodStorage(String name, float temperature) {
        this.name = name;
        this.temperature = temperature;
        this.foods = new ArrayList<>();
        this.expiredFoods = new ArrayList<>();
        this.expiringFoods = new ArrayList<>();
    }

    // Method to add food
    public void addFood(String name, String type, LocalDate expirationDate, LocalDate manufacturedDate) {
        Food newFood = new Food(name, type, expirationDate, manufacturedDate);
        foods.add(newFood);
        reload(); // Reload expired and expiring foods after adding new food
    }

    // Method to delete food by name
    public void deleteFood(String name) {
        foods.removeIf(food -> food.getName().equals(name));
        reload(); // Reload expired and expiring foods after deleting food
    }

    // Method to reload all lists
    public void reload() {
        reloadExpiredFoods();
        reloadExpiringFoods();
    }

    // Method to reload expired foods list
    public void reloadExpiredFoods() {
        expiredFoods.clear();
        for (Food food : foods) {
            food.checkExpired();
            if (food.isExpired()) {
                expiredFoods.add(food);
            }
        }
    }

    // Method to reload expiring foods list
    public void reloadExpiringFoods() {
        expiringFoods.clear();
        for (Food food : foods) {
            food.checkExpiring();
            if (food.isExpiring() && !food.isExpired()) {
                expiringFoods.add(food);
            }
        }
    }

    // Method to delete expired foods
    public void deleteExpiredFoods() {
        foods.removeIf(Food::isExpired);
        reload(); // Reload expired and expiring foods after deleting expired foods
    }

    // Method to get today date
    public LocalDate getTodayDate() {
        return LocalDate.now();
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public float getTemperature() {
        return temperature;
    }

    // maybe need more for foods' name
    public ArrayList<String> getFoods() {
        return getFoodNames(foods);
    }
    
    public ArrayList<String> getExpiredFoods() {
        return getFoodNames(expiredFoods);
    }

    public ArrayList<String> getExpiringFoods() {
        return getFoodNames(expiringFoods);
    }

    public ArrayList<String> getFoodNames(ArrayList<Food> foods) {
        ArrayList<String> foodNames = new ArrayList<>();
        for (Food food : foods) {
            foodNames.add(food.getName());
        }
        return foodNames;
    }

    // Main method for testing
    public static void main(String[] args) {
        FoodStorage storage = new FoodStorage("My Storage", 5.0f);
        
        LocalDate expirationDate0 = LocalDate.of(2024, 05, 17);
        LocalDate expirationDate1 = LocalDate.of(2024, 05, 15);
        LocalDate expirationDate2 = LocalDate.of(2024, 05, 13);
        LocalDate manufacturedDate = LocalDate.of(2024, 05, 10);
        // Add some foods
        storage.addFood("Apple", "Fruit", expirationDate0, manufacturedDate);
        storage.addFood("Banana", "Fruit", expirationDate1, manufacturedDate);
        storage.addFood("Cheese", "Dairy", expirationDate2, manufacturedDate);
        
        // Display foods
        System.out.println("All Foods: " + storage.getFoods());
        System.out.println("Expired Foods: " + storage.getExpiredFoods());
        System.out.println("Expiring Foods: " + storage.getExpiringFoods());
        
        // Delete expired foods
        storage.deleteExpiredFoods();
        
        // Display foods after deleting expired foods
        System.out.println("All Foods after deleting expired foods: " + storage.getFoods());
        System.out.println("Expired Foods after deletion: " + storage.getExpiredFoods());
        System.out.println("Expiring Foods after deletion: " + storage.getExpiringFoods());
    }
}
