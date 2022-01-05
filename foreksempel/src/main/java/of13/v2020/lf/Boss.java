package of13.v2020.lf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boss extends Employee {

	private List<Employee> subordinates;
	
	public Boss(String name, List<Employee> subordinates) {
		super(name, "Boss");
		
		if (subordinates.isEmpty()) {
			throw new IllegalArgumentException("A boss needs at least one subordinate");
		}
		
		this.subordinates = new ArrayList<>(subordinates);
	}
	
	public Boss(String name, Employee... employees) {
		this(name, Arrays.asList(employees));
	}
	
	@Override
	public void performTask(String task) {
		subordinates.stream()
					.filter((subordinate) -> subordinate.canPerformTask(task))
					.findAny()
					.orElseThrow(() -> new IllegalArgumentException("No subordinates can perform task: " + task))
					.performTask(task);
	}
	
	@Override
	public boolean canPerformTask(String task) {
		return subordinates.stream().anyMatch((subordinate) -> subordinate.canPerformTask(task));
	}
	
	public static void main(String[] args) {
		Assistant assitant = new Assistant("assitant1");
		TemporaryEmployee temp = new TemporaryEmployee("temp", "Assistant", 1);
		
		Boss boss = new Boss("Halvard", assitant, temp);
		
		boss.performTask("Arrange meeting");
		boss.performTask("Make video");
		boss.performTask("Make video");
	}

}
