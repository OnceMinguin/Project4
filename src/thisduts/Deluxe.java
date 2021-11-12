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
    private static final double TOPPING_PRICE = 1.79;
    private static final int MIN_TOPPING = 5;

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

    @Override
    public int checkType(){
        return 1;
    }

    @Override
    public String getToppings(){
        String getToppings = new String();
        for (int i = 0 ; i < toppings.size(); i++){
            getToppings = getToppings.concat(toppings.get(i).toString() + ", ");
        }
        return getToppings;
    }

    @Override
    public String getSize(){
        String getSize = new String();
        getSize = getSize.concat(size.toString() + ", ");
        return getSize;
    }

    @Override
    public boolean equals(Pizza pizza) {
        if (this.size != pizza.size){
            return false;
        } else if (pizza.checkType() != 1) {
            return false;
        } else if (this.toppings.size() != pizza.toppings.size()) {
            return false;
        }
        for (int i = 0; i < pizza.toppings.size(); i++) {
            if (!this.toppings.get(i).equals(pizza.toppings.get(i))){
                return false;
            }
        }
        return true;
    }
}
