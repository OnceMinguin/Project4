package thisduts;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Label;

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
        pizzaSize.getSelectionModel().select("small");
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
        pizzaImage.setImage(new Image("C:\\Users\\User\\IdeaProjects\\Project 4\\src\\thisduts\\pics\\deluxe.jpg"));
    }

    private void createPepperoni(){
        Arrays.asList(Topping.values()).forEach(Topping -> {
            if (Topping == thisduts.Topping.Pepperoni)
                selectedToppings.getItems().add(Topping.toString(Topping));
            else
                additionalToppings.getItems().add(Topping.toString(Topping));
        });
        name.setText("Pepperoni");
        pizzaImage.setImage(new Image("C:\\Users\\User\\IdeaProjects\\Project 4\\src\\thisduts\\pics\\pepperoni.jpg"));
    }

    private void createHawaiian(){
        Arrays.asList(Topping.values()).forEach(Topping -> {
            if (Topping == thisduts.Topping.Pineapple || Topping == thisduts.Topping.Ham)
                selectedToppings.getItems().add(Topping.toString(Topping));
            else
                additionalToppings.getItems().add(Topping.toString(Topping));
        });
        name.setText("Hawaiian");
        pizzaImage.setImage(new Image("C:\\Users\\User\\IdeaProjects\\Project 4\\src\\thisduts\\pics\\hawaiian.jpg"));
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

}
