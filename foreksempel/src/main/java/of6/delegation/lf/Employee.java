package of6.delegation.lf;

public class Employee implements CallRecipient {

	private String name;
	private String role;
	private int numberOfCallsAnswered = 0;

	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public int getNumberOfCallsAnswered() {
		return numberOfCallsAnswered;
	}

	@Override
	public void answerCall(String call) {
		System.out.println(name + " [" + role + "] answered call: " + call);
		numberOfCallsAnswered++;
	}

}
