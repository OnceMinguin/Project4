package thisduts;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuController {
    @FXML Button deluxe, hawaiian, pepperoni;
    @FXML TextField phoneNumber;
    protected int lastClicked = -1;
    protected Order order = new Order();

    @FXML
    public void initialize() {
        deluxe.setOnAction(e-> {
            lastClicked = 1;
            openPizza();
        });
        hawaiian.setOnAction(e->{
            lastClicked = 2;
            openPizza();
        });
        pepperoni.setOnAction(e->{
            lastClicked = 3;
            openPizza();
        });
    }

    @FXML
    void openPizza() {
        if (!order.checkNumber()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No phone number was entered");
            alert.setContentText("Please enter a ten digit phone number.");
            alert.showAndWait();
            return;
        }

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/thisduts/CustomizePizza.fxml"));
            BorderPane root = (BorderPane) loader.load();

            CustomizeController pizzaView = loader.getController();
            pizzaView.setMainController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Customize Your Pizza");
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void placeOrder(ActionEvent event) {
        if (!order.checkNumber()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No phone number was entered");
            alert.setContentText("Please enter a ten digit phone number.");
            alert.showAndWait();
            return;
        }

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/thisduts/CurrentOrder.fxml"));
            BorderPane root = (BorderPane) loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Place Your Order");
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void checkOrders(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/thisduts/StoreOrders.fxml"));
            BorderPane root = (BorderPane) loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Check All Store Orders");
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void createOrder(ActionEvent event) {
        if (phoneNumber.getText().matches("[a-zA-Z]+")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("A non numeric input was entered.");
            alert.setContentText("Please enter a numeric input.");
            alert.showAndWait();
            return;
        }
        if (phoneNumber.getText().length() != 10 ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("A non valid phone number was entered.");
            alert.setContentText("Please enter a ten digit phone number");
            alert.showAndWait();
            return;
        }
        order = new Order(phoneNumber.getText());
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Notice!!");
        alert.setHeaderText("Starting a new order.");
        alert.showAndWait();
    }
}
