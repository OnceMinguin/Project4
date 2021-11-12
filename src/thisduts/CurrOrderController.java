package thisduts;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

public class CurrOrderController {
    @FXML
    private TextField phoneNumber, salesTax, orderTotal, subTotal;
    @FXML
    private ListView pizzaList;
    public static final DecimalFormat df2 = new DecimalFormat( "#0.00" );

    private MenuController mainController;

    public void setMainController(MenuController controller) {
        mainController = controller;
        phoneNumber.setText(mainController.order.getPNumber());
        subTotal.setText(df2.format(mainController.order.getSubTotal()));
        salesTax.setText(df2.format(mainController.order.getSalesTax()));
        orderTotal.setText(df2.format(mainController.order.getTotal()));
        for (int i = 0; i < mainController.order.getSize(); i++) {
            pizzaList.getItems().add(mainController.order.getPizza(i));
        }
    }

    @FXML
    void placeOrder(ActionEvent event) {
        if (mainController.order.getSize() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("User has not ordered a Pizza.");
            alert.setContentText("Please order a pizza!");
            alert.showAndWait();
            return;
        }
        mainController.allOrders.add(mainController.order);
        mainController.order = new Order();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice!!");
        alert.setHeaderText("Your order has been placed!");
        alert.showAndWait();
        phoneNumber.clear();
        pizzaList.getItems().clear();
        subTotal.clear();
        salesTax.clear();
        orderTotal.clear();
    }

    @FXML
    void removePizza(ActionEvent event) {
        String temp = pizzaList.getSelectionModel().getSelectedItems().toString();
        temp = temp.substring(1, temp.length() - 1);
        pizzaList.getItems().remove(temp);
        mainController.order.removePizza(temp);
        subTotal.setText(df2.format(mainController.order.getSubTotal()));
        salesTax.setText(df2.format(mainController.order.getSalesTax()));
        orderTotal.setText(df2.format(mainController.order.getTotal()));
    }
}
