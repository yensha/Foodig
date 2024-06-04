package org.example.foodig_v2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.example.foodig_v2.FoodStorage.reload;

public class FoodTableController implements Initializable {
    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    @FXML
    private ImageView back;
    private SceneController scenecontroller;
    private ArrayList<Food> expiredFoods = new ArrayList<>();
    private ArrayList<Food> expiringFoods = new ArrayList<>();
    private ArrayList<Food> otherFoods = new ArrayList<>();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        scenecontroller = new SceneController();
        expiredFoods.addAll(FoodStorage.getExpiredFoods());
        expiringFoods.addAll(FoodStorage.getExpiringFoods());
        otherFoods.addAll(FoodStorage.getOtherFoods());
        int column = 0, row = 1;

        // Add labels for each category
        addCategoryLabel("Expired Food", column, row++);
        row = addFoodItemsToGrid(expiredFoods, column, row, "expired");

        row++; // Skip a row for spacing

        addCategoryLabel("Expiring Food", column, row++);
        row = addFoodItemsToGrid(expiringFoods, column, row, "expiring");

        row++; // Skip a row for spacing

        addCategoryLabel("Other Food", column, row++);
        addFoodItemsToGrid(otherFoods, column, row, "other");

        reload(); // reload all food
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

    public void BacktoMenu(MouseEvent event) throws IOException {
        scenecontroller.switchToMenu(event);
    }
}
