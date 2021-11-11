package thisduts;
/**
 * creates an instance of subclasses based on the chosen flavor
 * @author Andy Li, Henry lin
 */
public class PizzaMaker {
    public static Pizza createPizza(String flavor) {
        if (flavor.equals("Pepperoni")){
            return new Pepperoni();
        } else if (flavor.equals("Hawaiian")){
            return new Hawaiian();
        } else {
            return new Deluxe();
        }
    }
}
