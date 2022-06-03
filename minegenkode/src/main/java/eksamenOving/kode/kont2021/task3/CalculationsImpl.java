package eksamenOving.kode.kont2021.task3;

public class CalculationsImpl implements Calculations {

	@Override
	public int getCalculation1(int number) {
		return (int) Math.sqrt(number);

	}

	@Override
	public int getCalculation2(int number) {
		return number * number;
	}
}
