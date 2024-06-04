package org.example.foodig_v2;

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
    }
    public void BuyComputerMouse(MouseEvent event) throws IOException {
        MouseFarm.updateMousetoComputerMouse();
    }
    public void BuyRichBurgerMouse(MouseEvent event) throws IOException {
        MouseFarm.updateMousetoRichBurgerMouse();
    }
    public void BuyPotion(MouseEvent event) throws IOException {
        Mouse.isPoison = false;
    }
}
