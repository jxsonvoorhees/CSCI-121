//Imports scanner
import java.util.Scanner;
//Creates UseParty class
public class UseParty {
    public static void main(String[] args){
        //Initializes the scanner
        Scanner sc = new Scanner(System.in);
        //Creates party object
        party aParty = new party();

        int numGuests = sc.nextInt();
        aParty.setGuests(numGuests);
        System.out.println("The party has " + aParty.getGuests() + " guests");
        aParty.displayInvitation();


        DinnerParty aDinnerParty = new DinnerParty();
        System.out.print("Enter number of guests for the dinner party >> ");
        int numDinnerGuests = sc.nextInt();
        aDinnerParty.setGuests(numDinnerGuests);

        System.out.print("Enter the menu option -- 1 for chicken or 2 for Vegi >> ");
        int menuChoice = sc.nextInt();
        aDinnerParty.setDinnerChoice(menuChoice);

        //Prints out the message with the number of dinner party guests
        System.out.println("The dinner party has " + aDinnerParty.getGuests() + " guests");
        //Prints out the menu option and the message saying it will be served
        System.out.println("Menu option " + aDinnerParty.getDinnerChoice() + " will be served");
        //Displays the invitation
        aParty.displayInvitation();
    }
}

