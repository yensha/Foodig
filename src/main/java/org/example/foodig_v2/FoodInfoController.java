package org.example.foodig_v2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import static org.example.foodig_v2.FoodStorage.*;


public class FoodInfoController implements Initializable {

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        ChoiceBox_FoodType.getItems().addAll(foodType);
        scene_controller_food = new SceneController();

        DatePicker_ExpiredDate.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate oldValue, LocalDate newValue) {
                if (newValue != null) {
                    LocalDate today = LocalDate.now();
                    LocalDate threeDaysAfter = today.plusDays(3);
                    if (today.isAfter(newValue)) {
                        Label_FoodStatus.setText("過期囉");
                    } else if (threeDaysAfter.isAfter(newValue)){
                        Label_FoodStatus.setText("即將到期");
                    } else {
                        Label_FoodStatus.setText("尚未到期");
                    }
                }
                else {
                    Label_FoodStatus.setText("尚未到期");
                }
            }
        });

        ChoiceBox_FoodType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue) {
                    case "全穀雜糧" -> ImageView_FoodImage.setImage(new Image(String.valueOf(getClass().getResource("image/rice.png"))));
                    case "豆魚蛋肉" -> ImageView_FoodImage.setImage(new Image(String.valueOf(getClass().getResource("image/protein.png"))));
                    case "蔬菜" -> ImageView_FoodImage.setImage(new Image(String.valueOf(getClass().getResource("image/vegetable.png"))));
                    case "水果" -> ImageView_FoodImage.setImage(new Image(String.valueOf(getClass().getResource("image/fruits.png"))));
                    case "乳品" -> ImageView_FoodImage.setImage(new Image(String.valueOf(getClass().getResource("image/dairy-products.png"))));
                    case "調味料" -> ImageView_FoodImage.setImage(new Image(String.valueOf(getClass().getResource("image/spices.png"))));
                    default -> ImageView_FoodImage.setImage(new Image(String.valueOf(getClass().getResource("image/food-service.png"))));
                }
            }
            else {
                ImageView_FoodImage.setImage(new Image(String.valueOf(getClass().getResource("image/food-service.png"))));
            }
        });

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
    private void trashFood(MouseEvent event) throws IOException {
        deleteFood(TextField_FoodNameInput.getText()); // name should be the opened Food Info
        System.out.println("All Foods after deleting: " + getFoodsName());
        try {
            scene_controller_food.switchToMenu(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private DatePicker DatePicker_ExpiredDate;
    @FXML
    private DatePicker DatePicker_ManufactureDate;
    @FXML
    private ChoiceBox<String> ChoiceBox_FoodType;
    private final String[] foodType = {"全穀雜糧", "豆魚蛋肉", "蔬菜", "水果", "乳品", "調味料"};
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
    private ImageView Image_Trash;

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
