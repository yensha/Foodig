package org.example.foodig_v2;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.fxml.Initializable;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

public class sidebarController implements Initializable {

    @FXML
    private ImageView sidebar;

    @FXML
    private AnchorPane side_pane;

    @FXML
    private Pane foodig_pane;

    @FXML
    private Button Homebtn;

    @FXML
    private Button Foodbtn;

    @FXML
    private Button Mousebtn;

    @FXML
    private Button Settingbtn;

    private SceneController scene_controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scene_controller = new SceneController();
        side_pane.setVisible(false);

        sidebar.setOnMouseClicked(event -> {
            side_pane.setVisible(true);
        });
        foodig_pane.setOnMouseClicked(event -> {
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
    private void TurntoFood(ActionEvent event) {
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
}
