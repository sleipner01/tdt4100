package food.def;

import java.util.Collection;

import food.MealOrder;

public interface ICustomer {

	/**
	 * Customer has ordered a recipe. Add it to the list even if it already there.
	 * @param name
	 */
	void buyMeal(String meal, double price);

	Collection<MealOrder> getMealsOrdered();

	int getNumberOfOrderedMeals();

	String getName();

	MealOrder getLastOrderedMeal();

	int timesEaten(String meal);

}