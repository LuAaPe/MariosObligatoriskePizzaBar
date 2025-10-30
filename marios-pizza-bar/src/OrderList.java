import java.util.ArrayList;
import java.util.Comparator;

public class OrderList {
    private final ArrayList<Order> orders;

    public OrderList() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getOrderNr() == id) {
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
        return historicOrders;
    }

    public double getTotalRevenue() {
        double totalSumOfAllSoldPizza = 0;
        for (Order order : getHistoricOrders()) {
            totalSumOfAllSoldPizza += order.getTotalCostOfOrder();
        }
        return totalSumOfAllSoldPizza;
    }


    public String getTotalNrOfSoldPizzaPrPizza() {
        int[] amount = new int[30];
        for (Order order : getHistoricOrders()) {
            for (OrderLine orderLine : order.getLines()) {
                amount[orderLine.getPizzaId() - 1] += orderLine.getQuantity();
            }
        }
        String myStr = "";
        for (int i = 1; i < amount.length + 1; i++) {
            myStr += "Der er solgt: " + amount[i - 1] + "x Nr. " + i + "\n";
        }
        return myStr;
    }

    public void completeOrder(int id) {
        Order order = findOrderById(id);
        if (order == null) {
            System.out.println("Ordre ikke fundet");
            return;
        } else if (order.isReady()) {
            System.out.println("Ordren er allerede sat som færdig");
            return;
        } else if (order.getCustomer() != null) {
            System.out.println("Ordren fjernet fra kø og tilføjet til færdige ordre");
            System.out.println("Ordren er tilføjet til kundens profil");
            order.setReady(true);
            order.getCustomer().addCustomerOrder(order);
            order.getCustomer().registerPurchase(order.getTotalCostOfOrder());
            return;
        } else {
            order.setReady(true);
            System.out.println("Ordren fjernet fra kø og tilføjet til færdige ordre");
        }
    }

    public String activeOrdersToString() {
        return orderlistToString(getActiveOrders());
    }

    public String historicOrdersToString() {
        return orderlistToString(getHistoricOrders());
    }

    private String orderlistToString(ArrayList<Order> orders) {
        String s = "";
        for (Order order : orders) {
            s += order + "\n";
        }
        return s;
    }
}
