package org.example.foodig_v2;

import javafx.scene.control.Button;
import org.example.foodig_v2.Mouse.*;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

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
        if (!PetMouse.ispoison()) {
            mousecoin += (int)(PetMouse.getCoinGenerateSpeed() * PetMouse.getSatiety());
        }
    }

    static public void AquireCoin(){
        Coin += mousecoin;
    }
    public void CheckPosioned(){

    }

    public static void addFeed() {
        Feed += 1;
    }

    public static void feedExpiredFood() {
        PetMouse.setPoison(true);
        poisonTimer();
        System.out.println(PetMouse.ispoison());
    }

    public static void feedFood() {
        Feed -= 1;
        System.out.println("Feed: " + Feed);
        PetMouse.addSatiety(0.1);
        SatietyTimer();
        System.out.println(PetMouse.getSatiety());
    }

    public static void poisonTimer() {
        System.out.println(PetMouse.ispoison());

//        long duration = 8; // Set duration in hours
//        long durationInMillis = TimeUnit.HOURS.toMillis(duration);

        long duration = 15; // Set duration in seconds
        long durationInMillis = TimeUnit.SECONDS.toMillis(duration);
        ScheduledExecutorService executor = newSingleThreadScheduledExecutor();
        executor.schedule(() -> PetMouse.setPoison(false), durationInMillis, TimeUnit.MILLISECONDS);
        executor.shutdown(); // Gracefully shutdown the executor after scheduling
    }

    public static void SatietyTimer() {

//        long duration = 8; // Set duration in hours
//        long durationInMillis = TimeUnit.HOURS.toMillis(duration);

        long duration = 15; // Set duration in seconds
        long durationInMillis = TimeUnit.SECONDS.toMillis(duration);
        ScheduledExecutorService executor = newSingleThreadScheduledExecutor();
        executor.schedule(() -> PetMouse.subSatiety(0.1), durationInMillis, TimeUnit.MILLISECONDS);
        executor.shutdown(); // Gracefully shutdown the executor after scheduling
    }
}
