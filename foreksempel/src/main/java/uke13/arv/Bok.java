package arv;

public class Bok {

	private String tittel; 
	private String specialCharacters = " -,.%";
	
	// Vi sjekket først for ulovlige bokstaver, men gikk over til å sjekke for
	// lovlige ting: bokstaver, tall og specialCharacters (se over)
	private String ulovligeBokstaver = "#¤([]) {]}";

	@Override
	public String toString() {
		// Den første skriver bare ut for bok. Men dersom du lager en
		// ny metode, kaller den, og den kan skygges over av subklasser,
		// da kan en ende opp med en fin løsning. Når du kaller toString
		// på en Ordbok vil den ende opp i Bok.toString() siden Ordbok ikke
		// implementerer denne. Kallet vil allikevel rutes tilbake til 
		// Ordbok.GetToStringAttributes()!
		
//		return "Bok [tittel=" + tittel + "]";
		return GetToStringAttributes();
	}

	protected String GetToStringAttributes() {
		return "tittel=" + tittel;	}

	public Bok(String tittel) {
//		System.out.println("Bok.kons");
		setTittel(tittel);
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
//		System.out.println("Bok.setTittel");

		if (!isValidTittel(tittel)) {
			throw new IllegalArgumentException(tittel+" er ikke en gyldig boktittel.");
		}
		this.tittel = tittel;
	}

	public boolean isValidTittel(String tittel) {
//		System.out.println("Bok.isValidTittel");
		for (int i = 0; i < tittel.length(); i++) {
			char c = tittel.charAt(i);
			if (! (Character.isLetter(c) || Character.isDigit(c) || 
					specialCharacters.indexOf(c) >= 0)) {
				return false;
			}
		}
		return true;

	}
}
