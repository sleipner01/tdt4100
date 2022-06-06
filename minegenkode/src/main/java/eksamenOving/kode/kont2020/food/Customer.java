package eksamenOving.kode.kont2020.food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eksamenOving.kode.kont2020.food.def.ICustomer;

public class Customer implements ICustomer {


	// Add internal variables here:
	private String name;
	private List<MealOrder> mealsOrdered;
	
	
	/**
	 * Create a new customer
	 * 
	 * @param name The name of the customer
	 */
	public Customer(String name) {
		this.name = name;
		this.mealsOrdered = new ArrayList<>();
	}
	
	
	/**
	 * 
	 * @return A list containing all meals bought by this customer
	 */
	public Collection<MealOrder> getMealsOrdered() {
		return this.mealsOrdered;
	}

	/**
	 * Add a bought meal to this customer
	 * 
	 * @param meal The name of the meal
	 * @param price The price the customer paid for the meal
	 */
	@Override
	public void buyMeal(String meal, double price) {
		this.mealsOrdered.add(new MealOrder(meal, price));
	}
	
	
	/**
	 * @return The number of meals ordered by this customer
	 */
	@Override
	public int getNumberOfOrderedMeals() {
		return this.mealsOrdered.size();
	}
	
	/**
	 * @return The name of this customer
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * @return A String on the form "<name>: <number of meals ordered>"
	 */
	@Override
	public String toString() {
		return this.name + ": " + getNumberOfOrderedMeals();
	}

	/**
	 * @return The most recent meal bought by this customer
	 * If no meal is ordered, return null.
	 */
	@Override
	public MealOrder getLastOrderedMeal() {
		return this.mealsOrdered.get(this.mealsOrdered.size()-1);
	}
	
	/**
	 * Get the number of times the customer has eaten the given meal
	 * 
	 * @param meal The name of the meal
	 * 
	 * @return The number of times this customer has eaten the given meal
	 */
	@Override
	public int timesEaten(String meal) {
		return this.mealsOrdered.stream().filter(order -> order.getMeal().equals(meal)).toList().size();
	}
	
	public static void main(String[] args) {
		Customer customer = new Customer("Frank");
		customer.buyMeal("pancakes", 100);
		customer.buyMeal("pancakes", 75);
		System.out.println("Skal være 2 kjøp: " + customer.getMealsOrdered().size());
		System.out.println("Skal være pris 75: " + customer.getLastOrderedMeal().getPrice()); // Som definert i README.
	}
}
