package org.example.foodig_v2.Mouse;

public class Mouse {
    private String name;
    private int coinGenerateSpeed;
    private double satiety;
    private boolean isPoison;
    private String imagePath;
    private int price;

    public Mouse(String name, int coinGenerateSpeed, double satiety, boolean isPoison, String imagePath, int price) {
        this.name = name;
        this.coinGenerateSpeed = coinGenerateSpeed;
        this.satiety = satiety;
        this.isPoison = isPoison;
        this.imagePath = imagePath;
        this.price = price;
    }

    public String getName() { return name; }

    public String getImagePath() {
        return imagePath;
    }

    public int getCoinGenerateSpeed() {
        return coinGenerateSpeed;
    }

    public double getSatiety() {
        return satiety;
    }

    public boolean ispoison() {
        return isPoison;
    }

    public void setPoison(boolean poison) {
        isPoison = poison;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }
    public int getPrice(){ return price;}

    public void subSatiety(double satiety, double satietySave) {
        if (getSatiety() == satietySave) {
            double tempSatiety = getSatiety() - satiety;
            this.satiety = Math.max(tempSatiety, 1.0);
        }

        System.out.println(getSatiety());
    }

    public void subSatiety(double satiety) {
        double tempSatiety = getSatiety() - satiety;
        this.satiety = Math.max(tempSatiety, 1.0);

        System.out.println(getSatiety());
    }

    public void addSatiety(double satiety) {
        if (this.getSatiety() < 1.5) {
            this.satiety += satiety;
        } else {
            System.out.println("Mouse is full up.");
        }
    }

}
