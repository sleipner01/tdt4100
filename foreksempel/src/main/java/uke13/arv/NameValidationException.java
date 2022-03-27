package uke13.arv;

public class NameValidationException extends IllegalArgumentException{
	private final Person person;
	private final String illegalName;

	public NameValidationException(final  Person person, final String illegalName) {
		this.person = person;
		this.illegalName = illegalName;
	}

	// Merk at vi ikke har noen toString() her. Det har ingen unntak, så vi må helt opp til Throwable

	@Override
	// Denne skrives ut i catch-metoden i person. Via Throwable sin getLocalizedMessage().
	public String getMessage() {
		return illegalName + " is illegal for " + person;
	}
}
