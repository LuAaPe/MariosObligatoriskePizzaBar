public class Pizza {
    private final int id;
    private final String name;
    private String[] ingredients;
    private double price;

    public Pizza(int id, String name, String[] ingredients, double price) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    //Getters
    public int getID() {
        return id;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String ingredientsToString() {
        String ingredient = "";
        for (int i = 0; i < ingredients.length; i++) {
            if (i == ingredients.length - 1) {
                ingredient += ingredients[i];
            } else {
                ingredient += ingredients[i] + ", ";

            }
        }
        return ingredient;
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("Prisen for " + name + " er nu sat til" + price + " kr");
    }

    @Override
    public String toString() {
        return String.format("%-80s", id + ". " + name + " (" + ingredientsToString() + ")") + String.format("%.2f",price) + "kr";
    }
}



