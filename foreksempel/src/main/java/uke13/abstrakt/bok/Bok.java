package uke13.abstrakt.bok;

public abstract class Bok {

	private String tittel;
	private int antallSider;
	
	protected Bok(String tittel, int antallSider) {
		super();
		this.tittel = tittel;
		this.antallSider = antallSider;
	}
	
	protected String toStringHelper() {
		return "tittel=" + tittel + ", antallSider=" + antallSider;
	}

	@Override
	public String toString() {
		return getSjanger() + "[" + toStringHelper() + "]";
	}

	protected abstract String getSjanger();

	public String getTittel() {
		return tittel;
	}
	
	public int getAntallSider() {
		return antallSider;
	}

	public static void main(String[] args) {
		var roman = new Roman("Kurt koker hodet", 65); // Her støtter vi dog at forfatter er null... 
		System.out.println(roman);
		var roman2 = new Roman("Kurt koker hodet", 65, "Erlend Loe");
		System.out.println(roman2);

		Bok bok = new Tegneseriealbum("Maus", 295);
		System.out.println(bok);
	}

}
