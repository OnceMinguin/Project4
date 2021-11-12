package thisduts;
/**
 * creates the enum class Size
 * @author Andy Li, Henry lin
 */
public enum Size {
    Small, Medium, Large;

    public String toString(Size size) {
        if (size.equals(Small)){
            return "small";
        } else if (size.equals(Medium)) {
            return "medium";
        } else if (size.equals(Large)) {
            return "large";
        } else {
            return "";
        }
    }
}
