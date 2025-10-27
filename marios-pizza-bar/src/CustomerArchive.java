import java.util.ArrayList;

public class CustomerArchive {

    private ArrayList<Customer> customers = new ArrayList<>();

    public Customer findByPhoneNumber(String phoneNumber){
        for (Customer c : customers){
            if (c.getPhoneNumber().equals(phoneNumber)){
                return c;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }
}
