package org.example.foodig_v2.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.foodig_v2.Food;

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

    void setfoodData(Food foods){
        this.food = foods;
        Label_Foodname.setText(foods.getName());
        //Label_Expdate.setText(foods.getExpirationDate());
        //Image image = new Image(getClass().getResourceAsStream(foods.getImgSrc));
        //Imgview_Foodimg.setImage(image);

    }
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
