package org.example.foodig_v2;

import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import org.example.foodig_v2.Mouse.Mouse;
import org.example.foodig_v2.MouseFarm;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static org.example.foodig_v2.MouseFarm.PetMouse;
import static org.example.foodig_v2.MouseFarm.feedFood;

public class MouseController implements Initializable {

    @FXML
    ImageView Image_Shop;

    @FXML
    ImageView MouseImage;

    @FXML
    ImageView back;

    @FXML
    Label Coin_Label;

    @FXML
    Label Feed_Label;

    @FXML
    Button Feedbtn;

    @FXML
    Button Collectbtn;

    private SceneController scenecontroller;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Mouse PetMouse = MouseFarm.PetMouse;
        scenecontroller = new SceneController();
        Coin_Label.setText(String.valueOf(MouseFarm.Coin));
        Feed_Label.setText(String.valueOf(MouseFarm.Feed));

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                Collectbtn.setDisable(PetMouse.ispoison());
            }
        };
        timer.start();

        Image image = new Image(String.valueOf(getClass().getResource(PetMouse.getImagePath())));
        MouseImage.setImage(image);
        System.out.println(PetMouse.getImagePath());
        System.out.println(PetMouse.getName());

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
    public void Feed(ActionEvent event) throws IOException {
        feedFood();
    }
}
