package uke13.arv.bok_avansert;

public class Bok {

	private String tittel; 
	private String specialCharacters = " -,.%";
	private String ulovligeBokstaver = "#¤([]){]}";

	
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
	
	public Bok() {
		super();
	}

	public Bok(String tittel) {
		setTittel(tittel);
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		if (!isValidTitle(tittel)) {
			throw new IllegalArgumentException(tittel+" er ikke en gyldig boktittel.");
		}
		this.tittel = tittel;
	}

	public boolean isValidTitle(String tittel) {
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

	public static void main(String[] args) {
		Bok bok = new Bok("Titten tei på eventyr");
		System.out.println(bok);

		// Sjekk av tittel i setTitle, som kalles i konstruktøren
		// Bok bok2 = new Bok("Hei{");
		// System.out.println(bok2); // Vil bli null

		// For isValidTitle()
		Bok bok3 = new Bok("Titten tei på eventyr");
		System.out.println(bok3);

		Bok ordbok = new Ordbok("Engelsk-norsk ordbok", 33);
		Bok tegneseriealbum = new Tegneseriealbum("Asterix og romerne", 43);
		// Vi kan ikke kalle tegneseriealbum.getAntallStriper, men siden toString kaller
		// toString overskygget i Tegneseriealbum vises det allikevel:
		System.out.println(tegneseriealbum); 
	}
}
