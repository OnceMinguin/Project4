package thisduts;

import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    public abstract double price();
    public abstract void addToppings(Topping topping);
    public abstract void removeToppings(Topping topping);
}