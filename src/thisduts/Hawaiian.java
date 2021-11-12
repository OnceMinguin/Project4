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

    @Override
    public int checkType(){
        return 2;
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
        } else if (pizza.checkType() != 2) {
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
