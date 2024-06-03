package org.example.foodig_v2;

public class MouseFarm {
    static double Coin = 0; // Total Coin
    static int Feed = 0; // Mouse Food
    double mousecoin = 0.0;
    static Mouse PetMouse = new RegularMouse();

    public void updateMousetoFlatMouse() {
        PetMouse = new FlatMouse();
    }

    public void updateMousetoRichBurgerMouse() {
        PetMouse = new RichBurgerMouse();
    }

    public void updateMousetoComputerMouse() {
        PetMouse = new ComputerMouse();
    }
    public void GenerateCoin(){
        mousecoin += PetMouse.getCoinGenerateSpeed() * PetMouse.getSatiety();
    }
    public void AquireCoin(){
        Coin += mousecoin;
    }
    public void CheckPosioned(){

    }
}
