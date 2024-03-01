//Imports all GUI components
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
//Creates the GUI frame
public class GUI extends JFrame {
    //Allows the labels, text fields, buttons, and combo box's to be used in public GUI
    private JLabel partyLabel, dinnerPartyLabel, menuLabel, locationPartyLabel, locationLabel;
    private JTextField partyField, dinnerPartyField, locationPartyField, locationField;
    private JButton partyButton, dinnerPartyButton;
    private JComboBox<String> menuComboBox;

    //Creates the GUI class
    public GUI() {
        //Sets title, size, and allows you to close the frame
        setTitle("Party Invitation");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Initializes the labels, text fields, and buttons
        partyLabel = new JLabel("Enter number of guests for the party:");
        partyLabel.setFont(new Font("Arial", Font.ITALIC, 22));
        partyLabel.setPreferredSize(new Dimension(450, 20));
        partyLabel.setForeground(Color.CYAN);
        partyField = new JTextField(10);
        partyButton = new JButton("Generate Party Invitation");

        dinnerPartyLabel = new JLabel("Enter number of guests for the dinner party:");
        dinnerPartyLabel.setFont(new Font("Arial", Font.ITALIC, 22));
        dinnerPartyLabel.setPreferredSize(new Dimension(550, 20));
        dinnerPartyLabel.setForeground(Color.CYAN);
        dinnerPartyField = new JTextField(10);
        dinnerPartyButton = new JButton("Generate Dinner Party Invitation");

        //Initializes the label for the dinner menu, and the combo box allowing you to select chicken or vegi
        menuLabel = new JLabel("Select dinner menu:");
        menuLabel.setFont(new Font("Arial", Font.ITALIC, 22));
        menuLabel.setPreferredSize(new Dimension(550, 20));
        menuLabel.setForeground(Color.CYAN);
        String[] menuOptions = {"Chicken", "Vegi", "Steak", "Chicken Parm", "Ham"};
        menuComboBox = new JComboBox<>(menuOptions);

        //Initializes the label and text field for the party location
        locationPartyLabel = new JLabel("Enter the location for the party");
        locationPartyLabel.setFont(new Font("Arial", Font.ITALIC, 22));
        locationPartyLabel.setPreferredSize(new Dimension(550, 20));
        locationPartyLabel.setForeground(Color.CYAN);
        locationPartyField = new JTextField(10);


        //Initializes the label and text field for the dinner party location
        locationLabel = new JLabel("Enter the location for the dinner party");
        locationLabel.setFont(new Font("Arial", Font.ITALIC, 22));
        locationLabel.setPreferredSize(new Dimension(550, 20));
        locationLabel.setForeground(Color.CYAN);
        locationField = new JTextField(10);



        //Allows the party button to be used and displays the invitation
        partyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numGuests = Integer.parseInt(partyField.getText());
                String locationPartyText = locationPartyField.getText();
                party party = new party();
                party.setGuests(numGuests);
                JOptionPane.showMessageDialog(null, "The party has " + party.getGuests() + " guests\n at " + locationPartyText + ", Please come to my party!");
            }
        });


        //Allows the dinner party button to be used and displays the invitation
        dinnerPartyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numDinnerGuests = Integer.parseInt(dinnerPartyField.getText());
                String locationText = locationField.getText();
                DinnerParty dinnerParty = new DinnerParty();
                dinnerParty.setGuests(numDinnerGuests);
                String menuChoice = (String) menuComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, "The dinner party has " + dinnerParty.getGuests() + " guests,\n" + menuChoice + " will be served\n at " + locationText + ", Please come to my party!");
            }
        });


        //Initializes all the labels, buttons, and text fields to be used in the GUI
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new FlowLayout());
        panel.add(locationPartyLabel);
        panel.add(locationPartyField);
        panel.add(partyLabel);
        panel.add(partyField);
        panel.add(partyButton);
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(dinnerPartyLabel);
        panel.add(dinnerPartyField);
        panel.add(menuLabel);
        panel.add(menuComboBox);
        panel.add(dinnerPartyButton);
        add(panel);

        //Allows the GUI to be seen
        setVisible(true);
    }


    //Allows the GUI to run
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}