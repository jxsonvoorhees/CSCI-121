//imports all gui components
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//creates the gui class
public class GUI extends JFrame {
    //creates all the textfields, combo box, text area, and labels for gui
    private ShoppingCart cart;

    private JComboBox<String> itemComboBox;
    private JTextField quantityField;
    private JTextArea cartTextArea;
    private JLabel totalPriceLabel;
//creates the drop down items
    private Item[] items = {
            new Item("Tissues", 3.0),
            new Item("Paper Plates", 2.5),
            new Item("Bread", 3.0),
            new Item("Toilet Paper", 4.0),
            new Item("Mouth Wash", 7.0)

    };
//intializes all the pieces of the gui
    public GUI() {
        cart = new ShoppingCart();

        setTitle("Shopping Cart");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2 ));
        inputPanel.add(new JLabel("Select Item:"));
        itemComboBox = new JComboBox<>();
        for (Item item : items) {
            itemComboBox.addItem(item.getName());
        }
        inputPanel.add(itemComboBox);
        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);
        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToCart();
            }
        });
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Remove Button
        JButton removeButton = new JButton("Remove Order");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemFromCart();
            }
        });
        add(removeButton, BorderLayout.WEST);


        cartTextArea = new JTextArea();
        add(new JScrollPane(cartTextArea), BorderLayout.CENTER);


        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.add(new JLabel("Total Price:"));
        totalPriceLabel = new JLabel("$0.00");
        totalPanel.add(totalPriceLabel);
        add(totalPanel, BorderLayout.SOUTH);
    }

    private void addItemToCart() {
        String itemName = (String) itemComboBox.getSelectedItem();
        String quantityStr = quantityField.getText();
        if (quantityStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter quantity.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Item selectedItem = null;
            for (Item item : items) {
                if (item.getName().equals(itemName)) {
                    selectedItem = item;
                    break;
                }
            }
            if (selectedItem != null) {
                if (quantity >= 2) {
                    selectedItem = new Item(selectedItem.getName(), selectedItem.getPrice() - 1.0);
                }
                ItemOrder order = new ItemOrder(selectedItem, quantity);
                cart.addItemOrder(order);
                updateCartDisplay();
                updateTotalPrice();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid item selected.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeItemFromCart() {
        String itemName = (String) itemComboBox.getSelectedItem();
        ItemOrder orderToRemove = cart.searchItemOrder(itemName);
        if (orderToRemove != null) {
            cart.removeItemOrder(orderToRemove);
            updateCartDisplay();
            updateTotalPrice();
        } else {
            JOptionPane.showMessageDialog(this, "No order found for selected item.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCartDisplay() {
        StringBuilder cartContent = new StringBuilder();
        for (ItemOrder order : cart.getOrders()) {
            cartContent.append(order.getItem().getName()).append(": ").append(order.getQuantity()).append("\n");
        }
        cartTextArea.setText(cartContent.toString());
    }

    private void updateTotalPrice() {
        double totalPrice = cart.getTotalPrice();
        totalPriceLabel.setText(String.format("$%.2f", totalPrice));
    }
//allows the gui to run
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}


