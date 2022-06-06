package eksamenOving.kode.kont2020.food;

/**
 * A wrapper class for keeping track of a bought meal.
 *
 * The class needs to store the name of meal, as well as the price
 * it was sold for. And a way of providing these to external users.
 * 
 */
public class MealOrder {
	
	// Consult the README for a description of requirements.
	private String meal;
	private double price;

	public MealOrder(String meal, double price) {
		this.meal = meal;
		this.price = price;
	}

	public String getMeal() {
		return this.meal;
	}

	public double getPrice() {
		return this.price;
	}
	
}
