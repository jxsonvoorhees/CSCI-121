//Implements item class
class Item {
    private String name;
    private double price;

    //creates the item constructor
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //get method to return String name
    public String getName() {
        return name;
    }

    //get method to return price
    public double getPrice() {
        return price;
    }
}