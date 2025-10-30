import java.util.ArrayList;

public class Customer {

    private final String name;
    private final String phoneNumber;
    private int orderCount;
    private double totalSpent;
    private final ArrayList<Order> customerOrders = new ArrayList<>();

    //CONSTRUCTORE
    public Customer(String phoneNumber) {
        this.name = null;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Indtast også et telefon nr.");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public void addCustomerOrder(Order o) {
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
    public double getDiscount(){
        if (orderCount >= 1){
            return 0.9;
        }
        return 1.0;
    }
}
