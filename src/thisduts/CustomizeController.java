package thisduts;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;

import java.util.Arrays;

public class CustomizeController {
    @FXML
    private ComboBox pizzaSize;
    @FXML
    private ImageView pizzaImage;
    @FXML
    private ListView additionalToppings, selectedToppings;
    @FXML
    private Label name;

    private MenuController mainController;

    @FXML
    public void initialize() {
        pizzaSize.getItems().removeAll(pizzaSize.getItems());
        pizzaSize.getItems().addAll("small", "medium", "large");
    }

    private void createDeluxe() {
        Arrays.asList(Topping.values()).forEach(Topping -> {
            if (Topping == thisduts.Topping.Pepperoni || Topping == thisduts.Topping.Sausage || Topping == thisduts.Topping.Onion ||
                    Topping == thisduts.Topping.Mushroom || Topping == thisduts.Topping.GreenPepper)
                selectedToppings.getItems().add(Topping.toString(Topping));
            else
                additionalToppings.getItems().add(Topping.toString(Topping));
        });
        name.setText("Deluxe");
        pizzaImage.setImage(new Image("/thisduts/pics/deluxe.jpg"));
    }

    private void createPepperoni(){
        Arrays.asList(Topping.values()).forEach(Topping -> {
            if (Topping == thisduts.Topping.Pepperoni)
                selectedToppings.getItems().add(Topping.toString(Topping));
            else
                additionalToppings.getItems().add(Topping.toString(Topping));
        });
        name.setText("Pepperoni");
        pizzaImage.setImage(new Image("thisduts/pics/pepperoni.jpg"));
    }

    private void createHawaiian(){
        Arrays.asList(Topping.values()).forEach(Topping -> {
            if (Topping == thisduts.Topping.Pineapple || Topping == thisduts.Topping.Ham)
                selectedToppings.getItems().add(Topping.toString(Topping));
            else
                additionalToppings.getItems().add(Topping.toString(Topping));
        });
        name.setText("Hawaiian");
        pizzaImage.setImage(new Image("thisduts/pics/hawaiian.jpg"));
    }

    public void setMainController(MenuController controller) {
        mainController = controller;
        if (mainController.lastClicked == 1) {
            createDeluxe();
        } else if (mainController.lastClicked == 2) {
            createHawaiian();
        } else {
            createPepperoni();
        }
    }

    @FXML
    void addTopping(ActionEvent event) {
        if(!additionalToppings.getSelectionModel().isEmpty())
            moveTopping(additionalToppings, selectedToppings);
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("A topping was not selected.");
            alert.setContentText("Please select a topping.");
            alert.showAndWait();
        }
    }

    @FXML
    void removeTopping(ActionEvent event) {
        if(!selectedToppings.getSelectionModel().isEmpty())
            moveTopping(selectedToppings, additionalToppings);
        else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("A topping was not selected.");
            alert.setContentText("Please select a topping.");
            alert.showAndWait();
        }
    }

    private void moveTopping(ListView currentList, ListView targetList) {
        String temp = currentList.getSelectionModel().getSelectedItems().toString();
        temp = temp.substring(1, temp.length() - 1);
        currentList.getItems().remove(temp);
        targetList.getItems().add(temp);
    }
}
