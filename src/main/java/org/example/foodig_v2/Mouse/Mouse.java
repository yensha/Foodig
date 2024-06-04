package org.example.foodig_v2.Mouse;

public class Mouse {
    protected String name;
    protected int coinGenerateSpeed;
    protected double satiety;
    protected boolean isPoison;

    public Mouse(String name, int coinGenerateSpeed, double satiety, boolean isPoison) {
        this.name = name;
        this.coinGenerateSpeed = coinGenerateSpeed;
        this.satiety = satiety;
        this.isPoison = isPoison;
    }

    public String getName() {
        return name;
    }

    public int getCoinGenerateSpeed() {
        return coinGenerateSpeed;
    }

    public double getSatiety() {
        return satiety;
    }

    public boolean isPoison() {
        return isPoison;
    }
}
