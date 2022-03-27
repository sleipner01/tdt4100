package oving7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainCarTest {

	private TrainCar tc;

	@BeforeEach
	public void setup() {
		tc = new TrainCar(3000);
	}

	@Test
	@DisplayName("Død vekt er lik totalvekt")
	public void testDeadWeight() {
		Assertions.assertEquals(3000, tc.getTotalWeight(), "Teste initialisering av dødvekt");
		tc.setDeadWeight(5000);
		Assertions.assertEquals(5000, tc.getTotalWeight(), "Teste at totalvekt er lik satt dødvekt");
	}
}