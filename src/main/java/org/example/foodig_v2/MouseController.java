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
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;
import static org.example.foodig_v2.MouseFarm.*;

public class MouseController implements Initializable {

    @FXML
    ImageView Image_Shop;

    @FXML
    ImageView MouseImage;

    @FXML
    ImageView back;

    @FXML
    private Label Mouse_Name;

    @FXML
    Label Coin_Label;

    @FXML
    Label Feed_Label;

    @FXML
    private Label Collect_Label;

    @FXML
    Button Feedbtn;

    @FXML
    Button Collectbtn;

    @FXML
    private ImageView satiety1;

    @FXML
    private ImageView satiety2;

    @FXML
    private ImageView satiety3;

    @FXML
    private ImageView satiety4;

    @FXML
    private ImageView satiety5;

    private SceneController scenecontroller;

    private ArrayList<ImageView> satietyArray = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Mouse PetMouse = MouseFarm.PetMouse;
        scenecontroller = new SceneController();
        SatietyTimer();

        satietyArray.add(satiety1);
        satietyArray.add(satiety2);
        satietyArray.add(satiety3);
        satietyArray.add(satiety4);
        satietyArray.add(satiety5);
        //reload the parameter
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                Feed_Label.setText(String.valueOf(MouseFarm.Feed));
                Coin_Label.setText(String.valueOf(MouseFarm.Coin));
                Collect_Label.setText(String.valueOf(mousecoin));
                Feedbtn.setDisable(Feed <= 0);
                Collectbtn.setDisable(PetMouse.ispoison());
                int setcounter = (int) ((PetMouse.getSatiety()-1.0)*10);
                for (int i = 0; i < 5; i++) {
                    satietyArray.get(i).setOpacity(0.2);
                }
                for (int i = 0; i < setcounter; i++) {
                    satietyArray.get(i).setOpacity(1.0);
                }
            }
        };
        timer.start();

        MouseFarm.startCoinGeneration();
        Mouse_Name.setText(PetMouse.getName());
        Image image = new Image(String.valueOf(getClass().getResource(PetMouse.getImagePath())));
        MouseImage.setImage(image);
        System.out.println(PetMouse.getImagePath());
        System.out.println(PetMouse.getName());
        System.out.println(MouseFarm.Coin);
        System.out.println(MouseFarm.mousecoin);

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
