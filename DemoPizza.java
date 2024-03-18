//imports scanner
import java.util.Scanner;

//creates demo pizza class
public class DemoPizza {
    private static final int MAX_TOPPINGS = 10;
    private static final String QUIT = "QUIT";
//method to display scanner messages
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Pizza Ordering System!");

        System.out.println("Enter toppings for your pizza (up to 10). Type QUIT to finish:");
        String[] toppings = new String[MAX_TOPPINGS];
        int numToppings = 0;
        String input;
        while (numToppings < MAX_TOPPINGS) {
            System.out.print("Enter topping #" + (numToppings + 1) + ": ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase(QUIT)) {
                break;
            }
            toppings[numToppings] = input;
            numToppings++;
        }

        System.out.print("Do you want your pizza to be delivered? (yes/no): ");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.print("Enter delivery address: ");
            String deliveryAddress = scanner.nextLine();
            DeliveryPizza pizza = new DeliveryPizza(toppings, deliveryAddress, numToppings);
            System.out.println("\nYour Pizza Order:\n" + pizza);
        } else {
            Pizza pizza = new Pizza(toppings, numToppings);
            System.out.println("\nYour Pizza Order:\n" + pizza);
        }

        scanner.close();
    }
}
