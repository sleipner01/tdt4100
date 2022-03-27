package oving7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ForeldreSparTest {
	private ForeldreSpar foreldreSpar;
	private static double epsilon = 0.001;

	@BeforeEach
	public void setUp() throws Exception {
		foreldreSpar = new ForeldreSpar(0.04, 3);
	}

	@Test
	@DisplayName("Sjekk at withdraw fungerer som den skal")
	public void testWithdraw() {
		foreldreSpar.deposit(10000.0);
		foreldreSpar.withdraw(1000.0);
		assertEquals(9000.0, foreldreSpar.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalArgumentException.class, () -> {
			foreldreSpar.withdraw(-10000.0);
		}, "Negativt uttak burde gitt utløst IllegalArugment-unntak!");
		assertEquals(9000, foreldreSpar.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalStateException.class, () -> {
			foreldreSpar.withdraw(10000);
		}, "Skal ikke kunne ta ut mer penger enn det er på kontoen");
		assertEquals(9000.0, foreldreSpar.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		foreldreSpar.withdraw(1000.0);
		foreldreSpar.withdraw(1000.0);
		assertThrows(IllegalStateException.class, () -> {
			foreldreSpar.withdraw(1000.0);
		}, "Skal ikke kunne ha flere uttak enn grensen som er satt");
		foreldreSpar.endYearUpdate();
		foreldreSpar.withdraw(1000.0);
		assertEquals(7000.0 * (1 + 0.04) - 1000.0, foreldreSpar.getBalance(), epsilon, "Saldoen på kontoen ble feil");
	}

	@Test
	@DisplayName("Sjekk at gjenværende uttak alltid er riktig")
	public void testRemainingWithdrawals() {
		foreldreSpar.deposit(10000.0);
		foreldreSpar.withdraw(1000.0);
		assertEquals(2, foreldreSpar.getRemainingWithdrawals());
		foreldreSpar.withdraw(1000.0);
		foreldreSpar.withdraw(1000.0);
		assertEquals(0, foreldreSpar.getRemainingWithdrawals());
		assertThrows(IllegalStateException.class, () -> {
			foreldreSpar.withdraw(1000.0);
		}, "Skal ikke kunne ha flere uttak enn grensen som er satt");
		foreldreSpar.endYearUpdate();
		assertEquals(3, foreldreSpar.getRemainingWithdrawals());
	}

}