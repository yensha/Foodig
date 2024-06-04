package org.example.foodig_v2;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import org.example.foodig_v2.Mouse.Mouse;
import org.example.foodig_v2.MouseFarm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.foodig_v2.MouseFarm.Coin;
import static org.example.foodig_v2.MouseFarm.Feed;

public class ShopController implements Initializable {
    @FXML
    private ImageView back;
    @FXML
    private ImageView Image_Shop;
    @FXML
    private Label YourMoney;
    @FXML
    private Button BuyFlatMouse_btn;
    @FXML
    private Button BuyComputerMouse_btn;
    @FXML
    private Button BuyRichBurgerMouse_btn;
    @FXML
    private Button BuyPotion_btn;

    private SceneController scenecontroller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scenecontroller = new SceneController();
        YourMoney.setText(String.valueOf(MouseFarm.Coin));
    }
    public void BacktoMenu(MouseEvent event) throws IOException {
        scenecontroller.switchToMenu(event);
    }
    public void TurntoMouse(MouseEvent event) throws IOException {
        scenecontroller.switchToMouse(event);
    }
    public void BuyFlatMouse(MouseEvent event) throws IOException {
        MouseFarm.updateMousetoFlatMouse();
        YourMoney.setText(String.valueOf(Coin));
    }
    public void BuyComputerMouse(MouseEvent event) throws IOException {
        MouseFarm.updateMousetoComputerMouse();
        YourMoney.setText(String.valueOf(Coin));
    }
    public void BuyRichBurgerMouse(MouseEvent event) throws IOException {
        MouseFarm.updateMousetoRichBurgerMouse();
        YourMoney.setText(String.valueOf(Coin));
    }
    public void BuyPotion(MouseEvent event) throws IOException {
        MouseFarm.PetMouse.setPoison(false);
        Coin -= 1000;
        YourMoney.setText(String.valueOf(Coin));
    }
}
