package org.example.foodig_v2;

public class Mouse {
    protected String name;
    protected int coin_generate_speed;
    protected double satiety;
    protected boolean isPoison;

    public String getName(){
        return name;
    }
    public int get_coin_generate_speed(){
        return coin_generate_speed;
    }

    public double get_satiety(){
        return satiety;
    }
    public Boolean get_IsPoison(){
        return isPoison;
    }
}
