import java.util.ArrayList;
import java.util.Comparator;

public class OrderList {
    private final ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order o) {
        orders.add(o);
    }

    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public ArrayList<Order> getActiveOrders() {
        ArrayList<Order> currentActive = new ArrayList<>();
        for (Order o : orders) {
            if (!o.isReady()) {
                currentActive.add(o);
            }
        }

        currentActive.sort(Comparator.comparing(Order::getPickUpTime));

        return currentActive;
    }

    public ArrayList<Order> getHistoricOrders() {
        ArrayList<Order> historicOrders = new ArrayList<>();
        for (Order o : orders) {
            if (o.isReady()) {
                historicOrders.add(o);
            }
        }
        historicOrders.sort(Comparator.comparing(Order::getPickUpTime));

        return historicOrders;
    }

    /*
    public ArrayList<Order> getOrdersByCustomer(){
        for(Order o : orders){

        }
    }
*/


    public boolean completeOrder(int id) {
        Order o = findOrderById(id);
        if (o == null) {
            System.out.println("Ordre ikke fundet");
            return false;
        } else if (o.isReady()) {
            System.out.println("Ordren er allerede sat som færdig");
            return false;
        } else if (o.getCustomer() != null) {
            Customer customer = o.getCustomer();
            System.out.println("Ordren fjernet fra kø og tilføjet til færdige ordre");
            System.out.println("Ordren er tilføjet til kundens profil");
            o.setReady(true);
            customer.addCustomerOrder(o);
            customer.registerPurchase(o.getTotalCostOfOrder());
            return true;
        } else {
            o.setReady(true);
            System.out.println("Ordren fjernet fra kø og tilføjet til færdige ordre");
        }
        return true;

    }

    /* public ArrayList<Order> getActiveOrders(){
        for(int i);
    }*/

}
