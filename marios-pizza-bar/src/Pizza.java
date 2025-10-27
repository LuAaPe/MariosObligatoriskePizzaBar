public class Pizza {
    private int id;
    private String name;
    private String[] ingredients;
    private double price;

    public Pizza(int id, String name, String[] ingredients, double price) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return String.format("%-80s", id + ". " + name + " (" + ingredientsToString() +")") + price + "kr";
    }
}



