package uke13.arv.bok_avansert;

public class Ordbok extends Bok {

	int antallOrd;

	public Ordbok(String tittel, int antallOrd) {
		super(tittel); // Merk at vi bruker Bok sin konstruktør, for å sjekke tittelkorrekthet
		this.antallOrd = antallOrd;
	}

	public int getAntallOrd() {
		return antallOrd;
	}

	public void setAntallOrd(int antallOrd) {
		this.antallOrd = antallOrd;
	}

	public void setTittel(String tittel) {


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

	public static void main(String[] args) {
		Ordbok ordbok = new Ordbok("Nynorsk ordbok", 98543);
		System.out.println(ordbok);
		// Ordbok ordbok2 = new Ordbok("Nynorsk ordbøk", 98543);
		// System.out.println(ordbok2);

		System.out.println(ordbok instanceof Bok);
		System.out.println(ordbok.getClass().equals(uke13.arv.bok_avansert.Bok.class));
		System.out.println(ordbok.getClass().equals(uke13.arv.bok_avansert.Ordbok.class));

		// Substitusjonsprinsippet, kan vi bruke dette fullstendig her?
		// Vi kan ikke bruke Ordbok for å lage alle slags bøker, da vi har krav for tittel
		// Vi setter altså større krav til en tittel her enn for en Bok. Da virker ikke substitusjonsprinsippet
		// I tillegg krever vi antallOrd i konstruktøren...
		// Se https://stackoverflow.com/questions/56860/what-is-an-example-of-the-liskov-substitution-principle
		
		// Bok bok = new Ordbok(""); // Går jo ikke.
		// En bedre løsning er å bruke abstrakte klasser, og/eller interface.
	}
}
