package org.example.foodig_v2;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopController implements Initializable {
    @FXML
    private ImageView Image_Mouse1;

    @FXML
    private ImageView Image_Mouse11;
    @FXML
    private ImageView Image_Mouse111;
    @FXML
    private ImageView Image_Mouse112;
    @FXML
    private ImageView Image_Mouse113;

    @FXML
    private ImageView Image_Mouse1111;

    @FXML
    private ImageView back;

    @FXML
    private ImageView Image_Shop;

    private SceneController scenecontroller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scenecontroller = new SceneController();
    }
    public void BacktoMenu(MouseEvent event) throws IOException {
        scenecontroller.switchToMenu(event);
    }
    public void TurntoShop(MouseEvent event) throws IOException {
        scenecontroller.switchToShop(event);
    }

}
