import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderList orderList = new OrderList();
        CustomerArchive customerList = new CustomerArchive();
        mainMenu(scanner, orderList, buildMenu(), customerList);
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
            try {
                System.out.println("Vælg en mulighed:");
                System.out.println("1. Menu");
                System.out.println("2. Ordre");
                System.out.println("3. Historik");
                System.out.println("4. Afslut");
                System.out.print("Valg: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        menuMenu(scanner, menu);
                        break;
                    case 2:
                        orderMenu(scanner, menu, orderList, customerList);
                        break;
                    case 3:
                        historicMenu(scanner, orderList);
                        break;
                    case 4:
                        System.out.println("Afslutter...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Fejl: Indtast venlist et tal");
                scanner.nextLine();
            }
        }
    }

    private static void menuMenu(Scanner scanner, Menu menu) {
        boolean isContinuing = true;
        while (isContinuing) {
            try {
                System.out.println("Vælg en mulighed:");
                System.out.println("1. Vis menu");
                System.out.println("2. Ændrer pris på pizza");
                System.out.println("3. Gå tilbage");
                System.out.print("Valg: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println(menu);
                        isContinuing = false;
                        break;
                    case 2:
                        changePriceOfPizza(scanner, menu);
                        isContinuing = false;
                        break;
                    case 3:
                        isContinuing = false;
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Fejl: indtast et tal");
                scanner.nextLine();
            }
        }
    }

    private static void orderMenu(Scanner scanner, Menu menu, OrderList orderList, CustomerArchive customerList) {
        boolean isContinuing = true;
        while (isContinuing) {
            try {
                System.out.println("Vælg en mulighed:");
                System.out.println("1. Opret ordre");
                System.out.println("2. Vis aktive ordre");
                System.out.println("3. Afslut ordre");
                System.out.println("4. Gå tilbage");
                System.out.print("Valg: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createOrder(scanner, orderList, menu, customerList);
                        isContinuing = false;
                        break;
                    case 2:
                        System.out.println(orderList.activeOrdersToString());
                        isContinuing = false;
                        break;
                    case 3:
                        finishOrder(scanner, orderList);
                        isContinuing = false;
                        break;
                    case 4:
                        isContinuing = false;
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Fejl: Indtast et tal");
                scanner.nextLine();
            }
        }
    }

    private static void historicMenu(Scanner scanner, OrderList orderList) {
        boolean isContinuing = true;
        while (isContinuing) {
            try {
                System.out.println("Vælg en mulighed:");
                System.out.println("1. Vis tidligere ordre");
                System.out.println("2. Vis dagens omsætning");
                System.out.println("3. Vis statistik");
                System.out.println("4. Gå tilbage");
                System.out.print("Valg: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println(orderList.historicOrdersToString());
                        isContinuing = false;
                        break;
                    case 2:
                        System.out.println("Der er i dag omsat for: " + String.format("%.2f", orderList.getTotalRevenue()) + "DKK");
                        isContinuing = false;
                        break;
                    case 3:
                        System.out.println(orderList.getTotalNrOfSoldPizzaPrPizza());
                        isContinuing = false;
                        break;
                    case 4:
                        isContinuing = false;
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Fejl: Indtast et tal");
                scanner.nextLine();
            }
        }
    }

    private static void createOrder(Scanner scanner, OrderList orderList, Menu menu, CustomerArchive customerList) {
        while (true) {
            try {
                Order order;
                System.out.print("Indtast telefon Nr: ");
                String phoneNr = scanner.nextLine().trim();

                if ((phoneNr.length() != 8) && (phoneNr.length() != 11)) {
                    System.out.println("Fejl: Indtast et telefon nr på 8 cifre eller 11 cifre");
                    System.out.println(" 8 cifre: 12345678");
                    System.out.println("11 cifre: +45 12345678");
                    continue;
                }
                Customer customer = customerList.findByPhoneNumber(phoneNr);
                if (customer == null) {
                    customer = new Customer(phoneNr);
                    customerList.addCustomer(customer);
                }
                while (true) {
                    System.out.print("Specificer afhentningstidpunkt (HH:MM) eller tryk ENTER for standard: ");
                    String time = scanner.nextLine().trim();
                    LocalTime pickUpTime;
                    if (!time.isEmpty()) {
                        try {
                            pickUpTime = LocalTime.parse(time);
                        } catch (Exception e) {
                            System.out.println("Fejl: Ugyldigt tidsformat, brug HH:MM format, fx. 17:45");
                            continue;
                        }
                        order = new Order(pickUpTime, customer);
                    } else {
                        order = new Order(customer);
                    }
                    break;
                }

                createOrderLine(scanner, order, menu);
                System.out.println(order);
                orderList.addOrder(order);
                break;
            } catch (Exception e) {
                System.out.println("Fejl ved oprettelse: " + e.getMessage());
            }
        }
    }

    private static void createOrderLine(Scanner scanner, Order order, Menu menu) {
        while (true) {
            try {
                System.out.print("Indtast pizza nummer (1-30): ");
                int pizzaId = scanner.nextInt();
                scanner.nextLine();

                if (pizzaId < 1 || pizzaId > 30) {
                    System.out.println("Fejl Indtast et tal mellem 1-30");
                    continue;
                }

                System.out.print("Indtast antal: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                if (quantity < 1) {
                    System.out.println("Fejl: Pizza antal skal være over 0");
                    continue;
                }
                order.addProduct(quantity, menu.findPizzaById(pizzaId));
                System.out.println(quantity + "x " + menu.findPizzaById(pizzaId).getName() + " tilføjet");


                System.out.print("Tilføj flere pizzaer (\"1\"= Ja \"-1\"= Nej): ");
                int addMore = scanner.nextInt();
                scanner.nextLine();

                if (addMore == -1) {
                    System.out.println();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Fejl: indtast et gyldigt tal");
                scanner.nextLine();
            }
        }
    }

    private static void changePriceOfPizza(Scanner scanner, Menu menu) {
        try {
            System.out.print("Indtast nr på pizza du ønsker at ændre prisen på: ");
            int pizzaNr = scanner.nextInt();

            if (pizzaNr > 30 || pizzaNr < 1) {
                System.out.println("Fejl: indtast et nr mellem 1-30");
                return;
            }


            Pizza pizza = menu.findPizzaById(pizzaNr);
            if (pizza == null) {
                System.out.println("Fejl: Pizza ikke fundet.");
                return;
            }


            System.out.println("Nuværende pris: " + String.format("%.2f", pizza.getPrice()) + " DKK");
            System.out.print("Hvad skal den nye pris være?: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();

            if (newPrice < 0 || newPrice > 250) {
                System.out.println("Fejl: Indtast beløb mellem 0 - 250");
                return;
            }
            pizza.setPrice(newPrice);
        } catch (InputMismatchException e) {
            System.out.println("Fejl: Indtast venligst et gyldigt tal.");
            scanner.nextLine();
        }
    }

    private static void finishOrder(Scanner scanner, OrderList orderList) {
        try {
            System.out.print("Indtast nr på den ordre, du ønsker at færdiggøre: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();

            Order orderToFinish = orderList.findOrderById(orderId);
            if (orderToFinish == null) {
                System.out.println("Fejl: Ordre med ID " + orderId + " findes ikke.");
                return;
            }

            orderList.completeOrder(orderId);
        } catch (InputMismatchException e) {
            System.out.println("Fejl: Indtast venligst et gyldigt tal.");
            scanner.nextLine();
        }
    }
}