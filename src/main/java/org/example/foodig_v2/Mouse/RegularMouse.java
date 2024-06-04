package org.example.foodig_v2.Mouse;

public class RegularMouse extends Mouse {
    private String imagePath = "org/example/foodig_v2/image/mouse1.png";
    public RegularMouse() {
        super("RegularMouse", 10, 1.0, false, "image/mouse1.png");
    }
    @Override
    public String getImagePath() {
        return imagePath;
    }
}
