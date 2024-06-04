package org.example.foodig_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.image.*;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static org.example.foodig_v2.FoodStorage.addFood;
import static org.example.foodig_v2.FoodStorage.getFoodsName;


public class FoodInfoController implements Initializable {

    @FXML
    private ChoiceBox<String> ChoiceBox_FoodType;
    private final String[] foodType = {"全穀雜糧", "豆魚蛋肉", "蔬菜", "水果", "乳品", "調味料"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        ChoiceBox_FoodType.getItems().addAll(foodType);
        scene_controller_food = new SceneController();
    }
    // not done yet!!! https://youtu.be/hwCbXOM4_Qc?si=C609OQE9uiolYzhe

    @FXML
    private TextField TextField_FoodNameInput;
    @FXML
    private void saveFood(ActionEvent event) throws IOException {
        String name = TextField_FoodNameInput.getText();
        String type = ChoiceBox_FoodType.getValue();
        LocalDate expirationDate = DatePicker_ExpiredDate.getValue();
        LocalDate manufacturedDate = DatePicker_ManufactureDate.getValue();
        String remark = TextArea_FoodRemark.getText();
//        String imagePath = String.valueOf(ImageView_FoodImage.getImage()); // maybe is not like this
//        String imagePath = ImageView_FoodImage.getImage().getUrl();

        addFood(name, type, expirationDate, manufacturedDate, remark);
        System.out.println(getFoodsName());
    }
    @FXML
    private DatePicker DatePicker_ExpiredDate;
    @FXML
    private DatePicker DatePicker_ManufactureDate;
    @FXML
    private TextArea TextArea_FoodRemark;
    @FXML
    private AnchorPane Panel_FoodImage;
    @FXML
    private ImageView ImageView_FoodImage;
    @FXML
    private Label Label_FoodStatus;
    @FXML
    private Button Button_SaveFoodInfo;

    @FXML
    private ImageView Image_BackArrow;
    @FXML
    private ImageView Image_Mouse;

    @FXML
    private SceneController scene_controller_food;

    @FXML
    private void GotoMenu(MouseEvent event)  {
        try {
            scene_controller_food.switchToMenu(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
