import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private static int nextId = 1;
    private final int orderNr;
    private Customer customer;
    private final ArrayList<OrderLine> lines = new ArrayList<>();
    private LocalTime pickUpTime;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private boolean isReady = false;

/*
Kig færdig på det her, hvordan får jeg stadard pickup til at være 20 min fra nu, og derefter kunne ændre det selv
if de efterfølgende cunstructors??
 */

    //Standard afhentningstid
    public Order(Customer customer) {
        this.orderNr = nextId++;
        this.pickUpTime = LocalTime.now().plusMinutes(20);
        this.customer = customer;
    }

    //Bruger defineret afhmentningstid
    public Order(LocalTime pickUpTime, Customer customer) {
        this.orderNr = nextId++;
        this.pickUpTime = pickUpTime;
        this.customer = customer;
    }

    //Tilføj ordre linje
    public void addProduct(int quantity, Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("Fejl i indtastning Pizza findes ikke");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Ikke muligt at tilføje negativt antal pizzer til ordre");
        }
        lines.add(new OrderLine(quantity, pizza));
    }

    //Samlet pris for alle ordre linjer
    public double getTotalCostOfOrder() {
        double totalSum = 0;
        for (OrderLine line : lines) {
            totalSum += line.getPriceForOrderLine();
        }
        return totalSum;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ArrayList<OrderLine> getLines() {
        return lines;
    }
    /*public String getCustomerPhoneNr() {
        return customerPhoneNr;
    }

     */

    //SETTERS
    public void setReady(boolean ready) {
        isReady = ready;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    @Override
    public String toString() {
        String s = "Ordre Nr: " + orderNr + "\n" +
                "Afhentning kl: " + getPickUpTime() + "\n";
        for (OrderLine line : lines) {
            s += line + "\n";
        }
        return s;
    }
}