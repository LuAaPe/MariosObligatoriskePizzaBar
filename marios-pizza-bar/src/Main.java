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

        Pizza p1 = new Pizza(1, "Margarita", new String[]{"tomat", "ost"}, 233);
        Pizza p2 = new Pizza(2, "Amerikaner", new String[]{"tomatsauce", "ost", "oksefars", "oregano"}, 53);
        Pizza p3 = new Pizza(3, "Hawaii", new String[]{"tomatsauce", "ost", "ananas", "skinke"}, 125);
        Pizza p4 = new Pizza(4, "Vesuvio", new String[]{"Tomasauce", "Ost", "Skinke"}, 75);
        Pizza p5 = new Pizza(5, "Tivio", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 76);
        Pizza p6 = new Pizza(6, "Luksus", new String[]{"Tomasauce", "Ost", "Kebab", "Bernaise"}, 100);
        Pizza p7 = new Pizza(7, "Dennis special", new String[]{"Tomasauce", "Ost", "Kebab", "Pepperoni"}, 76);
        Pizza p8 = new Pizza(8, "Venezia", new String[]{"tomatsauce, ost, skinke, bacon og oregano"}, 76);
        Pizza p9 = new Pizza(9, "Silvia", new String[]{"Tomatsauce", "ost", "pepperoni", "rød peber", "løg", "oregano"}, 61);
        Pizza p10 = new Pizza(10, "Messi", new String[]{"Tomasauce", "Ost", "Skinke", "Pepperoni", "Dressing"}, 75);
        Pizza p11 = new Pizza(11, "Dennis", new String[]{"Tomasauce", "Ost", "Skinke", "kødsauce", "Oregano"}, 76);
        Pizza p12 = new Pizza(12, "Speicale", new String[]{"Tomasauce", "Ost", "Kylling", "pesto", "Dressing"}, 82);
        Pizza p13 = new Pizza(13, "Mafia", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 120);
        Pizza p14 = new Pizza(14, "Barca", new String[]{"Tomasauce", "Ost", "Kebab", "Kylling", "Løg", "Dressing"}, 76);
        Pizza p15 = new Pizza(15, "Le Blissola", new String[]{"Tomasauce", "Ost", "skinke", " champignon", "oregano"}, 76);
        Pizza p16 = new Pizza(16, "Capricciosa", new String[]{"Tomasauce", "Ost", "Skinke", "Pepperoni", "Dressing"}, 125);
        Pizza p17 = new Pizza(17, "La Victoria", new String[]{"Tomasauce", "Ost", "Skinke", ""}, 79);
        Pizza p18 = new Pizza(18, "Carbona", new String[]{"Tomasauce", "Ost", "kødsauce", "spaghetti", "cocktailpølser", "oregano"}, 65);
        Pizza p19 = new Pizza(19, "Bella Roma", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 68);
        Pizza p20 = new Pizza(20, "Napolitana", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 100);
        Pizza p21 = new Pizza(21, "Amore di Pizza", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 99);
        Pizza p22 = new Pizza(22, "Cacciatore", new String[]{"Tomasauce", "Ost", "Pepperoni", "Dressing", "Oregano"}, 57);
        Pizza p23 = new Pizza(23, "Green Garden", new String[]{"Tomasauce", "Ost", "Skinke"}, 89);
        Pizza p24 = new Pizza(24, "Hot Volcano", new String[]{"Tomasauce", "Ost", "Pepperoni"}, 77);
        Pizza p25 = new Pizza(25, "El Diablo", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 69);
        Pizza p26 = new Pizza(26, "Baconator", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 110);
        Pizza p27 = new Pizza(27, "Toronfo", new String[]{"Tomasauce", "Ost", "skinke", "bacon", "kebab", "chili", "oregano"}, 61);
        Pizza p28 = new Pizza(28, "The Don", new String[]{"Tomasauce", "Ost", "Skinke", "Pepperoni", "Dressing"}, 132);
        Pizza p29 = new Pizza(29, "Adan special", new String[]{"Tomasauce", "Ost", "steakstrimler", "jalapenos"}, 135);
        Pizza p30 = new Pizza(30, "John Doe", new String[]{"Tomasauce", "Ost", "Pepperoni"}, 120);


        menu.addPizzaToMenu(p1);
        menu.addPizzaToMenu(p2);
        menu.addPizzaToMenu(p3);
        menu.addPizzaToMenu(p4);
        menu.addPizzaToMenu(p5);
        menu.addPizzaToMenu(p6);
        menu.addPizzaToMenu(p7);
        menu.addPizzaToMenu(p8);
        menu.addPizzaToMenu(p9);
        menu.addPizzaToMenu(p10);
        menu.addPizzaToMenu(p11);
        menu.addPizzaToMenu(p12);
        menu.addPizzaToMenu(p13);
        menu.addPizzaToMenu(p14);
        menu.addPizzaToMenu(p15);
        menu.addPizzaToMenu(p16);
        menu.addPizzaToMenu(p17);
        menu.addPizzaToMenu(p18);
        menu.addPizzaToMenu(p19);
        menu.addPizzaToMenu(p20);
        menu.addPizzaToMenu(p21);
        menu.addPizzaToMenu(p22);
        menu.addPizzaToMenu(p23);
        menu.addPizzaToMenu(p24);
        menu.addPizzaToMenu(p25);
        menu.addPizzaToMenu(p26);
        menu.addPizzaToMenu(p27);
        menu.addPizzaToMenu(p28);
        menu.addPizzaToMenu(p29);
        menu.addPizzaToMenu(p30);
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
                    scanner.nextLine();
                    break;
                case 2:
                    createOrder(scanner, orderList, menu, customerList);
                    break;
                case 3:
                    System.out.println(orderList.activeOrdersToString());
                    break;
                case 4:
                    System.out.println(orderList.historicOrdersToString());
                    break;
                case 5:
                    changePriceOfPizza(scanner, menu);
                    break;
                case 6:
                    System.out.println("Der er i dag omsat for: " + orderList.getTotalRevenue() + "DKK");
                    break;
                case 7:
                    finishOrder(scanner,orderList);
                    break;
                case 8:
                    System.out.println(orderList.getTotalNrOfSoldPizzaPrPizza());
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

    private static void mainMenuChoices(){
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
        Order order;
        Customer knowCustomer = customerList.findByPhoneNumber(phoneNr);
        if (knowCustomer == null){
            Customer customer = new Customer(phoneNr);
            order = new Order(pickUpTime, customer);
        } else {
            order = new Order(pickUpTime, knowCustomer);
        }
        createOrderLine(scanner,order,menu);
        System.out.println(order);
        orderList.addOrder(order);
    }
    private static void createOrderLine(Scanner scanner, Order order, Menu menu){
        while (true) {
            System.out.println("Indtast pizza nummer:");
            int pizzaId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Indtast antal:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            order.addProduct(quantity, menu.findPizzaById(pizzaId));
            System.out.println("Tast \"1\" for at tilføje mere eller tast \"-1\" for at afslutte");
            int addMore = scanner.nextInt();
            if (addMore == -1){
                break;
            }
        }
    }
    private static void changePriceOfPizza(Scanner scanner, Menu menu){
        System.out.println("Indtast nr på pizza du ønsker at ændre prisen på");
        int pizzaNr = scanner.nextInt();
        Pizza pizza = menu.findPizzaById(pizzaNr);
        System.out.println("Hvad skal prisen ændres til?");
        double newPrice = scanner.nextInt();
        pizza.setPrice(newPrice);
    }
    private static void finishOrder(Scanner scanner, OrderList orderList){
        System.out.println("Indtast nr på den order, du ønsker at færdiggøre");
        int orderId = scanner.nextInt();
        orderList.completeOrder(orderId);
    }
}