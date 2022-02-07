package oving3.debugging;

import java.util.Random;

public class CoffeeCupProgram {

	private CoffeeCup cup;
	private Random r;

	public void init() {
		cup = new CoffeeCup();
		r = new Random(123456789L);
	}

	public void run() {
		// part1();
		part2();
	}


	// Del 1
	private void part1() {
		cup.increaseCupSize(40.0);
		cup.fillCoffee(20.5);
		cup.drinkCoffee(Math.floor(r.nextDouble() * 20.5));
		cup.fillCoffee(32.5);
		cup.drinkCoffee(Math.ceil(r.nextDouble() * 38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble() * 42));
		cup.increaseCupSize(17); // The cupsize is set bigger, but the cup is not refilled.
		// First problem here
		cup.drinkCoffee(40); // Only 5 left in the cup,
		// so exception "You can't drink that much coffee!" is thrown.
		cup.drinkCoffee(Math.ceil(r.nextDouble() * 42));
		cup.drinkCoffee(Math.floor(r.nextDouble() * 20.5));
		cup.fillCoffee(32.5);
		cup.drinkCoffee(Math.ceil(r.nextDouble() * 38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble() * 42));
		cup.increaseCupSize(17);
	}

	private void part2() {
		cup = new CoffeeCup(40.0, 20.5);
		r = new Random(987654321L);
		cup.drinkCoffee(Math.floor(r.nextDouble() * 20.5));
		cup.fillCoffee(Math.floor(r.nextDouble() * 30));
		cup.drinkCoffee(Math.ceil(r.nextDouble() * 38.9));
		cup.drinkCoffee(Math.ceil(r.nextDouble() * 42));
		cup.increaseCupSize(Math.floor(r.nextDouble() * 26));
		cup.fillCoffee(Math.ceil(r.nextDouble() * 59));
		cup.drinkCoffee(Math.ceil(r.nextDouble() * 42));
		cup.increaseCupSize(Math.floor(r.nextDouble() * 35));
		cup.fillCoffee(Math.floor(r.nextDouble() * 30));
		cup.increaseCupSize(Math.floor(r.nextDouble() * 26));
	}


	// Del 2
	// Start: 20.5
	// Drink: 14.5
	// Fill:  38.5
	// Drink: 36.5
	// Drink: 6.5
	// INCREASING CUP SIZE (by 0 based on seed)
	// Fill: 46.5 (filling by 40 based on seed)
	//  ** Exception **
		// Metoden som utløser unntaket er fillCoffee().
		// Vi får et random tall som blir avrundet til 0.
		// Koppen øker dermed ikke i størrelse.
		// fillCup() ønsker å fylle opp koppen med mere enn det er plass til.
		// Unntaket er IllegalArgumentException



	public static void main(String[] args) {
		CoffeeCupProgram program = new CoffeeCupProgram();
		program.init();
		program.run();
	}

}
