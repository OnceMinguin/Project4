package thisduts;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.Arrays;

import static thisduts.PizzaMaker.createPizza;

public class CustomizeController {
    @FXML
    private ComboBox pizzaSize;
    @FXML
    private ImageView pizzaImage;
    @FXML
    private ListView additionalToppings, selectedToppings;
    @FXML
    private Label name;
    @FXML
    private TextField price;

    private MenuController mainController;
    private Pizza pizza;
    public static final DecimalFormat df2 = new DecimalFormat( "#0.00" );
    @FXML
    public void initialize() {
        pizzaSize.getItems().removeAll(pizzaSize.getItems());
        pizzaSize.getItems().addAll("small", "medium", "large");
        pizzaSize.getSelectionModel().selectFirst();
    }

    @FXML
    void changeSize(ActionEvent event){
        if (pizzaSize.getValue().equals("small")){
            pizza.size = Size.Small;
        } else if (pizzaSize.getValue().equals("medium")){
            pizza.size = Size.Medium;
        } else{
            pizza.size = Size.Large;
        }
        price.setText(df2.format(pizza.price()));
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
            pizza = createPizza("Deluxe");
            pizza.size = Size.Small;
        } else if (mainController.lastClicked == 2) {
            createHawaiian();
            pizza = createPizza("Hawaiian");
            pizza.size = Size.Small;
        } else {
            createPepperoni();
            pizza = createPizza("Pepperoni");
            pizza.size = Size.Small;
        }
        price.setText(df2.format(pizza.price()));
    }

    @FXML
    void addTopping(ActionEvent event) {
        String temp;
        if(!additionalToppings.getSelectionModel().isEmpty()) {
            temp = moveTopping(additionalToppings, selectedToppings);
            if (temp.equals("")){
                return;
            }
            pizza.addToppings(toTopping(temp));
            price.setText(df2.format(pizza.price()));
        }else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("A topping was not selected.");
            alert.setContentText("Please select a topping.");
            alert.showAndWait();
        }
    }

    @FXML
    void removeTopping(ActionEvent event) {
        String temp;
        if(!selectedToppings.getSelectionModel().isEmpty()) {
            temp = moveTopping(selectedToppings, additionalToppings);
            if (temp.equals("")) {
                return;
            }
            pizza.removeToppings(toTopping(temp));
            price.setText(df2.format(pizza.price()));
        }else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("A topping was not selected.");
            alert.setContentText("Please select a topping.");
            alert.showAndWait();
        }
    }

    private Topping toTopping(String topping){
        if (topping.equals("Black Olives")){
            return Topping.BlackOlives;
        } else if (topping.equals("Green Pepper")) {
            return Topping.GreenPepper;
        } else if (topping.equals("Pineapple")) {
            return Topping.Pineapple;
        } else if (topping.equals("Ham")) {
            return Topping.Ham;
        } else if (topping.equals("Pepperoni")) {
            return Topping.Pepperoni;
        } else if (topping.equals("Sausage")) {
            return Topping.Sausage;
        } else if (topping.equals("Chicken")) {
            return Topping.Chicken;
        } else if (topping.equals("Beef")) {
            return Topping.Beef;
        } else if (topping.equals("Onion")) {
            return Topping.Onion;
        } else if (topping.equals("Cheese")) {
            return Topping.Cheese;
        } else {
            return Topping.Mushroom;
        }
    }

    private String moveTopping(ListView currentList, ListView targetList) {
        String temp = currentList.getSelectionModel().getSelectedItems().toString();
        temp = temp.substring(1, temp.length() - 1);
        if (mainController.lastClicked == 1){
            if (temp.equals("Green Pepper") || temp.equals("Pepperoni") || temp.equals("Mushroom")
                    || temp.equals("Sausage") || temp.equals("Onion")){
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning!!");
                alert.setHeaderText("An essential topping cannot be removed!");
                alert.setContentText("Please select another topping.");
                alert.showAndWait();
                return "";
            }
        }
        currentList.getItems().remove(temp);
        targetList.getItems().add(temp);
        return temp;
    }

    @FXML
    void addOrder(ActionEvent event){
        mainController.order.addToOrder(pizza);
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Notice!!");
        alert.setHeaderText("The pizza was added to your order.");
        alert.showAndWait();
    }
}

