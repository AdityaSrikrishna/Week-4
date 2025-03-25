interface MealPlan{
     void displayMeals();
}
class VegetarianMeal implements MealPlan{
    public void displayMeals(){
        System.out.println("Vegetarian Meals: Salad, Grilled Vegetables, Tofu Stir-fry");
    }
}
class VeganMeal implements MealPlan{
    public void displayMeals() {
        System.out.println("Vegan Meals: Quinoa Salad, Lentil Soup, Vegan Burger");
    }
}
class KetoMeal implements MealPlan{
    public void displayMeals() {
        System.out.println("Keto Meals: Avocado Salad, Grilled Chicken, Cauliflower Rice");
    }
}
class HighProteinMeal implements MealPlan{
    public void displayMeals() {
        System.out.println("High Protein Meals: Steak, Protein Smoothie, Grilled Salmon");
    }
}
class Meal<T extends MealPlan>{
    private T mealPlan;
    public Meal(T mealPlan){
        this.mealPlan = mealPlan;
    }
    void showMealPlan(){
        mealPlan.displayMeals();
    }
}
class MealPlanner{
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan){
        System.out.println("Generating your personalized Meal Plan.....");
        return new Meal<>(mealPlan);
    }
}
public class MealMain{
    public static void main(String[] args) {
        VegetarianMeal vegmeal = new VegetarianMeal();
        VeganMeal veganmeal = new VeganMeal();
        KetoMeal ketomeal = new KetoMeal();
        HighProteinMeal highProteinmeal = new HighProteinMeal();

        Meal<VegetarianMeal> vegMealPlan = MealPlanner.generateMealPlan(vegmeal);
        vegMealPlan.showMealPlan();

        Meal<VeganMeal> veganMealPlan = MealPlanner.generateMealPlan(veganmeal);
        veganMealPlan.showMealPlan();

        Meal<KetoMeal> ketoMealPlan = MealPlanner.generateMealPlan(ketomeal);
        ketoMealPlan.showMealPlan();

        Meal<HighProteinMeal> highProteinMealPlan = MealPlanner.generateMealPlan(highProteinmeal);
        highProteinMealPlan.showMealPlan();
    }
}