package uke13.arv;

import java.util.ArrayList;
import java.util.Collection;

public class Person {

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

	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	// Trenger ikke returnere noe, den utløser unntak hvis den finner noe.
	// Unntaket skriver ikke automatisk ut, men det skrives ut der en fanger opp feilen,
	// se catch i main.
	private void checkName(final String name) {
		for (int i = 0; i < name.length(); i++) {
			final char c = name.charAt(i);
			if (! (Character.isLetter(c) || " -".indexOf(c) >= 0)) {
				throw new NameValidationException(this, name);
			}
		}
	}

	public static void main(final String[] args) {
		try {
			// Lysark 16
			Person p = new Person("Per");
			System.out.println(p);


			// Lysark 18
			Collection<Person> c = new ArrayList<>();
			c.add(p);
			System.out.println(c.contains(new Person("Anne"))); // Nope
			System.out.println(c.contains(new Person("Per")));  // Yay, siden alt vi sjekker for likhet er navnet.

			// Lysark NameValidationException
			Person p2 = new Person("Per Berg-Hansen"); // Lovlig grunnet indexOf-sjekken.
			Person p3 = new Person("Per@Hansen"); // ulovlig
			System.out.println(p.getName());
		} catch (final NameValidationException e) {
			// Test F3 på getLocalizedMessage under. Da ender du opp på Throwable-klassen.
			// Denne igjen kaller getMessage(). Den er overskrevet i NameValidationException,
			// som da vil skygge over Throwableklassen sin getMessage(). På den måten skrives
			// den ut. Se foil 25 om arv.
			System.out.println("Feil: "+e.getLocalizedMessage()); 
		}
	}

}
