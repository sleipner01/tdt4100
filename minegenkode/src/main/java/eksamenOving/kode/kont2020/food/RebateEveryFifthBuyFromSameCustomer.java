package eksamenOving.kode.kont2020.food;

import eksamenOving.kode.kont2020.food.def.PriceProvider;

/**
 * A rebate where a customer will get 50% off on every fifth purchase - 
 * Note: you get a rebate on the first buy, so in essence you end up with rebates on the
 * 0th, 5th, 10th, 15th etc buys if you start with 0.
 */
public class RebateEveryFifthBuyFromSameCustomer implements PriceProvider {

	/**
	 * Every fifth time a customer buys a meal, including the first time, 
	 * its price should be reduced to half, return 0.5
	 * If not, it should return 1 (no rebate)
	 */
	@Override
	public double providePrice(String meal, double price, Customer customer) {
		int orders = customer.getNumberOfOrderedMeals() - 1;
		if(orders == 0) return 0.5;
		if(orders % 5 == 0) return 0.5;

		return 1;
	}

}
