import module java.base;

public class Main {
    void main() {
        Scanner scanner = new Scanner(System.in);
        OrderList orderList = new OrderList();
        Menu menu = buildMenu();
        CustomerArchive customerList = new CustomerArchive();
        mainMenu(scanner, orderList, menu, customerList);
    }

    private static Menu buildMenu() {
        Menu menu = new Menu();

        menu.addPizzaToMenu(new Pizza(1, "Margarita", new String[]{"Tomat", "Ost"}, 233));
        menu.addPizzaToMenu(new Pizza(2, "Amerikaner", new String[]{"Tomatsauce", "Ost", "Oksefars", "Oregano"}, 53));
        menu.addPizzaToMenu(new Pizza(3, "Hawaii", new String[]{"Tomatsauce", "Ost", "Ananas", "Skinke"}, 125));
        menu.addPizzaToMenu(new Pizza(4, "Vesuvio", new String[]{"Tomasauce", "Ost", "Skinke"}, 75));
        menu.addPizzaToMenu(new Pizza(5, "Tivio", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 76));
        menu.addPizzaToMenu(new Pizza(6, "Luksus", new String[]{"Tomasauce", "Ost", "Kebab", "Bernaise"}, 100));
        menu.addPizzaToMenu(new Pizza(7, "Dennis special", new String[]{"Tomasauce", "Ost", "Kebab", "Pepperoni"}, 76));
        menu.addPizzaToMenu(new Pizza(8, "Venezia", new String[]{"Tomatsauce", "Ost", "Skinke", "Bacon", "Oregano"}, 76));
        menu.addPizzaToMenu(new Pizza(9, "Silvia", new String[]{"Tomatsauce", "Ost", "Pepperoni", "Rød peber", "Løg", "Oregano"}, 61));
        menu.addPizzaToMenu(new Pizza(10, "Messi", new String[]{"Tomasauce", "Ost", "Skinke", "Pepperoni", "Dressing"}, 75));
        menu.addPizzaToMenu(new Pizza(11, "Dennis", new String[]{"Tomasauce", "Ost", "Skinke", "kødsauce", "Oregano"}, 76));
        menu.addPizzaToMenu(new Pizza(12, "Speicale", new String[]{"Tomasauce", "Ost", "Kylling", "Pesto", "Dressing"}, 82));
        menu.addPizzaToMenu(new Pizza(13, "Mafia", new String[]{"Tomasauce", "Ost", "Kebab", "Løg"}, 120));
        menu.addPizzaToMenu(new Pizza(14, "Barca", new String[]{"Tomasauce", "Ost", "Kebab", "Kylling", "Løg", "Dressing"}, 76));
        menu.addPizzaToMenu(new Pizza(15, "Le Blissola", new String[]{"Tomasauce", "Ost", "Skinke", " Champignon", "Oregano"}, 76));
        menu.addPizzaToMenu(new Pizza(16, "Capricciosa", new String[]{"Tomasauce", "Ost", "Skinke", "Pepperoni", "Dressing"}, 125));
        menu.addPizzaToMenu(new Pizza(17, "La Victoria", new String[]{"Tomasauce", "Ost", "Skinke"}, 79));
        menu.addPizzaToMenu(new Pizza(18, "Carbona", new String[]{"Tomasauce", "Ost", "Kødsauce", "Spaghetti", "Cocktailpølser", "Oregano"}, 65));
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
                    IO.println(menu);
                    break;
                case 2:
                    createOrder(scanner, orderList, menu, customerList);
                    break;
                case 3:
                    IO.print(orderList.activeOrdersToString());
                    break;
                case 4:
                    IO.print(orderList.historicOrdersToString());
                    break;
                case 5:
                    changePriceOfPizza(scanner, menu);
                    break;
                case 6:
                    IO.println("Der er i dag omsat for: " + orderList.getTotalRevenue() + "DKK");
                    break;
                case 7:
                    finishOrder(scanner, orderList);
                    break;
                case 8:
                    IO.println(orderList.getTotalNrOfSoldPizzaPrPizza());
                    break;
                case 9:
                    IO.println("Afslutter...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    IO.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private static void mainMenuChoices() {
        IO.println("Vælg en mulighed:");
        IO.println("1. Vis menu");
        IO.println("2. Opret ordre");
        IO.println("3. Vis aktive ordre");
        IO.println("4. Vis tidligere ordre");
        IO.println("5. Ændre pris på Pizzaer på menu");
        IO.println("6. Vis dagens omsætning");
        IO.println("7. Afslut ordre");
        IO.println("8. Statistik");
        IO.println("9. Afslut");
    }

    private static void createOrder(Scanner scanner, OrderList orderList, Menu menu, CustomerArchive customerList) {
        IO.println("Indtast afhentningstidpunkt (Timer:Minutter)");
        String time = scanner.nextLine();
        LocalTime pickUpTime = LocalTime.parse(time);
        IO.println("Indtast telefon Nr.");
        String phoneNr = scanner.nextLine();
        if ((phoneNr.length() != 8) && (phoneNr.length() != 11)) {
            throw new IllegalArgumentException("Fejl: Indtast et telon nr på 8 eller 11 cifre\n " +
                    "8 Cifre: 12345678\n" +
                    "11 Cifre: +4512345678");
        }
        Order order;

        if (customerList.findByPhoneNumber(phoneNr) == null) {
            Customer newCustomer = new Customer(phoneNr);
            customerList.addCustomer(newCustomer);
            order = new Order(pickUpTime, newCustomer);
        } else {
            order = new Order(pickUpTime, customerList.findByPhoneNumber(phoneNr));
        }
        createOrderLine(scanner, order, menu);
        IO.println(order);
        orderList.addOrder(order);
    }

    private static void createOrderLine(Scanner scanner, Order order, Menu menu) {
        while (true) {
            IO.println("Indtast pizza nummer:");
            int pizzaId = scanner.nextInt();
            if (pizzaId < 1 || pizzaId > 30) {
                throw new IllegalArgumentException("Fejl: indtast et tal mellem 1-30");
            }
            scanner.nextLine();
            IO.println("Indtast antal:");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            order.addProduct(quantity, menu.findPizzaById(pizzaId));
            IO.println("Tast \"1\" for at tilføje mere eller tast \"-1\" for at afslutte");
            int addMore = scanner.nextInt();
            if (addMore == -1) {
                break;
            }
        }
    }

    private static void changePriceOfPizza(Scanner scanner, Menu menu) {
        IO.println("Indtast nr på pizza du ønsker at ændre prisen på");
        int pizzaNr = scanner.nextInt();
        if (pizzaNr > 30 || pizzaNr < 1) {
            throw new IllegalArgumentException("Fejl: indtast et nr mellem 1-30");
        }
        Pizza pizza = menu.findPizzaById(pizzaNr);
        IO.println("Hvad skal prisen ændres til?");
        double newPrice = scanner.nextDouble();
        if (newPrice < 0 || newPrice > 250) {
            throw new IllegalArgumentException("Fejl: Indtast beløb mellem 0 - 250");
        }
        pizza.setPrice(newPrice);
    }

    private static void finishOrder(Scanner scanner, OrderList orderList) {
        IO.println("Indtast nr på den order, du ønsker at færdiggøre");
        int orderId = scanner.nextInt();
        Order orderToFinish = orderList.findOrderById(orderId);
        if (orderToFinish == null) {
            throw new IllegalArgumentException("Fejl: Ugyldigt ordre nr.");
        }
        orderList.completeOrder(orderId);
    }
}