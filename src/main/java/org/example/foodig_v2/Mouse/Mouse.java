package org.example.foodig_v2.Mouse;

public class Mouse {
    protected String name;
    protected int coinGenerateSpeed;
    protected double satiety;
    public static boolean isPoison;

    public Mouse(String name, int coinGenerateSpeed, double satiety, boolean isPoison) {
        this.name = name;
        this.coinGenerateSpeed = coinGenerateSpeed;
        this.satiety = satiety;
        this.isPoison = isPoison;
    }

    public String getName() { return name; }

    public String getImagePath() {
        return null;
    }

    public int getCoinGenerateSpeed() {
        return coinGenerateSpeed;
    }

    public double getSatiety() {
        return satiety;
    }

    public static boolean isPoison() {
        return isPoison;
    }

    public void setPoison(boolean poison) {
        isPoison = poison;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    public void subSatiety(double satiety) {
        double tempSatiety = getSatiety() - satiety;
        this.satiety = Math.max(tempSatiety, 1.0);
    }

    public void addSatiety(double satiety) {
        if (this.getSatiety() < 1.5) {
            this.satiety += satiety;
        } else {
            System.out.println("Mouse is full up.");
        }
    }

}
