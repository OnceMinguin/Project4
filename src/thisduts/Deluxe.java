package thisduts;

public class Deluxe extends Pizza {
    public Deluxe() {
        toppings.add(Topping.Sausage);
        toppings.add(Topping.Onion);
        toppings.add(Topping.Pepperoni);
        toppings.add(Topping.Mushroom);
        toppings.add(Topping.GreenPepper);
    }

    private static final double SMALL = 12.99;
    private static final double MEDIUM = 14.99;
    private static final double LARGE = 16.99;

    @Override
    public double price() {
        if (size.equals(Size.Small)) {
            return SMALL;
        } else if (size.equals(Size.Medium)) {
            return MEDIUM;
        }
        return LARGE;
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
