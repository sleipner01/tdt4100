package oving7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainTest {

	private Train train;
	private PassengerCar pc1, pc2;
	private CargoCar cc1, cc2;

	@BeforeEach
	public void setup() {
		train = new Train();
		pc1 = new PassengerCar(2000, 200);
		pc2 = new PassengerCar(1500, 100);
		cc1 = new CargoCar(3000, 5000);
		cc2 = new CargoCar(2500, 7000);
	}

	@Test
	@DisplayName("Legge til vogner i tog")
	public void testAddCarToTrain() {
		train.addTrainCar(pc1);
		train.addTrainCar(pc2);
		train.addTrainCar(cc1);
		Assertions.assertTrue(train.contains(pc1),
				"Teste om toget inneholder passasjervogn1 etter at den har blitt lagt til");
		Assertions.assertTrue(train.contains(pc2),
				"Teste om toget inneholder passasjervogn2 etter at den har blitt lagt til");
		Assertions.assertTrue(train.contains(cc1),
				"Teste om toget inneholder cargovogn1 etter at den har blitt lagt til");
		Assertions.assertFalse(train.contains(cc2),
				"Teste om toget inneholder cargovogn2 uten at den har blitt lagt til");
	}

	@Test
	@DisplayName("Sjekke totalvekt på toget")
	public void testTotalTrainWeight() {
		train.addTrainCar(pc1);
		train.addTrainCar(cc1);

		Assertions.assertEquals(8000 + (2000 + (200 * 80)), train.getTotalWeight(),
				"Teste togets totalvekt etter å ha lagt til en passasjervogn og en cargovogn");

		train.addTrainCar(pc2);

		Assertions.assertEquals(8000 + (2000 + (200 * 80)) + (1500 + (100 * 80)), train.getTotalWeight(),
				"Teste togets totalvekt etter å ha lagt til enda en passasjervogn");
	}

	@Test
	@DisplayName("Sjekke passasjerantall på toget")
	public void testPassengerCount() {
		train.addTrainCar(pc1);
		train.addTrainCar(pc2);
		Assertions.assertEquals(300, train.getPassengerCount(),
				"Teste passasjerantall etter å ha lagt til passasjervogner");
		train.addTrainCar(cc1);
		Assertions.assertEquals(300, train.getPassengerCount(), "Teste passasjerantall etter å ha lagt til cargo-vogn");
	}

	@Test
	@DisplayName("Sjekke cargovekt på toget")
	public void testCargoWeight() {
		train.addTrainCar(cc1);
		train.addTrainCar(cc2);
		Assertions.assertEquals(12000, train.getCargoWeight(), "Teste cargovekt etter å ha lagt til cargovogner");

		train.addTrainCar(pc1);
		Assertions.assertEquals(12000, train.getCargoWeight(), "Teste cargovekt etter å ha lagt til passasjervogn");
	}
}