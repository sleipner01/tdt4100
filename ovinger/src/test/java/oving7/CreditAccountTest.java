package oving7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
	private CreditAccount sub;
	private static double epsilon = 0.0005d;

	@BeforeEach
	public void setUp() {
		sub = new CreditAccount(10000.0);
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
		sub.withdraw(20000.0);
		assertEquals(-5000.0, sub.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		assertThrows(IllegalStateException.class, () -> {
			sub.withdraw(20000.0);
		}, "Uttak på mer enn kredittgrense burde utløst IllegalState-unntak");
	}

	@Test
	@DisplayName("Sjekk at kredittgrensen fungerer som den skal")
	void testCreditLine() {
		assertEquals(10000.0, sub.getCreditLine(), epsilon, "Kredittgrensen var feil");
		sub.setCreditLine(5000.0);
		assertEquals(5000.0, sub.getCreditLine(), epsilon, "Kredittgrensen var feil");
		assertThrows(IllegalArgumentException.class, () -> {
			sub.setCreditLine(-5000.0);
		}, "Kan ikke ha negativ kredittgrense");
		assertEquals(5000.0, sub.getCreditLine(), epsilon, "Kredittgrensen var feil");
		sub.withdraw(4000.0);
		assertThrows(IllegalStateException.class, () -> {
			sub.setCreditLine(3000.0);
		}, "Kan ikke sette kredittgrense som vil gi ugyldig saldo");
		assertEquals(-4000.0, sub.getBalance(), epsilon, "Saldoen var feil");
		assertEquals(5000.0, sub.getCreditLine(), epsilon, "Kredittgrensen var feil");
	}
}