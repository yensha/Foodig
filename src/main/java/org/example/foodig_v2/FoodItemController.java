package org.example.foodig_v2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.foodig_v2.FoodStorage.*;

public class FoodItemController implements Initializable {
    @FXML
    private ImageView Imgview_Foodimg;

    @FXML
    private Label Date;

    @FXML
    private Label Label_Expdate;

    @FXML
    private Label Label_Foodname;

    @FXML
    private AnchorPane food_card;

    @FXML
    private ImageView ImageView_delete;

    private Food food;
    private FoodTableController foodTableController; // Reference to FoodTableController

    void setFoodTableController(FoodTableController foodTableController) {
        this.foodTableController = foodTableController;
    }

    void setfoodexpiredFoodsData(Food food){
        this.food = food;
        Label_Foodname.setText(food.getName());
        Label_Foodname.setStyle("-fx-text-fill: White");
        Date.setStyle("-fx-text-fill: White");
        Label_Expdate.setText(food.getExpirationDate().toString());
        Label_Expdate.setStyle("-fx-text-fill: White");
        Image image = new Image(String.valueOf(getClass().getResource(food.getImagePath())));
        Imgview_Foodimg.setImage(image);
        Imgview_Foodimg.setStyle("-fx-blend-mode: src-atop;");
        applyImageEffect(Imgview_Foodimg);
        food_card.setStyle(" -fx-background-color: linear-gradient(from 27.4232% 34.279% to 58.3924% 77.0686%, #70341c 0.0%, #3a7212 100.0%);"+ " -fx-padding: 5 0 0 0;" );
    }
    void setfoodexpiringFoodsData(Food food){
        this.food = food;
        Label_Foodname.setText(food.getName());
        Label_Expdate.setText(food.getExpirationDate().toString());
        Image image = new Image(String.valueOf(getClass().getResource(food.getImagePath())));
        Imgview_Foodimg.setImage(image);
        food_card.setStyle(" -fx-background-color: linear-gradient(from 0.0% 0.0% to 81.3239% 83.9243%, #ee5509 0.0%, #e5e227 100.0%);"+ " -fx-padding: 5 0 0 0;" );
    }
    void setfoodotherFoodsData(Food food){
        this.food = food;
        Label_Foodname.setText(food.getName());
        Label_Expdate.setText(food.getExpirationDate().toString());
        Image image = new Image(String.valueOf(getClass().getResource(food.getImagePath())));
        Imgview_Foodimg.setImage(image);
        food_card.setStyle(" -fx-background-color: linear-gradient(from 8.0378% 4.7281% to 81.3239% 80.6147%, #47e89d 0.0%, #77e7ed 100.0%);"+ " -fx-padding: 5 0 0 0;" );
    }
    private void applyImageEffect(ImageView imageView) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0.2);

        ColorInput colorInput = new ColorInput(0, 0, imageView.getFitWidth(), imageView.getFitHeight(), Color.web("#ffffff"));

        Blend blend = new Blend();
        blend.setMode(BlendMode.SRC_ATOP);
        blend.setTopInput(colorInput);
        blend.setBottomInput(colorAdjust);

        imageView.setEffect(blend);
    }

    @FXML
    private void handleDeleteImageClick(MouseEvent event) {
        System.out.println("Delete button clicked for food: " + food.getName()); // 确认点击事件触发

        deleteFood(food.getName()); // 删除食物项
        System.out.println("All Foods after deleting: " + getFoodsName()); // 确认食物被删除

        // 刷新列表
        if (foodTableController != null) {
            System.out.println("Refreshing list");
            foodTableController.loadFoodData();
        } else {
            System.out.println("foodTableController is null");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView_delete.addEventHandler(MouseEvent.MOUSE_CLICKED, this::handleDeleteImageClick);
        System.out.println("FoodItemController initialized"); // 确认初始化
    }

}
