package of13.v2020.kode;

public abstract class Employee {

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
		if (!canPerformTask(task)) {
			throw new IllegalArgumentException(name + " can not perform task: " + task);
		}
		
		System.out.println(name + " [" + role + "] performed task " + task);
	}
	
	public abstract boolean canPerformTask(String task);
	
}
