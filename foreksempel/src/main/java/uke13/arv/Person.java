package arv;

public class Person {

	// Lag den helt vanilla i foil 17, utvid med setName etc i foil 25
	// Ta dog med toString i 17
	
	// Legg til equals-sjekk før og etter implementering av equals i Person

	private String name;

	public Person(final String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		checkName(name);  
		this.name = name;
	}

	// Trenger ikke returnere noe, den utløser unntak hvis den finner noe.
	// Unntaket skriver ikke automatisk ut, som sagt på forelesning (overtrøtt...)
	// Det skrives ut der en fanger opp feilen, se catch i main.
	private void checkName(final String name) {
		for (int i = 0; i < name.length(); i++) {
			final char c = name.charAt(i);
//			System.out.println("'"+c+"'");
//			System.out.println(" .-".indexOf('%'));
			if (! (Character.isLetter(c) || " -".indexOf(c) >= 0)) {
				throw new NameValidationException(this, name);
			}
		}
	}

	public static void main(final String[] args) {
		try {
			Person p = new Person("Per Hansen");
			Person p2 = new Person("Per@Hansen");
			System.out.println(p.getName());
		} catch (final NameValidationException e) {
			// Test F3 på getLocalizedMessage under. Da ender du opp på Throwable-klassen.
			// Denne igjen kaller getMessage. Den er beskrevet i NameValidationException,
			// og som sagt på forelesning vil den overskygge andre getMessage. Dermed skrives
			// den ut. Se foil 25 om arv.
			System.out.println(e.getLocalizedMessage()); 
		}
	}

}
