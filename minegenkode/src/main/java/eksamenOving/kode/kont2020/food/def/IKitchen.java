package eksamenOving.kode.kont2020.food.def;

import java.util.Collection;

import eksamenOving.kode.kont2020.food.Customer;

// Do no edit this file!
public interface IKitchen {

	Collection<String> getRecipes();

	double getTurnover();

	void addCustomer(Customer customer);

	Customer getCustomer(String string);

	void addRecipe(String string);

	void provideMeal(String meal, double price, String name);
	
	void addPriceProvider(PriceProvider pd);
	
	void addObserver(KitchenObserver ko);

}