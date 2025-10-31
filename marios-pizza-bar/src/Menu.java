import java.util.ArrayList;

public class Menu {
    private ArrayList<Pizza> menu;

    public Menu() {
        this.menu = new ArrayList<>();
    }


    public void addPizzaToMenu(Pizza pizza) {
        menu.add(pizza);
    }

    //Metode til at få pizza via Id, så pizza kan tilføjes til nemmere
    public Pizza findPizzaById(int id) {
        for (Pizza pizza : menu) {
            if (id == pizza.getID()) {
                return pizza;
            }
        }
        return null;
    }

    public String toString() {
        String s = "";
        for (Pizza pizza : menu) {
            s += pizza + "\n";
        }
        return s;
    }
}
