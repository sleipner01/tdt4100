package of13.v2020.kode;

public class TemporaryEmployee extends Employee {

	private int numberOfRemainingTasks;
	
	public TemporaryEmployee(String name, String role, int numberOfTasks) {
		super(name, role);
		
		numberOfRemainingTasks = numberOfTasks;
	}
	
	@Override
	public void performTask(String task) {
		if (numberOfRemainingTasks <= 0) {
			throw new IllegalStateException(getName() + " has performed all their tasks");
		}
		
		super.performTask(task);
		
		numberOfRemainingTasks--;
		// numberOfRemainingTasks -= 1;
		// numberOfRemainingTasks = numberOfRemainingTasks - 1;
		
		if (numberOfRemainingTasks == 0) {
			role = "Quit";
		}
	}

	@Override
	public boolean canPerformTask(String task) {
		return numberOfRemainingTasks > 0;
	}
	
	
	public static void main(String[] args) {
		TemporaryEmployee employee = new TemporaryEmployee("Halvard", "Vitass", 2);
		employee.performTask("Svare på mail");
		System.out.println(employee.getRole());
		employee.performTask("Svare på mail");
		System.out.println(employee.getRole());
		employee.performTask("Svare på mail");
	}

}
