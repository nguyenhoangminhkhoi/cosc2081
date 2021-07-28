package week5;

import java.util.Scanner;
import java.util.HashSet;

public class Week5 {
  public static void main(String[] args) {
    // Test program
    // We want to create a recipe for Pho
    Recipe pho = new Recipe("Pho");
    Scanner sc = new Scanner(System.in);
    System.out.printf("\nAdd a component? (Y/N): ");
    String answer = sc.nextLine();
    while (answer.equalsIgnoreCase("Y")) {
      pho.addComponent();
      System.out.printf("\nAdd a component? (Y/N): ");
      answer = sc.nextLine();
    }
    System.out.printf("\nYou need to prepare %d components as follow:", Recipe.countComponents());
    pho.displayRecipe();
  }
}

class Recipe {
  private String name;
  private static int count = 0;
  private HashSet<RecipeComponent> components;

  public Recipe(String name) {
    this.name = name;
    components = new HashSet<RecipeComponent>();
  }

  // Add one component
  public void addComponent() {
    // demonstrate only, don't write a complex statement like this
    Recipe.count++;
    components.add(RecipeComponent.createRecipeComponent());
  }

  // Return the number of recipe component
  public static int countComponents() {
    return Recipe.count;
  }

  // Display a recipe
  public void displayRecipe() {
    System.out.printf("\nRecipe name: %s", name);
    for (RecipeComponent rc : components) {
      rc.displayRecipeComponent();
    }
  }
}

class RecipeComponent {
  private Ingredient ing;
  private double amount;

  private RecipeComponent(Ingredient ing, double amount) {
    this.ing = ing;
    this.amount = amount;
  }

  public static RecipeComponent createRecipeComponent() {
    Scanner sc = new Scanner(System.in);
    Ingredient ing = Ingredient.createIngredient();
    System.out.printf("\nPlease input the amount: ");
    double amount = Double.parseDouble(sc.nextLine());
    return new RecipeComponent(ing, amount);
  }

  public void displayRecipeComponent() {
    ing.displayIngredient();
    System.out.printf("\nAmount: %.2f", amount);
  }
}

class Ingredient {
  private String name;
  private String measurement;
  private String comment;

  private Ingredient(String n, String m, String c) {
    name = n;
    measurement = m;
    comment = c;
  }

  public static Ingredient createIngredient() {
    Scanner sc = new Scanner(System.in);
    System.out.printf("\nPlease input the name of the ingredient: ");
    String name = sc.nextLine();
    System.out.printf("\nPlease input the ingredient's measurement unit: ");
    String measurement = sc.nextLine();
    System.out.printf("\nPlease input any comments if needed: ");
    String comment = sc.nextLine();
    return new Ingredient(name, measurement, comment);
  }

  void displayIngredient() {
    System.out.printf("\nThe ingredient is %s and its measurement unit is %s. Comment: %s", name, measurement, comment);
  }
}
