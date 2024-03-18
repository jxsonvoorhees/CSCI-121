//imports and allows arrays to be used
import java.util.Arrays;

//creates pizza class
public class Pizza {
    private String[] toppings;
    private double price;
//creates the price for pizza
    public Pizza(String[] toppings, int numToppings) {
        this.toppings = Arrays.copyOf(toppings, numToppings);
        this.price = 14 + (2 * numToppings);
    }
//allows class to run
    @Override
    public String toString() {
        return "Pizza with toppings: " + String.join(", ", toppings) + "\nPrice: $" + price;
    }
}
