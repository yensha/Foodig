package org.example.foodig_v2.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import org.example.foodig_v2.Mouse.Mouse;
import org.example.foodig_v2.MouseFarm;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;

public class MouseController implements Initializable {

    @FXML
    ImageView Image_Shop;

    @FXML
    ImageView back;

    @FXML
    Label Coin_Label;

    @FXML
    Label Feed_Label;

    @FXML
    Button Collectbtn;

    private SceneController scenecontroller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Mouse PetMouse = MouseFarm.PetMouse;
        scenecontroller = new SceneController();
        Coin_Label.setText(String.valueOf(MouseFarm.Coin));
        Feed_Label.setText(String.valueOf(MouseFarm.Feed));
    }
    public void TurntoShop(MouseEvent event) throws IOException {
        scenecontroller.switchToShop(event);
    }
    public void Collect(MouseEvent event) throws IOException {
        MouseFarm.AquireCoin();
    }
    public void BacktoMenu(MouseEvent event) throws IOException {
        scenecontroller.switchToMenu(event);
    }
}
