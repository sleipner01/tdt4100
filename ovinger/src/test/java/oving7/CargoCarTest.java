package oving7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CargoCarTest {

	private CargoCar cc;

	@BeforeEach
	public void setup() {
		cc = new CargoCar(3000, 2000);
	}

	@Test
	@DisplayName("Sjekke totalvekt")
	public void testWeight() {
		Assertions.assertEquals(5000, cc.getTotalWeight(), "Teste totalvekt etter initialisering");
		cc.setCargoWeight(4000);
		Assertions.assertEquals(7000, cc.getTotalWeight(), "Teste totalvekt etter endret cargo-vekt");
		Assertions.assertEquals(4000, cc.getCargoWeight(), "Teste cargo-vekt etter endring i vekten");
	}
}