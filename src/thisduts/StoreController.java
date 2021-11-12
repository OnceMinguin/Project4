package thisduts;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class StoreController {
    private MenuController mainController;
    @FXML
    private ComboBox phoneNumber;
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView orders;
    public static final DecimalFormat df2 = new DecimalFormat( "#0.00" );
    public void setMainController(MenuController controller) {
        mainController = controller;
        phoneNumber.getItems().removeAll(phoneNumber.getItems());
        for (int i = 0; i < mainController.allOrders.getSize(); i++) {
            phoneNumber.getItems().add(mainController.allOrders.getPNumber(i));
        }
        phoneNumber.getSelectionModel().selectFirst();
        display();
    }
    @FXML
    void removeOrder(ActionEvent event){
        for (int i = 0; i < mainController.allOrders.getSize(); i++) {
            if (mainController.allOrders.getPNumber(i).equals(phoneNumber.getValue())){
                mainController.allOrders.remove(i);
            }
        }
        phoneNumber.getItems().removeAll(phoneNumber.getItems());
        for (int i = 0; i < mainController.allOrders.getSize(); i++) {
            phoneNumber.getItems().add(mainController.allOrders.getPNumber(i));
        }
        phoneNumber.getSelectionModel().selectFirst();
        orders.getItems().clear();
        orderTotal.clear();
        display();
    }

    @FXML
    void exportFile(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", ".txt"),
                new FileChooser.ExtensionFilter("All Files", ".*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
        mainController.allOrders.Export(targetFile);
        //write code to write to the file.
    }
    @FXML
    void selectOrder(ActionEvent event) {
        orders.getItems().clear();
        display();
    }

    private void display() {
        for (int i = 0; i < mainController.allOrders.getSize(); i++){
            if (mainController.allOrders.getPNumber(i).equals(phoneNumber.getValue())){
                orderTotal.setText(df2.format(mainController.allOrders.getPrice(i)));
                break;
            }
        }
        for (int i = 0; i < mainController.allOrders.getSize(); i++) {
            if (mainController.allOrders.getPNumber(i).equals(phoneNumber.getValue())){
                for (int j = 0; j < mainController.allOrders.getOrderSize(i); j++) {
                    orders.getItems().add(mainController.allOrders.getPizza(i, j));
                }
            }
        }
    }
}
