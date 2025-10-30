import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderList orderList = new OrderList();
        Menu menu = buildMenu();
        CustomerArchive customerList = new CustomerArchive();
        mainMenu(scanner, orderList, menu, customerList);
    }

    private static Menu buildMenu() {
        Menu menu = new Menu();

        menu.addPizzaToMenu(new Pizza(1, "Margarita", new String[]{"tomat", "ost"}, 233));
        menu.addPizzaToMenu(new Pizza(2, "Amerikaner", new String[]{"tomatsauce", "ost", "oksefars", "oregano"}, 53));
        menu.addPizzaToMenu(new Pizza(3, "Hawaii", new String[]{"tomatsauce", "ost", "ananas", "skinke"}, 125));
        menu.addPizzaToMenu(new Pizza(4, "Vesuvio", new String[]{"Tomasauce", "Ost", "Skinke"}, 75));
        menu.addPizzaToMenu(new Pizza(5, "Tivio", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 76));
        menu.addPizzaToMenu(new Pizza(6, "Luksus", new String[]{"Tomasauce", "Ost", "Kebab", "Bernaise"}, 100));
        menu.addPizzaToMenu(new Pizza(7, "Dennis special", new String[]{"Tomasauce", "Ost", "Kebab", "Pepperoni"}, 76));
        menu.addPizzaToMenu(new Pizza(8, "Venezia", new String[]{"tomatsauce, ost, skinke, bacon og oregano"}, 76));
        menu.addPizzaToMenu(new Pizza(9, "Silvia", new String[]{"Tomatsauce", "ost", "pepperoni", "rød peber", "løg", "oregano"}, 61));
        menu.addPizzaToMenu(new Pizza(10, "Messi", new String[]{"Tomasauce", "Ost", "Skinke", "Pepperoni", "Dressing"}, 75));
        menu.addPizzaToMenu(new Pizza(11, "Dennis", new String[]{"Tomasauce", "Ost", "Skinke", "kødsauce", "Oregano"}, 76));
        menu.addPizzaToMenu(new Pizza(12, "Speicale", new String[]{"Tomasauce", "Ost", "Kylling", "pesto", "Dressing"}, 82));
        menu.addPizzaToMenu(new Pizza(13, "Mafia", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 120));
        menu.addPizzaToMenu(new Pizza(14, "Barca", new String[]{"Tomasauce", "Ost", "Kebab", "Kylling", "Løg", "Dressing"}, 76));
        menu.addPizzaToMenu(new Pizza(15, "Le Blissola", new String[]{"Tomasauce", "Ost", "skinke", " champignon", "oregano"}, 76));
        menu.addPizzaToMenu(new Pizza(16, "Capricciosa", new String[]{"Tomasauce", "Ost", "Skinke", "Pepperoni", "Dressing"}, 125));
        menu.addPizzaToMenu(new Pizza(17, "La Victoria", new String[]{"Tomasauce", "Ost", "Skinke", ""}, 79));
        menu.addPizzaToMenu(new Pizza(18, "Carbona", new String[]{"Tomasauce", "Ost", "kødsauce", "spaghetti", "cocktailpølser", "oregano"}, 65));
        menu.addPizzaToMenu(new Pizza(19, "Bella Roma", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 68));
        menu.addPizzaToMenu(new Pizza(20, "Napolitana", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 100));
        menu.addPizzaToMenu(new Pizza(21, "Amore di Pizza", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 99));
        menu.addPizzaToMenu(new Pizza(22, "Cacciatore", new String[]{"Tomasauce", "Ost", "Pepperoni", "Dressing", "Oregano"}, 57));
        menu.addPizzaToMenu(new Pizza(23, "Green Garden", new String[]{"Tomasauce", "Ost", "Skinke"}, 89));
        menu.addPizzaToMenu(new Pizza(24, "Hot Volcano", new String[]{"Tomasauce", "Ost", "Pepperoni"}, 77));
        menu.addPizzaToMenu(new Pizza(25, "El Diablo", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 69));
        menu.addPizzaToMenu(new Pizza(26, "Baconator", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 110));
        menu.addPizzaToMenu(new Pizza(27, "Toronfo", new String[]{"Tomasauce", "Ost", "skinke", "bacon", "kebab", "chili", "oregano"}, 61));
        menu.addPizzaToMenu(new Pizza(28, "The Don", new String[]{"Tomasauce", "Ost", "Skinke", "Pepperoni", "Dressing"}, 132));
        menu.addPizzaToMenu(new Pizza(29, "Adan special", new String[]{"Tomasauce", "Ost", "steakstrimler", "jalapenos"}, 135));
        menu.addPizzaToMenu(new Pizza(30, "John Doe", new String[]{"Tomasauce", "Ost", "Pepperoni"}, 120));
        return menu;
    }

    private static void mainMenu(Scanner scanner, OrderList orderList, Menu menu, CustomerArchive customerList) {
        while (true) {
            mainMenuChoices();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(menu);
                    break;
                case 2:
                    createOrder(scanner, orderList, menu, customerList);
                    break;
                case 3:
                    System.out.print(orderList.activeOrdersToString());
                    break;
                case 4:
                    System.out.print(orderList.historicOrdersToString());
                    break;
                case 5:
                    changePriceOfPizza(scanner, menu);
                    break;
                case 6:
                    System.out.println("Der er i dag omsat for: " + orderList.getTotalRevenue() + "DKK");
                    break;
                case 7:
                    finishOrder(scanner, orderList);
                    break;
                case 8:
                    System.out.println(orderList.getTotalNrOfSoldPizzaPrPizza());
                    break;
                case 9:
                    System.out.println("Afslutter...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }
    private static void mainMenuChoices() {
        System.out.println("Vælg en mulighed:");
        System.out.println("1. Vis menu");
        System.out.println("2. Opret ordre");
        System.out.println("3. Vis aktive ordre");
        System.out.println("4. Vis tidligere ordre");
        System.out.println("5. Ændre pris på Pizzaer på menu");
        System.out.println("6. Vis dagens omsætning");
        System.out.println("7. Afslut ordre");
        System.out.println("8. Statistik");
        System.out.println("9. Afslut");
    }

    private static void createOrder(Scanner scanner, OrderList orderList, Menu menu, CustomerArchive customerList) {
        System.out.println("Indtast afhentningstidpunkt (Timer:Minutter)");
        String time = scanner.nextLine();
        LocalTime pickUpTime = LocalTime.parse(time);
        System.out.println("Indtast telefon Nr.");
        String phoneNr = scanner.nextLine();
        if ((phoneNr.length() != 8) && (phoneNr.length() != 11)){
            throw new IllegalArgumentException("Fejl: Indtast et telon nr på 8 eller 11 cifre\n " +
                    "8 Cifre: 12345678\n" +
                    "11 Cifre: +4512345678");

        }
        Order order;
        Customer knowCustomer = customerList.findByPhoneNumber(phoneNr);
        if (knowCustomer == null) {
            Customer newCustomer = new Customer(phoneNr);
            order = new Order(pickUpTime, newCustomer);
        } else {
            order = new Order(pickUpTime, knowCustomer);
        }
        createOrderLine(scanner, order, menu);
        System.out.println(order);
        orderList.addOrder(order);
    }

    private static void createOrderLine(Scanner scanner, Order order, Menu menu) {
        while (true) {
            System.out.println("Indtast pizza nummer:");
            int pizzaId = scanner.nextInt();
            if (pizzaId < 1 || pizzaId > 30){
                throw new IllegalArgumentException("Fejl: indtast et tal mellem 1-30");
            }
            scanner.nextLine();
            System.out.println("Indtast antal:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            order.addProduct(quantity, menu.findPizzaById(pizzaId));
            System.out.println("Tast \"1\" for at tilføje mere eller tast \"-1\" for at afslutte");
            int addMore = scanner.nextInt();
            if (addMore == -1) {
                break;
            }
        }
    }

    private static void changePriceOfPizza(Scanner scanner, Menu menu) {
        System.out.println("Indtast nr på pizza du ønsker at ændre prisen på");
        int pizzaNr = scanner.nextInt();
        if (pizzaNr > 30 || pizzaNr < 1){
            throw new IllegalArgumentException("Fejl: indtast et nr mellem 1-30");
        }
        Pizza pizza = menu.findPizzaById(pizzaNr);
        System.out.println("Hvad skal prisen ændres til?");
        double newPrice = scanner.nextDouble();
        if (newPrice < 0 || newPrice > 250){
            throw new IllegalArgumentException("Fejl: Indtast beløb mellem 0 - 250");
        }
        pizza.setPrice(newPrice);
    }

    private static void finishOrder(Scanner scanner, OrderList orderList) {
        System.out.println("Indtast nr på den order, du ønsker at færdiggøre");
        int orderId = scanner.nextInt();
        Order orderToFinish = orderList.findOrderById(orderId);
        if (orderToFinish == null){
            throw new IllegalArgumentException("Fejl: Ugyldigt ordre nr.");
        }
        orderList.completeOrder(orderId);
    }
}