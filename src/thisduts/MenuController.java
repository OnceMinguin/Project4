package thisduts;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;

public class MenuController {
    @FXML Button deluxe, hawaiian, pepperoni;
    protected int lastClicked = -1;

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
}
