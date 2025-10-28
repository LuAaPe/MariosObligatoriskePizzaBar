import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private static int nextOrderId = 1;
    private final int orderId;
    private Customer customer;
    private ArrayList<OrderLine> lines;
    private LocalTime pickUpTime;
    private final LocalTime createdAt;
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
        lines = new ArrayList<>();
        this.orderId = nextOrderId++;
        this.createdAt = LocalTime.now();
        this.pickUpTime = createdAt.plusMinutes(30);
    }
//    public Order(){
//        this(LocalTime.now().plusMinutes(20));
//    }
//
//    public Order() {
//        super();
//        this.id = nextId++;
//        this.lines = new ArrayList<>();
//        this.pickUpTime = LocalTime.now().plusMinutes(20);
//        this.customer = null;
//    }
//    public Order(int time, int minut) {
//        this();
//        this.pickUpTime = LocalTime.of(time, minut);
//
//    }
//    public Order(String phoneNumber, int time, int minut) {
//        this();
//        this.pickUpTime = LocalTime.of(time, minut);
//        this.customer = new Customer("Ukendt", phoneNumber);
//    }
//    public Order(String name, int time, int minut) {
//        this();
//        this.pickUpTime = LocalTime.of(time, minut);
//        this.customer = new Customer(name, "Ukendt");
//    }
//    public Order(String name, String phoneNumber, int time, int minut) {
//        this();
//        this.pickUpTime = LocalTime.of(time, minut);
//        this.customer = new Customer(name, phoneNumber);
//    }





    //Tilføj ordre linje
    public void addOrderLine(OrderLine line) {
        lines.add(line);
    }
    public void addProduct(int quantity, Pizza pizza){
        addOrderLine(new OrderLine(quantity, pizza));

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
        return orderId;
    }
    public LocalTime getPickUpTime() {
        return pickUpTime;
    }
    public boolean isReady() {
        return isReady;
    }
    public LocalTime getCreatedAt() {
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
        String s = "id " + orderId + "\n";
        for (OrderLine line : lines) {
            s += line + "\n";
        }
        return s;
    }
}