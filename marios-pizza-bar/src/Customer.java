import java.util.ArrayList;

public class Customer {

    private final String name;
    private final String phoneNumber;
    private int orderCount;
    private double totalSpent;
    private ArrayList<Order> customerOrders = new ArrayList<>();

    //CONSTRUCTORE
    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //test!!
    public void addCustomerOrder(Order o){
        customerOrders.add(o);
    }


    //Mangler at udvide denne klasse til at fungere korrekt
    public void registerPurchase(double amount) {
        orderCount++;
        totalSpent += amount;
    }


    //GETTERS
    public String getName() {
        return name;
    }
    public int getOrderCount() {
        return orderCount;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getTotalSpent() {
        return totalSpent;
    }
    public ArrayList<Order> getCustomerOrders() {
        return customerOrders;
    }
}
