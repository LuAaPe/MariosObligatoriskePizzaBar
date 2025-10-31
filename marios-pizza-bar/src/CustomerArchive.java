import java.util.ArrayList;

public class CustomerArchive {
    private ArrayList<Customer> customers = new ArrayList<>();

    public Customer findByPhoneNumber(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
