import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private static int nextId = 1;
    private final int id;
    private Customer customer;
    private ArrayList<OrderLine> lines;
    private LocalTime pickUpTime;
    private final LocalDateTime createdAt;
    private boolean isReady;
    private final String customerPhoneNr;
    /*    private enum status{
        NOT_READY,
        READY,
        PICKED_UP
    }
    */
/*
Kig færdig på det her, hvordan får jeg stadard pickup til at være 20 min fra nu, og derefter kunne ændre det selv
if de efterfølgende cunstructors??
 */

    public Order(LocalTime pickUpTime, String customerPhoneNr)  {
        this.id = nextId++;
        this.lines = new ArrayList<>();
        this.pickUpTime = pickUpTime;
        this.customerPhoneNr = customerPhoneNr;
        this.createdAt = LocalDateTime.now();
        this.isReady = false;
    }

    //Tilføj ordre linje
    public void addProduct(int quantity, Pizza pizza){
        lines.add(new OrderLine(quantity, pizza));

    }

    //Samlet pris for alle ordre linjer
    public double getTotalCostOfOrder(){
        double totalSum = 0;
        for (OrderLine line : lines){
            totalSum += line.getPrice() * line.getQuantity();
        }
        return totalSum;
    }


    //GETTERS
    public Customer getCustomer() {
        return customer;
    }
    public int getId(){
        return id;
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
        String s = "id " + id + "\n";
        for (OrderLine line : lines) {
            s += line + "\n";
        }
        return s;
    }

    public String getCustomerPhoneNr() {
        return customerPhoneNr;
    }
}