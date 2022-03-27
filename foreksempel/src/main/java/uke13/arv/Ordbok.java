package uke13.arv;

public class Ordbok extends Bok {

	int antallOrd;
	String test = "foo"; // brukes bare til å vise et problem, se linje 24.

	public Ordbok(String tittel, int antallOrd) {
		super(tittel);
//		System.out.println("Ordbok.Kons, etter super");
		this.antallOrd = antallOrd;
	}

	public int getAntallOrd() {
		return antallOrd;
	}

	public void setAntallOrd(int antallOrd) {
		this.antallOrd = antallOrd;
	}

	public void setTittel(String tittel) {

		/* Bare et eksempel på at test her ikke er initiert, som vist på de siste 
		 * foilene i arv. Kommenter ut for å se at variabelen test ikke blir
		 * initiert. Hvorfor? Som forelest vil super-konstruktøren initieres
		 * før variablene settes i hoveddelen av objektet. Problemet er at super-
		 * konstruktøren kaller en metode setTittel, som er overskygget i Ordbok.
		 * Da vil denne kalles FØR variabelen test er definert, og vil dermed bli
		 * null. Litt teknisk, men siden det er forelest beskriver jeg eksempelet.
		 */
		//		System.out.println("test blir ikke initiert: "+test);


		//		System.out.println("Ordbok.setTittel");
		if (! isValidTitle(tittel))
			throw new IllegalArgumentException(tittel +
					" er ikke rett navn på en ordbok");
		// this.tittel = tittel; // Men da tester en ikke for feil tegn... Da må en:
		super.setTittel(tittel);
	}


	// isValidTitle overskygger Bok sin, men den sjekker på noe annet...
	// Det nye kravet er at en ordbok må slutte på "ordbok". Vi må allikevel
	// også huske på å sjekke at den følger super sine krav, så det kan sjekkes først:
	public boolean isValidTitle(String tittel) {
//		System.out.println("Ordbok.isValidTitle");
		if (! super.isValidTitle(tittel)) {
			return false;
		}
		return tittel.endsWith("ordbok");
	}

	// Denne kalles når en Bok kalles med toString().
	protected String GetToStringAttributes() {
		return super.GetToStringAttributes() + ", antallOrd=" + antallOrd;
	}

}
