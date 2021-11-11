package thisduts;

import java.util.ArrayList;

public class Order {
    private String pNumber;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public Order(String pNumber) {
        this.pNumber = pNumber;
    }

    public void addToOrder(Pizza pizza) {
        pizzas.add(pizza);
    }

}
