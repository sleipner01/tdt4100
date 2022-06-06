package food;

import food.def.PriceProvider;

/**
 * A rebate where every thousandth purchase (regardless of meal, price, or customer)
 * is given away for free. Not the first buy!
 */
public class RebateFreeEveryThousandSale implements PriceProvider {

	@Override
	public double providePrice(String meal, double price, Customer customer) {
		return 0; // dummy return value
	}


}
