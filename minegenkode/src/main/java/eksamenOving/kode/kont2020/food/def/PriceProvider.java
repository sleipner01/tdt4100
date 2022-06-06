package food.def;

import food.Customer;

//THIS INTERFACE IS NOT TO BE EDITED
public interface PriceProvider {
	
	// THIS METHOD IS NOT TO BE EDITED
	/**
	 * Provide a price factor using this provider
	 * 
	 * @param meal The meal that was bought
	 * @param price The original price of the meal
	 * @param customer The customer buying the meal
	 * @return A factor to multiply the price with to get the new price. E.g. if the rebate is 50% off, this should return 0.5.
	 */
	double providePrice(String meal, double price, Customer customer);

}
