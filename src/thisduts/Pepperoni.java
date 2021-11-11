package thisduts;

public class Pepperoni extends Pizza {
    public Pepperoni() {
        toppings.add(Topping.Pepperoni);
    }

    private static final double SMALL = 8.99;
    private static final double MEDIUM = 10.99;
    private static final double LARGE = 12.99;

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
