package uke13.arv.bok;

public class Tegneseriealbum extends Bok {

	int antallStriper;


	public Tegneseriealbum(String tittel, int antallStriper) {
		super(tittel); // Merk at vi bruker Bok sin konstruktør, for å sjekke tittelkorrekthet
		this.antallStriper = antallStriper;
	}

	public int getAntallStriper() {
		return antallStriper;
	}

	// Denne kalles når en Bok kalles med toString().
	protected String getToStringAttributes() {
		return super.getToStringAttributes() + ", antallStriper=" + antallStriper;
	}

	public void setAntallStriper(int antallStriper) {
		this.antallStriper = antallStriper;
	}

}
