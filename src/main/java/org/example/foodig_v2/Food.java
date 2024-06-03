package org.example.foodig_v2;

import java.time.LocalDate;

public class Food {
    private String name;
    private String type;
    private LocalDate expirationDate;
    private LocalDate manufacturedDate;
    private boolean expiring;
    private boolean expired;
    private String remark;

    // Constructor
    public Food(String name, String type, LocalDate expirationDate, LocalDate manufacturedDate) {
        this.name = name;
        this.type = type;
        this.expirationDate = expirationDate;
        this.manufacturedDate = manufacturedDate;
        this.expiring = false;
        this.expired = false;
        this.remark = "";
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
    }

    // Method to change the name of food
    public void setName(String newName) {
        this.name = newName;
    }

    // Method to change the remark of food
    public void setRemark(String newRemark) { this.remark = newRemark; }

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

    public static void main(String[] args) {
        LocalDate expirationDate = LocalDate.of(2024, 05, 13);
        LocalDate manufacturedDate = LocalDate.of(2024, 05, 10);

        Food Carrot = new Food("Carrot", "Fruit", expirationDate, manufacturedDate);

        Carrot.setRemark("Yeh");

        System.out.println(Carrot.getRemark());
        System.out.println(Carrot.getExpirationDate());
    }
}
