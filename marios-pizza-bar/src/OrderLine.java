public class OrderLine {
    private final int quantity;
    private final Pizza pizza;
    private final double pizzaPrice;

    public OrderLine(int quantity, Pizza pizza) {
        this.quantity = quantity;
        this.pizza = pizza;
        this.pizzaPrice = pizza.getPrice();
    }

    public double getPriceForOrderLine() {
        return pizzaPrice * quantity;
    }

    public String getPizzaName() {
        return pizza.getName();
    }

    public int getPizzaId() {
        return pizza.getID();
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return quantity + " x " + pizza.getName() + ": " + getPriceForOrderLine() + "kr,-";
    }
}
