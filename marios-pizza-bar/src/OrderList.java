import java.util.ArrayList;
import java.util.Comparator;

public class OrderList {
    private final ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
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
        for (Order order : orders) {
            if (!order.isReady()) {
                currentActive.add(order);
            }
        }

        currentActive.sort(Comparator.comparing(Order::getPickUpTime));

        return currentActive;
    }

    public ArrayList<Order> getHistoricOrders() {
        ArrayList<Order> historicOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.isReady()) {
                historicOrders.add(order);
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
        Order order = findOrderById(id);
        if (order == null) {
            System.out.println("Ordre ikke fundet");
            return false;
        } else if (order.isReady()) {
            System.out.println("Ordren er allerede sat som færdig");
            return false;
        } else if (order.getCustomer() != null) {
            Customer customer = order.getCustomer();
            System.out.println("Ordren fjernet fra kø og tilføjet til færdige ordre");
            System.out.println("Ordren er tilføjet til kundens profil");
            order.setReady(true);
            customer.addCustomerOrder(order);
            customer.registerPurchase(order.getTotalCostOfOrder());
            return true;
        } else {
            order.setReady(true);
            System.out.println("Ordren fjernet fra kø og tilføjet til færdige ordre");
        }
        return true;

    }

    /* public ArrayList<Order> getActiveOrders(){
        for(int i);
    }*/

}
