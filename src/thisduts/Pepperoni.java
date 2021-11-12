package thisduts;

public class Pepperoni extends Pizza {
    public Pepperoni() {
        toppings.add(Topping.Pepperoni);
    }

    private static final double SMALL = 8.99;
    private static final double MEDIUM = 10.99;
    private static final double LARGE = 12.99;
    private static final double TOPPING_PRICE = 1.79;
    private static final int MIN_TOPPING = 1;

    @Override
    public double price() {
        double price;
        if (size.equals(Size.Small)) {
            price = SMALL;
        } else if (size.equals(Size.Medium)) {
            price = MEDIUM;
        } else {
            price = LARGE;
        }
        return price + (toppings.size() - MIN_TOPPING) * TOPPING_PRICE;
    }
    @Override
    public void addToppings(Topping topping){
        toppings.add(topping);
    }

    @Override
    public void removeToppings(Topping topping){
        toppings.remove(topping);
    }
}
