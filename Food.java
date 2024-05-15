package p0;

import java.time.LocalDate;

public class Food {
    private String name;
    private String type;
    private LocalDate expirationDate;
    private LocalDate manufacturedDate;
    private boolean expiring;
    private boolean expired;

    // Constructor
    public Food(String name, String type, LocalDate expirationDate, LocalDate manufacturedDate) {
        this.name = name;
        this.type = type;
        this.expirationDate = expirationDate;
        this.manufacturedDate = manufacturedDate;
        this.expiring = false;
        this.expired = false;
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
}
