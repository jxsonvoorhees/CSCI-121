//creates the delivery pizza class
class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;
//allows there to be a delivery fee
    public DeliveryPizza(String[] toppings, String deliveryAddress, int numToppings) {
        super(toppings, numToppings);
        this.deliveryAddress = deliveryAddress;
        if (super.toString().contains("Price: $")) {
            double price = Double.parseDouble(super.toString().substring(super.toString().indexOf("$") + 1));
            this.deliveryFee = price > 18 ? 3 : 5;
        }
    }
//allows class to run
    @Override
    public String toString() {
        return super.toString() + "\nDelivery Fee: $" + deliveryFee + "\nDelivery Address: " + deliveryAddress;
    }
}
