package org.example.foodig_v2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;


public class FoodInfo implements Initializable {
    @FXML
    private ChoiceBox<String> ChoiceBox_FoodType;
    private final String[] foodType = {"全穀雜糧", "豆魚蛋肉", "蔬菜", "水果", "乳品", "堅果油脂", "調味料"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        ChoiceBox_FoodType.getItems().addAll(foodType);
    }
    // not done yet!!! https://youtu.be/hwCbXOM4_Qc?si=C609OQE9uiolYzhe

    @FXML
    private TextArea TextArea_FoodRemark;
    @FXML
    private Label Label_FoodStatus;
    @FXML
    private DatePicker DatePicker_ManufactureDate;
    @FXML
    private DatePicker DatePicker_ExpiredDate;
    @FXML
    private AnchorPane Panel_FoodImage;
    @FXML
    private AnchorPane Panel_FoodNameInput;
    @FXML
    private TextField TextField_FoodNameInput;
    @FXML
    private AnchorPane Panel_FoodName;
    @FXML
    private Button Button_ChangeFoodName;
}
