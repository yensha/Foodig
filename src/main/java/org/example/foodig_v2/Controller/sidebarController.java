package org.example.foodig_v2.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

public class sidebarController implements Initializable {

    @FXML
    private ImageView sidebar;

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
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    private SceneController scene_controller;

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
