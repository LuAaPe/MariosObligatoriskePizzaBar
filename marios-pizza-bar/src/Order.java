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
    private final LocalDateTime createdAt = LocalDateTime.now();
    private boolean isReady = false;
    /*    private enum status{
        NOT_READY,
        READY,
        PICKED_UP
    }
*/
/*
Kig færdig på det her, hvordan får jeg stadard pickup til at være 20 min fra nu, og derefter kunne ændre det selv
if de efterfølgende cunstructors??

asdafginodaf


 */
    public Order(){
        this(LocalTime.now().plusMinutes(20));
    }
    public Order() {
        this.id = nextId++;
        this.lines = new ArrayList<>();
        this.pickUpTime = LocalTime.now().plusMinutes(20);
        this.customer = null;
    }
    public Order(int time, int minut) {
        this();
        this.pickUpTime = LocalTime.of(time, minut);

    }
    public Order(String phoneNumber, int time, int minut) {
        this();
        this.pickUpTime = LocalTime.of(time, minut);
        this.customer = new Customer("Ukendt", phoneNumber);
    }
    public Order(String name, int time, int minut) {
        this();
        this.pickUpTime = LocalTime.of(time, minut);
        this.customer = new Customer(name, "Ukendt");
    }
    public Order(String name, String phoneNumber, int time, int minut) {
        this();
        this.pickUpTime = LocalTime.of(time, minut);
        this.customer = new Customer(name, phoneNumber);
    }





    //Tilføj ordre linje
    public void addOrderLine(OrderLine line) {
        lines.add(line);
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
}