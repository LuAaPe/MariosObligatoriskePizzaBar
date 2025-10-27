public class OrderLine {
    private int quantity;
    private String pizza;
    private double price;
    private int pizzaId;

    public OrderLine(int quantity, Pizza pizza) {
        this.quantity = quantity;
        this.pizza = pizza.getName();
        this.price = pizza.getPrice();
        this.pizzaId = pizza.getID();
    }

    public double getPrice() {
        return price;
    }

    public String getPizza() {
        return pizza;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString(){
        return quantity + " x " + pizza;
    }
}
