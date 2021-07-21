import java.util.Scanner;

// Exericse 1
class Ingredient {
  public String name;
  public String measurementUnit;

  public Ingredient(String n, String u) {
    name = n;
    measurementUnit = u;
  }
}

// Exericse 2
class W4Ex2 {
  public static void main(String[] args) {
    Ingredient[] ingredients = new Ingredient[4];
    ingredients[0] = new Ingredient("water", "spoon");
    ingredients[1] = new Ingredient("water", "teaspoon");
    ingredients[2] = new Ingredient("sugar", "mg");
    ingredients[3] = new Ingredient("chicken", "kg");
    for (Ingredient i : ingredients) {
      System.out.printf("\nIngredient name: %s, measurement unit: %s", i.name, i.measurementUnit);
    }
  }
}

// Exericse 3
class Ingredient2 {
  public String name;
  private String measurementUnit;

  public Ingredient2(String n, String u) {
    name = n;
    this.setMeasurementUnit(u);
  }

  public String getMeasurementUnit() {
    return measurementUnit;
  }

  public void setMeasurementUnit(String u) {
    // code to reject invalid measurement units here
    // for now, assume that we have a list of invalid values
    String[] invalidUnits = {"asdfgh", "tic-tac-toe"};
    for (String invalid : invalidUnits) {
      if (invalid.equals(u)) {
        // invalid, do nothing, just return
        return;
      }
    }
    measurementUnit = u;
  }
}

// Exericse 3 - demo call
class W4Ex3 {
  public static void main(String[] args) {
    // Assign an invalid measurement unit
    Ingredient2 ingredient = new Ingredient2("water", "tic-tac-toe");
    System.out.printf("\nIngredient name: %s, measurement unit: %s", ingredient.name,
        ingredient.getMeasurementUnit());
    // Assign correct value
    ingredient.setMeasurementUnit("spoon");
    System.out.printf("\nIngredient name: %s, measurement unit: %s", ingredient.name,
        ingredient.getMeasurementUnit());
  }
}

// Exercise 4
class RecipeComponent {
  // each recipe component contains an ingredient and amount
  public Ingredient ingredient;
  public double amount;

  public RecipeComponent(Ingredient i, double a) {
    ingredient = i;
    amount = a;
  }
}

class Recipe {
  // each recipe contains a name and an array of recipe component
  public String name;
  public RecipeComponent[] components;

  // create a recipe with a name and a number of components
  public Recipe(String n, int number) {
    name = n;
    components = new RecipeComponent[number];
  }

  // add a new component from user inputs
  // the component is added at index idx
  public void addComponent(int idx) {
    // stop immediately when detecting invalid index
    if (idx < 0 || idx >= components.length) {
      return;
    }

    Scanner sc = new Scanner(System.in);
    // Create a new ingredient
    System.out.print("Ingredient name: ");
    String name = sc.nextLine();
    System.out.print("Measurement unit: ");
    String unit = sc.nextLine();
    Ingredient ing = new Ingredient(name, unit);

    // Get amount
    System.out.print("Amount: ");
    double amount = sc.nextDouble();

    // Create a recipe component at index idx
    RecipeComponent cmp = new RecipeComponent(ing, amount);
    components[idx] = cmp;
  }

  public void displayRecipe() {
    for (RecipeComponent cmp : components) {
      System.out.printf("\nIngredient name: %s, measurement unit: %s, amount %.2f",
          cmp.ingredient.name, cmp.ingredient.measurementUnit, cmp.amount);
    }
  }
}

// Demo of using Recipe class
class W4Ex4 {
  public static void main(String[] args) {
    // Assume we want to create a recipe with 3 components
    // You can change the below code to read the number of users
    int componentCount = 3;
    Recipe re = new Recipe("scone", 3);
    for (int i = 0; i < componentCount; i++) {
      re.addComponent(i);
    }
    re.displayRecipe();
  }
}
