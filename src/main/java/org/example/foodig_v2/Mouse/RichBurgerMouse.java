package org.example.foodig_v2.Mouse;

public class RichBurgerMouse extends Mouse {
    private String imagePath = "org/example/foodig_v2/image/burgermouse.png";
    public RichBurgerMouse() {
        super("RichBurgerMouse", 20, 1.5, false);
    }
    @Override
    public String getImagePath() {
        return imagePath;
    }
}
