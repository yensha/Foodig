package org.example.foodig_v2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FoodTableController implements Initializable {
    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    @FXML
    private ImageView back;
    private SceneController scenecontroller;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        scenecontroller = new SceneController();
    }

    public void BacktoMenu(MouseEvent event) throws IOException {
        scenecontroller.switchToMenu(event);
    }

}