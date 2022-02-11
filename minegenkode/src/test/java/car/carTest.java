package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class carTest {

    Car car;

    @BeforeEach
    public void setup() throws Exception {
        Car car = new Car("AA52448", 3);
    }

    @Test
    public void testGetPlate() {
        car.getPlate();
    }

    public void testAddPassenger() {
        // car.addPassenger(person);
    }
    
}
