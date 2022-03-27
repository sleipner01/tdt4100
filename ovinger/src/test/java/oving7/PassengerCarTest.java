package oving7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PassengerCarTest {

	private PassengerCar pc;

	@BeforeEach
	public void setup() {
		pc = new PassengerCar(3000, 200);
	}

	@Test
	@DisplayName("Sjekke totalvekt")
	public void testWeight() {
		Assertions.assertEquals(3000 + (200 * 80), pc.getTotalWeight(), "Teste totalvekt etter initialisering");
		pc.setPassengerCount(100);
		Assertions.assertEquals(3000 + (100 * 80), pc.getTotalWeight(),
				"Teste totalvekt etter endret antall passasjerer");
		Assertions.assertEquals(100, pc.getPassengerCount(), "Teste antall passasjerer etter endret antall");
	}
}