package eksamenOving.kode.kont2020.food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eksamenOving.kode.kont2020.food.def.IKitchen;
import eksamenOving.kode.kont2020.food.def.KitchenObserver;
import eksamenOving.kode.kont2020.food.def.PriceProvider;

// Important: There is no similarity between Kitchen in the exam v2020 and this one.
public class Kitchen implements IKitchen {

	// Add internal variables here:
	private Collection<String> recipes;
	private List<Customer> customers;
	private double turnover;
	
	public Kitchen() {
		super();
		this.recipes = new ArrayList<>();
		this.customers = new ArrayList<>();
		this.turnover = 0;
	}
	
	
	/**
	 * Add a customer
	 * @param customer The customer to add
	 * 
	 * @throws IllegalArgumentException if the customer is already registered
	 */
	@Override
	public void addCustomer(Customer customer) {
		if(getCustomer(customer.getName()) == null)
			throw new IllegalArgumentException("This customer already exists");

		this.customers.add(customer);
	}

	/**
	 * Add a recipe
	 * @param recipe The recipe to add
	 */
	@Override
	public void addRecipe(String recipe) {
		recipes.add(recipe);
	}
	
	/**
	 * @return The turnover of this kitchen - price of all sold meals added together
	 * If the restaurant has sold for 50, 75 and 100, the turnover is 225.
	 * (Norsk: omsetning)
	 */
	@Override
	public double getTurnover() {
		return this.turnover;
	}

	
	/**
	 * @return A collection of this kitchen's recipes
	 */
	@Override
	public Collection<String> getRecipes() {
		return new ArrayList<>(this.recipes);
	}
	
	/**
	 * @param name The name of the customer to get
	 * 
	 * @return The customer with the given name, or null if no such customer is registered
	 */
	public Customer getCustomer(String name) {
		for (Customer customer : this.customers) {
			if(customer.getName().equals(name)) return customer;
		}
		return null;
	}

	private boolean hasMeal(String meal) {
		for (String recipe : recipes) {
			if(recipe.equals(meal)) return true;
		}
		return false;
	}

	/**
	 * Make a meal, with a given (standard)price and to a given customer.
	 * 
	 * This method needs to check that the kitchen knows the given recipe
	 * and has the given customer registered.
	 * (Task 2.3): rebates need to be considered
	 * Finally, data about the sale must be registered in all appropriate places.
	 * 
	 * @param meal The name of the meal to make
	 * @param price The standard price of the meal
	 * @param customerName The name of the customer that buys the meal
	 * 
	 * @throws IllegalStateException if a meal is not successfully made (somehow)
	 */
	@Override
	public void provideMeal(String meal, double price, String customerName) {
		if(!hasMeal(meal))
			throw new IllegalStateException("The kitchen does not have this meal");

		Customer customer = this.getCustomer(customerName);
		if(customer == null)
			throw new IllegalStateException("This customer is not registered");
		
		customer.buyMeal(meal, computeActualPrice(meal, price, customer));
	}
		
	/**
	 * Exercise 2.3 - Delegation
	 * Calculate the total rebate of the given meal, using the priceDelegates of this Kitchen
	 * If more than one rebate exist, each of them applies. See README for example.
	 * 
	 * @param meal The name of the meal
	 * @param price The standard price of the meal
	 * @param customer The customer buying the meal
	 * @return The resulting price after all rebates have been considered.
	 */
	double computeActualPrice(String meal, double price, Customer customer) {
		return 0; // Dummy return value
	}
	
	// Exercise 2.3 - Delegation - these may not be all methods you need to create!
	@Override
	public void addPriceProvider(PriceProvider pp) {
		
	}

	// Exercise 2.4 - Observerer - these may not be all methods you need to create!
	@Override
	public void addObserver(KitchenObserver ko) {
		
	}

	
	public static void main(String[] args) {
		Kitchen k = new Kitchen();
		k.addRecipe("pancakes");
		k.addRecipe("waffles");
		k.addRecipe("taco");
		k.addRecipe("spam");
		Customer per = new Customer("per");
		k.addCustomer(per);
//		k.addCustomer(per); // IllegalArgumentException
		k.addCustomer(new Customer("ida"));
		k.provideMeal("pancakes", 99.50, "per");
		System.out.println(k.getTurnover());
		k.provideMeal("pancakes", 50, "ida");
		System.out.println(k.getTurnover());
	}


}
