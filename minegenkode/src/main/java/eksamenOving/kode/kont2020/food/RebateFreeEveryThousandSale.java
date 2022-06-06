package eksamenOving.kode.kont2020.food;

import eksamenOving.kode.kont2020.food.def.PriceProvider;

/**
 * A rebate where every thousandth purchase (regardless of meal, price, or customer)
 * is given away for free. Not the first buy!
 */
public class RebateFreeEveryThousandSale implements PriceProvider {

	@Override
	public double providePrice(String meal, double price, Customer customer) {
		int orders = customer.getNumberOfOrderedMeals();

		if(orders == 0) return 1;
		if(orders % 1000 == 0) return 0;

		return 1;
	}


}
