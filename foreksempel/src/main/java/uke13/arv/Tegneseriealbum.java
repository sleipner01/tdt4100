package arv;

public class Tegneseriealbum extends Bok {

	int antallStriper;


	public Tegneseriealbum(String tittel, int antallStriper) {
		super(tittel);
		this.antallStriper = antallStriper;
	}

	public int getAntallStriper() {
		return antallStriper;
	}

	// Denne kalles når en Bok kalles med toString().
	protected String GetToStringAttributes() {
		return super.GetToStringAttributes() + ", antallStriper=" + antallStriper;
	}

	public void setAntallStriper(int antallStriper) {
		this.antallStriper = antallStriper;
	}

}
