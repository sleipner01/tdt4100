package oving7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BSUTest {
	private BSU bsu;
	private static double epsilon = 0.001;

	@BeforeEach
	public void setUp() throws Exception {
		bsu = new BSU(0.05, 25000.0);
	}

	@Test
	@DisplayName("Sjekk at innskudd fungerer som det skal")
	void testDeposit() {
		bsu.deposit(10000.0);
		assertEquals(10000.0, bsu.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalArgumentException.class, () -> {
			bsu.deposit(-100.0);
		}, "Negativt innskudd burde gitt utløst IllegalArugment-unntak!");
		assertThrows(IllegalStateException.class, () -> {
			bsu.deposit(20000.0);
		}, "Skal ikke kunne sette inn mer penger inn inskuddsgrensen");
		bsu.endYearUpdate();
		bsu.deposit(20000.0);
		assertEquals(10000.0 * (1 + 0.05) + 20000.0, bsu.getBalance(), epsilon, "Saldoen på kontoen ble feil");
	}

	@Test
	@DisplayName("Sjekk at uttak fungerer som det skal")
	void testWithdraw() {
		bsu.deposit(20000.0);
		bsu.withdraw(5000.0);
		assertEquals(15000.0, bsu.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalArgumentException.class, () -> {
			bsu.withdraw(-10000.0);
		}, "Negativt uttak burde gitt utløst IllegalArugment-unntak!");
		assertEquals(15000.0, bsu.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalStateException.class, () -> {
			bsu.withdraw(20000);
		}, "Skal ikke kunne ta ut mer penger enn er satt inn dette året");
		assertEquals(15000.0, bsu.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		bsu.endYearUpdate();
		assertThrows(IllegalStateException.class, () -> {
			bsu.withdraw(10000);
		}, "Skal ikke kunne ta ut mer penger enn er satt inn dette året");
		assertEquals(15000 * (1 + 0.05), bsu.getBalance(), epsilon, "Saldoen på kontoen ble feil");
	}

	@Test
	@DisplayName("Sjekk at skattefradraget blir riktig")
	public void testTaxDeduction() {
		bsu.deposit(20000.0);
		assertEquals(20000.0 * 0.20, bsu.getTaxDeduction(), epsilon, "Skattefradraget ble feil");
		bsu.endYearUpdate();
		bsu.deposit(10000.0);
		assertEquals(10000.0 * 0.20, bsu.getTaxDeduction(), epsilon, "Skattefradraget ble feil");
		bsu.endYearUpdate();
		assertEquals(0.0, bsu.getTaxDeduction(), epsilon, "Skattefradraget ble feil");
	}
}