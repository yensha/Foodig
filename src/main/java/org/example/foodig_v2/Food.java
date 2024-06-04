package org.example.foodig_v2;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class Food {
    private String name;
    private String type;
    private LocalDate expirationDate;
    private LocalDate manufacturedDate;
    private boolean expiring;
    private boolean expired;
    private String remark;
    private String imagePath;

    // Constructor
    public Food(String name, String type, LocalDate expirationDate, LocalDate manufacturedDate, String remark) {
        this.name = name;
        this.type = type;
        this.expirationDate = expirationDate;
        this.manufacturedDate = manufacturedDate;
        this.expiring = false;
        this.expired = false;
        this.remark = remark;
//        this.imagePath = imagePath; "全穀雜糧", "豆魚蛋肉", "蔬菜", "水果", "乳品", "調味料"
        switch (type) {
            case "全穀雜糧" -> this.imagePath = "src/main/resources/org/example/foodig_v2/image/rice.png";
            case "豆魚蛋肉" -> this.imagePath = "src/main/resources/org/example/foodig_v2/image/protein.png";
            case "蔬菜" -> this.imagePath = "src/main/resources/org/example/foodig_v2/image/vegetable.png";
            case "水果" -> this.imagePath = "src/main/resources/org/example/foodig_v2/image/fruits.png";
            case "乳品" -> this.imagePath = "src/main/resources/org/example/foodig_v2/image/dairy-products.png";
            case "調味料" -> this.imagePath = "src/main/resources/org/example/foodig_v2/image/spices.png";
            default -> this.imagePath = "src/main/resources/org/example/foodig_v2/food-service.png";
        }
        reloadExpiredAndExpiring();
    }

    public void reloadExpiredAndExpiring() {
        checkExpired();
        checkExpiring();
    }

    // Method to check if the food is expired
    public void checkExpired() {
        if (expirationDate != null) {
            LocalDate today = LocalDate.now();
            if (today.isAfter(expirationDate)) {
                expired = true;
            }
            else {
                expired = false;
            }
        }
        else {
            expired = false;
        }
    }

    // Method to check if the food is expiring soon(three days after)
    public void checkExpiring() {
        if (expirationDate != null) {
            LocalDate today = LocalDate.now();
            LocalDate threeDaysAfter = today.plusDays(3);
            if (threeDaysAfter.isAfter(expirationDate)) {
                expiring = true;
            } else {
                expiring = false;
            }
        }
        else {
            expiring = false;
        }
    }

    // Method to change the manufactured date
    public void setManufacturedDate(LocalDate newManufacturedDate) {
        this.manufacturedDate = newManufacturedDate;
    }

    // Method to change the expiration date
    public void setExpirationDate(LocalDate newExpirationDate) {
        this.expirationDate = newExpirationDate;
    }

    // Method to change the type of food
    public void setType(String newType) {
        this.type = newType;
        switch (newType) {
            case "全穀雜糧" -> this.imagePath = "image/rice.png";
            case "豆魚蛋肉" -> this.imagePath = "image/protein.png";
            case "蔬菜" -> this.imagePath = "image/vegetable.png";
            case "水果" -> this.imagePath = "image/fruits.png";
            case "乳品" -> this.imagePath = "image/dairy-products.png";
            case "調味料" -> this.imagePath = "image/spices.png";
            default -> this.imagePath = "image/food-service.png";
        }
    }

    // Method to change the name of food
    public void setName(String newName) {
        this.name = newName;
    }

    // Method to change the remark of food
    public void setRemark(String newRemark) { this.remark = newRemark; }

    // Method to change the image of food
    public void setImagePath(String newImagePath) {
        this.imagePath = newImagePath;
    }

    // Getter methods
    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean isExpired() {
        return expired;
    }

    public boolean isExpiring() {
        return expiring;
    }

    public String getRemark() { return remark; }

    public String getImagePath() { return imagePath; }

    public static void main(String[] args) {
        LocalDate expirationDate = LocalDate.of(2024, 5, 13);
        LocalDate manufacturedDate = LocalDate.of(2024, 5, 10);

        Food Carrot = new Food("Carrot", "水果", expirationDate, manufacturedDate, "");

        Carrot.setRemark("Yeh");

        System.out.println(Carrot.getRemark());
        System.out.println(Carrot.getExpirationDate());
        System.out.println(Carrot.getImagePath());
    }
}
