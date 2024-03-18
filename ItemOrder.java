//Creates the item order class
class ItemOrder {
    private Item item;
    private int quantity;

    //Item order constructor
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    //get method for item to return
    public Item getItem() {
        return item;
    }

    //get method to return quantity
    public int getQuantity() {
        return quantity;
    }
//get method to return total price
    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }
}
