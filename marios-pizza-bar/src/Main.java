public class Main {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        Menu menu = buildMenu();




        System.out.println(menu);


/*
        System.out.println("Menu");
        System.out.println(menu);


        Order john = new Order(1, "John,","22939345" );
        OrderLine linje1 = new OrderLine(2,p23);
        OrderLine linje2 = new OrderLine(3,p3);
        john.addOrderLine(linje1);
        john.addOrderLine(linje2);
        System.out.println(john);


        Order lucas = new Order(2, "Lucas,","22939345" );
        OrderLine linje3 = new OrderLine(2,p13);
        OrderLine linje4 = new OrderLine(3,p5);
        lucas.addOrderLine(linje3);
        lucas.addOrderLine(linje4);
        System.out.println(lucas);
/*
        Order order1 = new Order();
        order1.add(new OrderLine(2, p1));


        orderList.add(order1);
*/




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
}
/*Mangler at få implementeret at kunder bliver oprettet og tilføjet til arkivet ved bestilling
Har ikke rigtig fået kigget på menum, synes det er underligt at tilføje alle pizza i MAIN, hvad skal der gøres her(ny klasse)


 */