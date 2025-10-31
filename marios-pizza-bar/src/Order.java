import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private static int nextId = 1;
    private final int orderNr;
    private Customer customer;
    private double discount;
    private final ArrayList<OrderLine> lines = new ArrayList<>();
    private LocalTime pickUpTime;
    private boolean isReady = false;

    //Standard afhentningstid
    public Order(Customer customer) {
        this.orderNr = nextId++;
        this.pickUpTime = LocalTime.now().plusMinutes(20);
        this.customer = customer;
        this.discount = customer.getDiscount();
    }

    //Bruger defineret afhentningstid
    public Order(LocalTime pickUpTime, Customer customer) {
        this.orderNr = nextId++;
        this.pickUpTime = pickUpTime;
        this.customer = customer;
        this.discount = customer.getDiscount();
    }

    //Tilføj ordre linje
    public void addProduct(int quantity, Pizza pizza) {
        lines.add(new OrderLine(quantity, pizza));
    }

    //Samlet pris for alle ordre linjer
    public double getTotalCostOfOrder() {
        double totalSum = 0;
        for (OrderLine line : lines) {
            totalSum += line.getPriceForOrderLine();
        }
        return totalSum * discount;
    }

    //GETTERS
    public Customer getCustomer() {
        return customer;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public boolean isReady() {
        return isReady;
    }

    public ArrayList<OrderLine> getLines() {
        return lines;
    }

    //SETTERS
    public void setReady(boolean ready) {
        isReady = ready;
    }

    @Override
    public String toString() {
        String s = String.format("%s %03d","Ordre Nr:", orderNr) + "\n" +
                "Afhentning kl: " + pickUpTime.getHour() + ":" + pickUpTime.getMinute() + "\n";
        for (OrderLine line : lines) {
            s += line + "\n";
        }
        s += "----------------------------------\n";
        s += String.format("%-24s %7.2f","Samlede pris:",getTotalCostOfOrder())+ "kr";
        return s + "\n##################################";
    }
}