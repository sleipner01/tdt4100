package of7.kode.employees;

public class Consultant extends Employee {

    private int numberOfRemainingTasks;

    public Consultant(String name, String role, int numberOfRemainingTasks) {
        super(name, role);
        this.numberOfRemainingTasks = numberOfRemainingTasks;
    }

    @Override
    public boolean canPerformTask(String task) {
        return numberOfRemainingTasks > 0;
    }

    @Override
    public void performTask(String task) {
        if (!canPerformTask(task)) {
            throw new IllegalArgumentException(this.getName() + " has performed all of their tasks");
        }
        super.performTask(task);
        numberOfRemainingTasks -= 1;
        if (numberOfRemainingTasks == 0) {
            role = "Quit";
        }
    }

    public static void main(String[] args) {
        Consultant employee = new Consultant("Magnus", "Sommerjobber", 2);
        employee.performTask("Svare på mail");
        System.out.println(employee.getRole());
        employee.performTask("Svare på mail");
        System.out.println(employee.getRole());
        employee.performTask("Svare på mail");
    }

}
