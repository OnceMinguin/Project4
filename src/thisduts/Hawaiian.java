package thisduts;

public class Hawaiian extends Pizza {
    public Hawaiian() {
        toppings.add(Topping.Pineapple);
        toppings.add(Topping.Ham);
    }

    private static final double SMALL = 10.99;
    private static final double MEDIUM = 12.99;
    private static final double LARGE = 14.99;
    private static final double TOPPING_PRICE = 1.79;
    private static final int MIN_TOPPING = 2;

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
