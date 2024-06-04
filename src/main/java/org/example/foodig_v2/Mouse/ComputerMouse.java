package org.example.foodig_v2.Mouse;

public class ComputerMouse extends Mouse {
    private String imagePath = "org/example/foodig_v2/image/mouse3.png";
    public ComputerMouse() {
        super("ComputerMouse", 16, 1.0, false);
    }
    @Override
    public String getImagePath() {
        return imagePath;
    }
}
