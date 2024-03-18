//import array list function
import java.util.ArrayList;
//creates the shopping cart class
class ShoppingCart {
//creates the array list item lsit
    public ArrayList<ItemOrder> itemList;
//intializes the array list
    public ShoppingCart() {
        itemList = new ArrayList<>();
    }
//method to add items
    public void addItemOrder(ItemOrder itemOrder) {
        itemList.add(itemOrder);
    }
//method to remove items
    public void removeItemOrder(ItemOrder itemOrder) {
        itemList.remove(itemOrder);
    }
//method to allow you to add items and add to the price
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (ItemOrder itemOrder : itemList) {
            totalPrice += itemOrder.getTotalPrice();
        }
        return totalPrice;
    }
//method to search items
    public ItemOrder searchItemOrder(String itemName) {
        for (ItemOrder itemOrder : itemList) {
            if (itemOrder.getItem().getName().equalsIgnoreCase(itemName)) {
                return itemOrder;
            }
        }
        return null;
    }
//method for orders
    public ItemOrder[] getOrders() {
        return new ItemOrder[0];
    }
}

