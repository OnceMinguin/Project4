package thisduts;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;



public class MenuController {
    @FXML
    void openPizza(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/thisduts/CustomizePizza.fxml"));
            BorderPane root = (BorderPane) loader.load();

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/thisduts/CustomizePizza.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/thisduts/CustomizePizza.fxml"));
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
