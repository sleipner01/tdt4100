package eksamenOving.kode.kont2021;

import java.util.ArrayList;
import java.util.List;

public class CachingCalculations implements Calculations {

    private Calculations calc;
    private List<int[]> calc1Cache;
    private List<int[]> calc2Cache;


	public CachingCalculations(Calculations delegate) {
        calc = delegate;
        calc1Cache = new ArrayList<>();
        calc2Cache = new ArrayList<>();
	}

	@Override
	/**
	 * Delegates the job of calculating the square root to the delegate If the
	 * argument has been previously seen, the delegate should not be used and a
	 * local cached version of the result should be returned
	 * 
	 * @returns the calculation applied to the argument
	 */
	public int getCalculation1(int number) {
        for(int i = 0; i < calc1Cache.size(); i++)
            if(calc1Cache.get(i)[0] == number) return calc1Cache.get(i)[1];
        
		int calculation = calc.getCalculation1(number);
        int[] tuple = {number, calculation};
        calc1Cache.add(tuple);

		return calculation;
	}


	@Override
	/**
	 * Delegates the job of calculating the square to the delegate If the argument
	 * has been previously seen, the delegate should not be used and a local cached
	 * version of the result should be returned
	 * 
	 * @returns the calculation applied to the argument
	 */
	public int getCalculation2(int number) {
        for(int i = 0; i < calc2Cache.size(); i++)
            if(calc2Cache.get(i)[0] == number) return calc2Cache.get(i)[1];
    
        int calculation = calc.getCalculation2(number);
        int[] tuple = {number, calculation};
        calc2Cache.add(tuple);

        return calculation;
	}

	public static void main(String[] args) {
		CachingCalculations calc = new CachingCalculations(new CalculationsImpl());
		// Should print 81
		System.out.println(calc.getCalculation2(9));
		// Should print 81 again, should not use the delegate
		System.out.println(calc.getCalculation2(9));
		// Should print 3
		System.out.println(calc.getCalculation1(9));
	}

}