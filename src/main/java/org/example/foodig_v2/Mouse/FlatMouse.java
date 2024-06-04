package org.example.foodig_v2.Mouse;

public class FlatMouse extends Mouse {
    private String imagePath = "org/example/foodig_v2/image/mouse2.png";
    public FlatMouse() {
        super("FlatMouse", 12, 1.2, false);
    }
    @Override
    public String getImagePath() {
        return imagePath;
    }
}
