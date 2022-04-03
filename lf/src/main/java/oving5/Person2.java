package oving5;

public class Person2 implements Named {

	private String fullName;

	public Person2(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGivenName() {
		// Alternativt:
		// return this.fullName.split(" ")[0]
		return this.fullName.substring(0, this.fullName.indexOf(' '));
	}

	public void setGivenName(String givenName) {
		this.fullName = givenName + " " + getFamilyName();
	}

	public String getFamilyName() {
		// Alternativt:
		// return this.fullName.split(" ")[1]
		return this.fullName.substring(this.fullName.indexOf(' ') + 1);
	}

	public void setFamilyName(String familyName) {
		this.fullName = getGivenName() + " " + familyName;
	}
}
