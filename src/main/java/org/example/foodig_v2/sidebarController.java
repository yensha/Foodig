package org.example.foodig_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.io.IOException;

import static org.example.foodig_v2.FoodStorage.reload;

public class sidebarController implements Initializable {

    @FXML
    private ImageView sidebar;

    @FXML
    private ImageView MouseImage;

    @FXML
    private AnchorPane side_pane;


    @FXML
    private Button Homebtn;

    @FXML
    private Button Foodbtn;

    @FXML
    private Button Mousebtn;

    @FXML
    private Button AddFoodbtn;

    @FXML
    private Button Settingbtn;

    @FXML
    private Button Shopbtn;


    @FXML
    private Label Mouse_Name;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    private SceneController scene_controller;
    private ArrayList<Food> expiredFoods = new ArrayList<>();
    private ArrayList<Food> expiringFoods = new ArrayList<>();
    private ArrayList<Food> otherFoods = new ArrayList<>();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scene_controller = new SceneController();
        side_pane.setVisible(false);

        sidebar.setOnMouseClicked(event -> {
            side_pane.setVisible(true);
        });
        scroll.setOnMouseClicked(event -> {
            side_pane.setVisible(false);
        });
        Mouse_Name.setText(MouseFarm.PetMouse.getName());
        Mouse_Name.setStyle("-fx-font-size: 18;"+" -fx-alignment: center;");
        Image image = new Image(String.valueOf(getClass().getResource(MouseFarm.PetMouse.getImagePath())));
        MouseImage.setImage(image);

        loadFoodData();
        reload(); // reload all food
    }

    public void loadFoodData() {
        expiredFoods.clear();
        expiringFoods.clear();
        otherFoods.clear();

        expiredFoods.addAll(FoodStorage.getExpiredFoods());
        expiringFoods.addAll(FoodStorage.getExpiringFoods());
        otherFoods.addAll(FoodStorage.getOtherFoods());

        int column = 0, row = 1;

        grid.getChildren().clear(); // Clear existing items from the grid

        // Add labels for each category
        addCategoryLabel("Expired Food", column, row++);
        row = addFoodItemsToGrid(expiredFoods, column, row, "expired");

        row++; // Skip a row for spacing

        addCategoryLabel("Expiring Food", column, row++);
        row = addFoodItemsToGrid(expiringFoods, column, row, "expiring");

        row++; // Skip a row for spacing

        addCategoryLabel("Other Food", column, row++);
        addFoodItemsToGrid(otherFoods, column, row, "other");
    }

    private void addCategoryLabel(String labelText, int column, int row) {
        Label label = new Label(labelText);
        label.setFont(Font.font("System", FontWeight.BOLD, 18));
        grid.add(label, column, row);
        GridPane.setMargin(label, new Insets(10, 10, 10, 10));
    }

    private int addFoodItemsToGrid(ArrayList<Food> foods, int column, int row, String type) {
        try {
            for (Food food : foods) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("food-item.fxml"));
                AnchorPane pane = fxmlLoader.load();
                FoodItemController itemController = fxmlLoader.getController();
                itemController.setSidebarController(this);

                switch (type) {
                    case "expired":
                        itemController.setfoodexpiredFoodsData(food);
                        break;
                    case "expiring":
                        itemController.setfoodexpiringFoodsData(food);
                        break;
                    case "other":
                        itemController.setfoodotherFoodsData(food);
                        break;
                }
                grid.add(pane, column, row++);
                GridPane.setMargin(pane, new Insets(10, 10, 10, 10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return row;
    }



    @FXML
    private void TurntoHome(ActionEvent event)  {
        try {
            scene_controller.switchToStart(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void TurntoFood(MouseEvent event) {
        try {
            scene_controller.switchToFood(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void TurntoMouse(ActionEvent event) {
        try {
            scene_controller.switchToMouse(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void TurntoSetting(ActionEvent event) {
        try {
            scene_controller.switchToSetting(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void TurntoAddFoodbtn(MouseEvent event) throws IOException {
        scene_controller.switchToAddFood(event);
    }
    @FXML
    private void TurntoShop(MouseEvent event) throws IOException {
        scene_controller.switchToShop(event);
    }
}
