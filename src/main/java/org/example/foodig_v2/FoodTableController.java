package org.example.foodig_v2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javafx.scene.input.MouseEvent;


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
    private ArrayList<Food> foods = new ArrayList<>();

    public void initialize(URL url, ResourceBundle resourceBundle) {

        scenecontroller = new SceneController();
        foods.addAll(FoodStorage.getFoods());
        int column = 0, row = 0;
        try {
            for(int i = 0; i < foods.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("food-item.fxml"));
                AnchorPane pane = fxmlLoader.load();

                FoodItemController itemController = fxmlLoader.getController();
                itemController.setfoodData(foods.get(i));
                grid.add(pane, column, row++);
                GridPane.setMargin(pane,new Insets(10,0,0,0));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        reload(); // reload all food
    }

    public void BacktoMenu(MouseEvent event) throws IOException {
        scenecontroller.switchToMenu(event);
    }

}