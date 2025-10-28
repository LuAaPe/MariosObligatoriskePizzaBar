public class OrderLine {
    private final int quantity;
    private final Pizza pizza;

    public OrderLine(int quantity, Pizza pizza) {
        this.quantity = quantity;
        this.pizza = pizza;
    }

    public double getPrice() {
        return pizza.getPrice();
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

    public String toString(){
        return quantity + " x " + pizza.getName();
    }
}
