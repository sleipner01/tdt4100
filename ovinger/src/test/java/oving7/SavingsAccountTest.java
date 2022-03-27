package oving7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
	private SavingsAccount savingsAccount;
	private static double epsilon = 0.001;

	@BeforeEach
	public void setUp() throws Exception {
		savingsAccount = new SavingsAccount(0.1);
	}

	@Test
	@DisplayName("Sjekk at saldoen blir riktig etter innskudd")
	void testBalance() {
		savingsAccount.deposit(100.0);
		assertEquals(100.0, savingsAccount.getBalance(), epsilon, "Saldoen på kontoen ble feil");
	}

	@Test
	@DisplayName("Test deposit og withdraw")
	void testDepositAndWithdraw() {
		savingsAccount.deposit(100.0);
		savingsAccount.withdraw(40.0);
		assertEquals(60.0, savingsAccount.getBalance(), epsilon, "Saldoen på kontoen ble feil");
	}

	@Test
	@DisplayName("Test deposit og withdraw med ulovlig input")
	void testDepositAndWithdrawIllegalInput() {
		savingsAccount.deposit(10.0);
		assertThrows(IllegalArgumentException.class, () -> {
			savingsAccount.deposit(-100.0);
		}, "Negativt innskudd burde gitt utløst IllegalArugment-unntak!");
		assertEquals(10.0, savingsAccount.getBalance(), epsilon, "Saldoen på kontoen ble feil");

		savingsAccount.deposit(10.0);
		assertThrows(IllegalArgumentException.class, () -> {
			savingsAccount.withdraw(-100.0);
		}, "Negativt uttak burde gitt utløst IllegalArgument-unntak!");
		assertEquals(20.0, savingsAccount.getBalance(), epsilon, "Saldoen på kontoen ble feil");
		savingsAccount.deposit(10.0);
		assertThrows(IllegalStateException.class, () -> {
			savingsAccount.withdraw(40.0);
			;
		}, "Uttak på mer enn saldo burde utløst IllegalState-unntak");
		assertEquals(30.0, savingsAccount.getBalance(), epsilon, "Saldoen på kontoen ble feil");
	}

	@Test
	@DisplayName("Test at renten blir riktig")
	void endYearUpdate() {
		savingsAccount.deposit(100.0);
		savingsAccount.endYearUpdate();
		assertEquals(100.0 * (1 + 0.10), savingsAccount.getBalance(), epsilon,
				"Saldoen på kontoen ble feil etter at renten ble lagt til");
	}
}