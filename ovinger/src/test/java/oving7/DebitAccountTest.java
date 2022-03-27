package oving7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DebitAccountTest {
	private DebitAccount sub;
	private static double epsilon = 0.0005d;

	@BeforeEach
	public void setUp() {
		sub = new DebitAccount();
	}

	@Test
	@DisplayName("Sjekk at innskudd fungerer som det skal")
	void testDeposit() {
		assertEquals(0.0, sub.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		sub.deposit(10000.0);
		assertEquals(10000.0, sub.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalArgumentException.class, () -> {
			sub.deposit(-10000.0);
		}, "Negativt innskudd burde gitt utløst IllegalArugment-unntak!");
		assertEquals(10000.0, sub.getBalance(), epsilon, "Saldoen på kontoen ble feil");
	}

	@Test
	@DisplayName("Sjekk at uttak fungerer som det skal")
	void testWithdraw() {
		sub.deposit(20000.0);
		sub.withdraw(5000.0);
		assertEquals(15000.0, sub.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalArgumentException.class, () -> {
			sub.withdraw(-10000.0);
		}, "Negativt uttak burde gitt utløst IllegalArugment-unntak!");
		assertEquals(15000.0, sub.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalStateException.class, () -> {
			sub.withdraw(20000.0);
		}, "Uttak på mer enn saldo burde utløst IllegalState-unntak");
	}
}