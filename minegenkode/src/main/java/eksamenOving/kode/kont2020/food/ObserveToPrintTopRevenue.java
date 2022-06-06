package food;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import food.def.KitchenObserver;

/**
 * The main point of this implementation of KitchenObserver is to keep track of revenue
 * from all meals sold. Every time a new meal is sold (and mealOrder is called), 
 * information about the meal(s) with the highest revenue is printed to System.out.
 *
 */
public class ObserveToPrintTopRevenue implements KitchenObserver {

	// Internal variables go here:
	
	
	/**
	 * 
	 * @return A string that contains the string 'meal: price' for all meals that have the highest revenue, 
	 * separated by a newline. If more than one meal they are sorted in alphabetical order.
	 * If no meal has been sold: returns an empty string.
	 */
	public String getTopSellers() {
		return null; // dummy return value
	}
	

	
	/**
	 * When triggered, updates the revenue of 'meal' with 'price'.
	 * Should then print (System.out) the meal(s) with highest revenue (in alphabetical order), see the method 
	 * getTopSellers.
	 */
	@Override
	public void mealOrder(String meal, double price) {
	}
	

	// A basic use of the class. No need to use Kitchen to make it work. 
	public static void main(String[] args) {
		ObserveToPrintTopRevenue test = new ObserveToPrintTopRevenue();
		System.out.println("> Only waffles: 50.0");
		test.mealOrder("waffles", 50.0);
		assertEquals("waffles: 50.0", test.getTopSellers().trim());
		System.out.println("> Only waffles: 100.0");
		test.mealOrder("waffles", 50.0);
		System.out.println("> Pancakes and waffles (two lines): 100.0");
		test.mealOrder("pancakes", 100.0);
		System.out.println("> Only waffles: 150.0");
		test.mealOrder("waffles", 50.0);
		
		
	}
}
