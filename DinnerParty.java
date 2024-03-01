//Creates the DinnerParty subclass which extends the party class
public class DinnerParty extends party {
    //Creates the dinner choice integer
    public int dinnerChoice;


    //Method to set dinner choice
    public void setDinnerChoice(int dinnerChoice) {
        this.dinnerChoice = dinnerChoice;
    }


    //method to get dinner choice
    public int getDinnerChoice(){
        return dinnerChoice;
    }
}
