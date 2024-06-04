package org.example.foodig_v2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class FoodItemController implements Initializable {
    @FXML
    private ImageView Imgview_Foodimg;

    @FXML
    private Label Label_Expdate;

    @FXML
    private Label Label_Foodname;

    private Food food;

    void setfoodData(Food food){
        this.food = food;
        Label_Foodname.setText(food.getName());
        Label_Expdate.setText(food.getExpirationDate().toString());
        Image image = new Image(String.valueOf(getClass().getResource(food.getImagePath())));
        Imgview_Foodimg.setImage(image);

    }
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
