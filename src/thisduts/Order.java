package thisduts;

import java.util.ArrayList;

public class Order {
    private String pNumber;
    private ArrayList<Pizza> pizzas = new ArrayList<>();

    public Order(){
    }
    public Order(String pNumber) {
        this.pNumber = pNumber;
    }
    public boolean checkNumber(){
        if (pNumber == null){
            return false;
        } return true;
    }
    public void addToOrder(Pizza pizza) {
        pizzas.add(pizza);
    }

}
