import java.util.ArrayList;
import java.util.Comparator;

public class OrderList {
    private final ArrayList<Order> activeOrders = new ArrayList<>();
    private final ArrayList<Order> finishedOrders = new ArrayList<>();

    public void addOrder(Order o) {
        activeOrders.add(o);
    }

    public Order findOrderById(int id) {
        for (Order order : activeOrders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public ArrayList<Order> getActiveOrders() {
        ArrayList<Order> currentActive = new ArrayList<>();
        for (Order o : activeOrders) {
            if (!o.isReady()) {
                currentActive.add(o);
            }
        }

        currentActive.sort(Comparator.comparing(Order::getPickUpTime));

        return currentActive;
    }

    public ArrayList<Order> getFinishedOrders() {
        ArrayList<Order> historikOrders = new ArrayList<>();
        for (Order o : finishedOrders) {
            if (o.isReady()) {
                historikOrders.add(o);
            }
        }
        historikOrders.sort(Comparator.comparing(Order::getPickUpTime));

        return historikOrders;
    }


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
            finishedOrders.add(o);
            activeOrders.remove(o);
            customer.addCustomerOrder(o);
            customer.registerPurchase(o.getTotalCostOfOrder());
            return true;
        } else {
            o.setReady(true);
            System.out.println("Ordren fjernet fra kø og tilføjet til færdige ordre");
            finishedOrders.add(o);
            activeOrders.remove(o);
        }
        return true;

    }

    /* public ArrayList<Order> getActiveOrders(){
        for(int i);
    }*/

}
