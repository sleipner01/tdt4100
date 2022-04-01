package of7.lf.employees;

import java.util.List;

public class Boss extends Employee {

    private List<Employee> subordinates;

    public Boss(String name, List<Employee> subordinates) {
        super(name, "Boss");
        if (subordinates.isEmpty()) {
            throw new IllegalArgumentException("A boss must have at least one subordinate");
        }
        this.subordinates = subordinates;
    }

    @Override
    public boolean canPerformTask(String task) {
        return subordinates.stream().anyMatch(subordinate -> subordinate.canPerformTask(task));
    }

    @Override
    public void performTask(String task) {
        subordinates.stream()
                .filter(subordinate -> subordinate.canPerformTask(task))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No subordinates to perform task!"))
                .performTask(task);
    }

    public static void main(String[] args) {
        Assistant assistant = new Assistant("Magnus");
        Consultant temp = new Consultant("Trine", "IT Consultant", 2);

        Boss boss = new Boss("Børge", List.of(assistant, temp));

        boss.performTask("Arrange meeting");
        boss.performTask("Order stock");
        boss.performTask("Pay salaries");

    }

}
