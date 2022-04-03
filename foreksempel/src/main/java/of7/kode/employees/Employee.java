package of7.kode.employees;

public class Employee {

	private String name;
	protected String role;

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

	public void performTask(String task) {
		System.out.println(name + " [" + role + "] performed task: " + task);
	}

}
