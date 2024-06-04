package org.example.foodig_v2;

import org.example.foodig_v2.Mouse.*;

public class MouseFarm {
    static public double Coin = 0; // Total Coin
    static public int Feed = 0; // Mouse Food
    static double mousecoin = 0.0;
    static public Mouse PetMouse = new RegularMouse();

    public static void updateMousetoFlatMouse() {
        PetMouse = new FlatMouse();
    }

    public static void updateMousetoRichBurgerMouse() {
        PetMouse = new RichBurgerMouse();
    }

    public static void updateMousetoComputerMouse() {
        PetMouse = new ComputerMouse();
    }
    public static void GenerateCoin(){
        mousecoin += PetMouse.getCoinGenerateSpeed() * PetMouse.getSatiety();
    }
    static public void AquireCoin(){
        Coin += mousecoin;
    }
    public void CheckPosioned(){

    }
}
