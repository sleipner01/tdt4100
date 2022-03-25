package of6.delegation.lf;

import java.util.ArrayList;
import java.util.List;

public class CallCenter implements CallRecipient {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public Employee getEmployeeForTask(String role) {
        return employees.stream()
                .filter(employee -> employee.getRole().equals(role))
                .min((employee1, employee2) -> employee1.getNumberOfCallsAnswered()
                        - employee2.getNumberOfCallsAnswered())
                .get();
    }

    @Override
    public void answerCall(String call) {
        String role = switch (call) {
            case "spørsmål", "klage" -> "Junior";
            case "eskalering" -> "Teamleder";
            case "intern" -> "HR";
            default -> "Junior";
        };
        getEmployeeForTask(role).answerCall(call);
    }

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        List<Employee> employeeList = List.of(
                new Employee("Børge", "Teamleder"),
                new Employee("Magnus", "Junior"),
                new Employee("Nora", "Junior"),
                new Employee("Jostein", "Junior"),
                new Employee("Mattias", "Teamleder"),
                new Employee("Eirik", "HR"));
        employeeList.forEach(employee -> callCenter.addEmployee(employee));

        callCenter.answerCall("klage");
        callCenter.answerCall("klage");
        callCenter.answerCall("internt");
        callCenter.answerCall("eskalering");
        callCenter.answerCall("spørsmål");
        callCenter.answerCall("klage");
        callCenter.answerCall("eskalering");
        callCenter.answerCall("spørsmål");
        callCenter.answerCall("spørsmål");
        employeeList.forEach(
                employee -> System.out.println(employee.getName() + " " + employee.getNumberOfCallsAnswered()));
    }

}
