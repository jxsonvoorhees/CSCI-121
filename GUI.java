//imports all the java swing methods
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//creates gui class
public class GUI {
    private static final int MAX_TOPPINGS = 10;
    private static final String QUIT = "QUIT";
//creates all the textfields, buttons, and text areas
    private JTextField toppingField;
    private JTextField addressField;
    private JTextArea resultArea;
    private JButton addToppingButton;

    private JComboBox<String> crustComboBox;
//creates an int for number of toppings
    private int numToppings;

//creates all the components of the GUI
    public GUI() {
        JFrame frame = new JFrame("Pizza Ordering System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.CYAN);


        JPanel toppingPanel = new JPanel(new FlowLayout());
        toppingPanel.setBackground(Color.CYAN);
        JLabel toppingLabel = new JLabel("Topping:");
        toppingField = new JTextField(20);
        toppingPanel.add(toppingLabel);
        toppingPanel.add(toppingField);

        JPanel crustPanel = new JPanel(new FlowLayout());
        JLabel crustLabel = new JLabel("Crust:");
        String[] crustOptions = {"Beer", "Gluten Free", "Garlic", "Basil"};
        crustComboBox = new JComboBox<>(crustOptions);
        crustPanel.add(crustLabel);
        crustPanel.add(crustComboBox);

        JPanel deliveryPanel = new JPanel(new FlowLayout());
        deliveryPanel.setBackground(Color.CYAN);
        JLabel addressLabel = new JLabel("Delivery Address:");
        addressField = new JTextField(20);
        deliveryPanel.add(addressLabel);
        deliveryPanel.add(addressField);

        addToppingButton = new JButton("Add Topping");
        addToppingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTopping();
            }
        });

        JButton orderButton = new JButton("Place Order");
        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        mainPanel.add(toppingPanel, BorderLayout.NORTH);
        mainPanel.add(deliveryPanel, BorderLayout.CENTER);
        mainPanel.add(addToppingButton, BorderLayout.EAST);
        mainPanel.add(orderButton, BorderLayout.SOUTH);
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.WEST);

        frame.add(mainPanel);
        frame.setVisible(true);

        numToppings = 0;
    }

    private void addTopping() {
        if (numToppings < MAX_TOPPINGS) {
            String topping = toppingField.getText().trim();
            if (!topping.isEmpty()) {
                resultArea.append("Added topping: " + topping + "\n");
                toppingField.setText("");
                numToppings++;
            }
            if (numToppings == MAX_TOPPINGS) {
                addToppingButton.setEnabled(false);
                toppingField.setEnabled(false);
            }
        }
    }



    private void placeOrder() {
        String[] toppings = resultArea.getText().split("\nAdded topping: ");
        int numToppings = toppings.length - 1; // Subtract 1 to exclude the first line
        String deliveryAddress = addressField.getText().trim();
        boolean isDelivery = !deliveryAddress.isEmpty();

        Pizza pizza;
        if (isDelivery) {
            pizza = new DeliveryPizza(toppings, deliveryAddress, numToppings);
        } else {
            pizza = new Pizza(toppings, numToppings);
        }

        resultArea.append("\nYour Pizza Order:\n" + pizza);
    }
//allows gui to run
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}