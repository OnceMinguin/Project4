package thisduts;

public class Hawaiian extends Pizza {
    public Hawaiian() {
        toppings.add(Topping.Pineapple);
        toppings.add(Topping.Ham);
    }

    private static final double SMALL = 10.99;
    private static final double MEDIUM = 12.99;
    private static final double LARGE = 14.99;

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
