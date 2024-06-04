package org.example.foodig_v2;

import java.util.ArrayList;
import java.time.LocalDate;

import static org.example.foodig_v2.MouseFarm.feedExpiredFood;
import static org.example.foodig_v2.MouseFarm.addFeed;

// static!!!!!!!!!!

public class FoodStorage {
    private static ArrayList<Food> foods = new ArrayList<>();;
    private static ArrayList<Food> expiredFoods = new ArrayList<>();;
    private static ArrayList<Food> expiringFoods = new ArrayList<>();;
    private static ArrayList<Food> otherFoods = new ArrayList<>();;

    // Method to add food
    public static void addFood(String name, String type, LocalDate expirationDate, LocalDate manufacturedDate, String remark) {
        Food newFood = new Food(name, type, expirationDate, manufacturedDate, remark);
        foods.add(newFood);
        reload(); // Reload expired and expiring foods after adding new food
    }

    // Method to delete food by name
    public static void deleteFood(String name) {
        if (foods.stream().filter(obj -> obj.getName().equals(name))
                .findFirst()
                .orElse(null)  // Object not found
                .isExpired()) {
            feedExpiredFood();
        } else {
            addFeed();
        }
        foods.removeIf(food -> food.getName().equals(name));
        reload(); // Reload expired and expiring foods after deleting food
    }

    // Method to reload all lists
    public static void reload() {
        reloadExpiredFoods();
        reloadExpiringFoods();
        reloadOtherFoods();
    }

    // Method to reload expired foods list
    public static void reloadExpiredFoods() {
        expiredFoods.clear();
        for (Food food : foods) {
            food.checkExpired();
            if (food.isExpired()) {
                expiredFoods.add(food);
            }
        }
    }

    // Method to reload expiring foods list
    public static void reloadExpiringFoods() {
        expiringFoods.clear();
        for (Food food : foods) {
            food.checkExpiring();
            if (food.isExpiring() && !food.isExpired()) {
                expiringFoods.add(food);
            }
        }
    }

    // Method to reload other foods list
    public static void reloadOtherFoods() {
        otherFoods.clear();
        for (Food food : foods) {
            food.checkExpired();
            food.checkExpiring();
            if (!food.isExpired() && !food.isExpiring()) {
                otherFoods.add(food);
            }
        }
    }

    // Method to delete expired foods
    public static void deleteExpiredFoods() {
        foods.removeIf(Food::isExpired);
        reload(); // Reload expired and expiring foods after deleting expired foods
    }

    // Method to get today date
    public static LocalDate getTodayDate() {
        return LocalDate.now();
    }

    public static ArrayList<Food> getFoods() {
        return foods;
    }
    public static ArrayList<Food> getExpiredFoods() {
        return expiredFoods;
    }
    public static ArrayList<Food> getExpiringFoods() {
        return expiringFoods;
    }
    public static ArrayList<Food> getOtherFoods() {
        return otherFoods;
    }
    // maybe need more for foods' name
    public static ArrayList<String> getFoodsName() {
        return getFoodNames(foods);
    }
    public static ArrayList<String> getExpiredFoodsName() {
        return getFoodNames(expiredFoods);
    }
    public static ArrayList<String> getExpiringFoodsName() {
        return getFoodNames(expiringFoods);
    }
    public static ArrayList<String> getOtherFoodsName() {
        return getFoodNames(otherFoods);
    }

    public static ArrayList<String> getFoodNames(ArrayList<Food> foods) {
        ArrayList<String> foodNames = new ArrayList<>();
        for (Food food : foods) {
            foodNames.add(food.getName());
        }
        return foodNames;
    }

    // Main method for testing
    public static void main(String[] args) {

        LocalDate expirationDate0 = LocalDate.of(2024, 6, 17);
        LocalDate expirationDate1 = LocalDate.of(2024, 6, 4);
        LocalDate expirationDate2 = LocalDate.of(2024, 5, 13);
        LocalDate manufacturedDate = LocalDate.of(2024, 5, 10);
        // Add some foods
        addFood("Apple", "Fruit", expirationDate0, manufacturedDate, "");
        addFood("Banana", "Fruit", expirationDate1, manufacturedDate, "");
        addFood("Cheese", "Dairy", expirationDate2, manufacturedDate, "");

        // Display foods
        System.out.println("All Foods: " + getFoodsName());
        System.out.println("Expired Foods: " + getExpiredFoodsName());
        System.out.println("Expiring Foods: " + getExpiringFoodsName());
        System.out.println("Other Foods: " + getOtherFoodsName());

        deleteFood("Apple");
        // Delete expired foods
        deleteExpiredFoods();

        // Display foods after deleting expired foods
        System.out.println("All Foods after deleting expired foods: " + getFoodsName());
        System.out.println("Expired Foods after deletion: " + getExpiredFoodsName());
        System.out.println("Expiring Foods after deletion: " + getExpiringFoodsName());
        System.out.println("Other Foods after deletion:: " + getOtherFoodsName());
    }
}
