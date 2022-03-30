package uke13.arv.bok;

public class Bok {
    private String tittel; 
	private String specialCharacters = " -,.%";

    	
    
	public Bok() {
    }

    public Bok(String tittel) {
		setTittel(tittel);
	}

	public String getTittel() {
		return tittel;
	}

	protected String getToStringAttributes() {
		return "tittel=" + tittel;	}
	
    @Override
	public String toString() {
		return getToStringAttributes();
	}

    public void setTittel(String tittel) {
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

    public static void main(String[] args) {
		Bok bok = new Bok("Titten tei på eventyr");
		System.out.println(bok);


		Bok ordbok = new Ordbok("Engelsk-norsk ordbok", 33);
		Bok tegneseriealbum = new Tegneseriealbum("Asterix og romerne", 43);
		// Vi kan ikke kalle tegneseriealbum.getAntallStriper, men siden toString kaller
		// toString overskygget i Tegneseriealbum vises det allikevel:
		System.out.println(tegneseriealbum); 

        // Arv arver også hva de er er:
        System.out.println("ordbok er en Bok: "+(ordbok instanceof Bok));
        System.out.println("ordbok er en Ordbok: "+(ordbok instanceof Ordbok));
        System.out.println("ordbok er classen Bok: "+(ordbok.getClass() == Bok.class));
        System.out.println("ordbok er classen Ordbok: "+(ordbok.getClass() == Ordbok.class));

		// Sjekk av tittel i setTitle, som kalles i konstruktøren
		// Bok bok2 = new Bok("Hei{");
		// System.out.println(bok2); // Vil utløse unntak

		// For isValidTitle()
		// Bok bok3 = new Bok("Titten tei på eventyr");
		// System.out.println(bok3);

		// Substitusjonsprinsippet:
        // Bok bok4 = new Ordbok();
        // bok.setTittel("Egentlig ikke noen ordbok");
        // System.out.println(bok4.toString()); // Hva skjer her?
        
        // Bok bok5 = new Ordbok("Ikke ordbok", 234);
        // System.out.println(bok5.toString()); // Hva skjer her?
	}

}
