package eksamenOving.kode.kont2021;

public class Temperature {

	// Add any needed fields
    private final char FAHRENHEIT = 'F';
    private final char CELSIUS = 'C';

    private double degrees;
    private char scale;

	/**
	 * 
	 * @param degrees an arbitrary number
	 * @param scale   a character declaring the scale
	 * 
	 * @throws IllegalArgumentException if scale is not 'C' or 'F'
	 */
	public Temperature(double degrees, char scale) throws IllegalArgumentException {
		this.degrees = degrees;

        if(scale != 'F' && scale != 'C')
            throw new IllegalArgumentException("You have to insert either C or F");
        this.scale = scale;

	}

	/**
	 * 
	 * @return The current scale
	 */
	public char getScale() {
		return this.scale;
	}

	/**
	 * 
	 * @return the current degree of this object
	 */
	public double getDegrees() {
		return this.degrees;
	}

	/**
	 * Converts this temperature object to be the opposite scale of what it
	 * currently is
	 * 
	 * @return this temperature object, converted with value in Celsius if the scale
	 *         of this temperature object is Fahrenheit, and value in Fahrenheit if
	 *         this the scale of this temperature object is Celsius
	 */
	public Temperature toOther() {
        if(Character.compare(this.scale, CELSIUS) == 0) {
            this.scale = FAHRENHEIT;
            this.degrees = convertCelsisusToFahrenheit(this.degrees);
        }
        else {
            this.scale = CELSIUS;
            this.degrees = convertFahrenheitToCelsius(this.degrees);
        }
            
		return this;
	}

	/**
	 * Creates a new temperature object with values in the other scale of this
	 * temperature object
	 * 
	 * @return a new Temperature object, with value in Celsius if the scale of this
	 *         temperature object is Fahrenheit, and value in Fahrenheit if the
	 *         scale of this temperature object is Celsius
	 */
	public Temperature inOther() {
        if(Character.compare(this.scale, CELSIUS) == 0)
            return new Temperature(convertCelsisusToFahrenheit(this.degrees), FAHRENHEIT);
        else return new Temperature(convertFahrenheitToCelsius(this.degrees), CELSIUS);
	}

	/**
	 * Lowers the temperature
	 * 
	 * @param amount the amount to lower by
	 */
	public void lower(double amount) {
		this.degrees -= amount;
	}

	/**
	 * 
	 * @param celsius
	 * @return the temperature in Fahrenheit
	 */
	public static double convertCelsisusToFahrenheit(double celsius) {
		return (celsius * 1.8 + 32.0);
	}

	/**
	 * 
	 * @param fahrenheit
	 * @return the temperature in Celsius
	 */
	public static double convertFahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit - 32.0) / 1.8;
	}

	public static void main(String[] args) {
		Temperature t = new Temperature(20, 'C');
		// Should print 20
		System.out.println(t.getDegrees());
		t.lower(10);
		// Should now print 10
		System.out.println(t.getDegrees());
		t.toOther();
		// Should now print 50
		System.out.println(t.getDegrees());
		t.toOther();

		Temperature t2 = t.inOther();
		// Should be 50;
		System.out.println(t2.getDegrees());

		// Should be 10
		System.out.println(t.getDegrees());
	}

}

