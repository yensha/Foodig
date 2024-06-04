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
    private static final long TOTAL_DURATION_HOURS = 8;
    private static final double MAX_COIN = PetMouse.getCoinGenerateSpeed() * PetMouse.getSatiety() *TOTAL_DURATION_HOURS;
    private static final double COIN_PER_SECOND = MAX_COIN / (TOTAL_DURATION_HOURS );

    public static void updateMousetoFlatMouse() {
        PetMouse = new FlatMouse();
    }

    public static void updateMousetoRichBurgerMouse() {
        PetMouse = new RichBurgerMouse();
    }

    public static void updateMousetoComputerMouse() {
        PetMouse = new ComputerMouse();
    }

    public static void startCoinGeneration() {
        ScheduledExecutorService executor = newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (!PetMouse.ispoison() && mousecoin < MAX_COIN) {
                mousecoin += COIN_PER_SECOND;
                if (mousecoin > MAX_COIN) {
                    mousecoin = MAX_COIN;
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    static public void AquireCoin(){
        Coin += mousecoin;
        mousecoin = 0;
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
