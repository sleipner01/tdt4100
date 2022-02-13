package oving4.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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


    
}
