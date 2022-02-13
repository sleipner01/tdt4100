package oving4.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
 
import org.junit.jupiter.api.Test;

public class CoffeeCupTest {

    CoffeeCup coffeeCup = new CoffeeCup();
    CoffeeCup coffeeCup2 = new CoffeeCup(40, 0);


    @Test
    public void testGetCapacity() {
        assertEquals(0.0, coffeeCup.getCapacity());
        assertEquals(40, coffeeCup2.getCapacity());
    }

    @Test
    public void testGetCurrentVolume() {
        assertEquals(0.0, coffeeCup.getCurrentVolume());
        assertEquals(0, coffeeCup2.getCurrentVolume());
    }

    @Test
    public void testIncreaseCupSize() {
        coffeeCup.increaseCupSize(20);
        assertEquals(20, coffeeCup.getCapacity());
    }

    @Test
    public void testFillCoffee() {
        assertThrows(RuntimeException.class, () -> {
			coffeeCup.fillCoffee(10);
		}, "Skal ikke kunne fylle på mere kaffe enn koppen rommer");

        coffeeCup2.fillCoffee(40);
        assertEquals(40, coffeeCup2.getCurrentVolume());
    }

    @Test
    public void testDrinkCoffee() {
        assertThrows(RuntimeException.class, () -> {
			coffeeCup.drinkCoffee(10);
		}, "Skal ikke kunne drikke mere kaffe enn det finnes i koppen");

        coffeeCup2.fillCoffee(10);
        assertEquals(10, coffeeCup2.getCurrentVolume());
        coffeeCup2.drinkCoffee(10);
        assertEquals(0, coffeeCup2.getCurrentVolume());
    }
    
}
