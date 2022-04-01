package oving6.delegation.office;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {

    private List<Employee> employees;
    private int employeeIndex;
    private int taskCount;

    public Manager(Collection<Employee> employees) throws IllegalArgumentException {
        if(employees.size() == 0)
            throw new IllegalArgumentException("A manager must have employees");
        this.employees = new ArrayList<>(employees);
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        taskCount++;
        if(employeeIndex == employees.size()) employeeIndex = 0;
        return employees.get(employeeIndex++).doCalculations(operation, value1, value2);
    }

    @Override
    public void printDocument(String document) {
        taskCount++;
        if(employeeIndex == employees.size()) employeeIndex = 0;
        employees.get(employeeIndex++).printDocument(document);
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        int resourceCount = 0;
        for (Employee employee : employees) {
            resourceCount += employee.getResourceCount();
        }
        return resourceCount + 1;
    }

    public static void main(String[] args) {

        // First 
        List<Employee> clerks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            clerks.add(new Clerk(new Printer()));
        }
        Employee manager = new Manager(clerks);

        System.out.println();
        System.out.println("First");
        System.out.println();

        for (int i = 0; i < 100; i++) {
            manager.doCalculations((x, y) -> x+y, 1, 1);
            System.out.println(manager.getTaskCount() / manager.getResourceCount());
        }

        System.out.println();
        System.out.println("______________");
        System.out.println();





        // Second 
        List<Employee> managers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<Employee> clerksTemp = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                clerksTemp.add(new Clerk(new Printer()));
            }
            managers.add(new Manager(clerksTemp));
        }

        Employee cfo = new Manager(managers);

        System.out.println();
        System.out.println("Second");
        System.out.println();

        for (int i = 0; i < 100; i++) {
            cfo.doCalculations((x, y) -> x+y, 1, 1);
            System.out.println(cfo.getTaskCount() / cfo.getResourceCount());
        }

        System.out.println();
        System.out.println("______________");
        System.out.println();





        // Third 
        List<Employee> cfos = new ArrayList<>();

        for (int k = 0; k < 5; k++) {
            List<Employee> managersTemp = new ArrayList<>();
    
            for (int i = 0; i < 5; i++) {
                List<Employee> clerksTemp = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    clerksTemp.add(new Clerk(new Printer()));
                }
                managersTemp.add(new Manager(clerksTemp));
            }

            cfos.add(new Manager(managers));
        }

        Employee ceo = new Manager(cfos);

        System.out.println();
        System.out.println("Third");
        System.out.println();

        for (int i = 0; i < 100; i++) {
            ceo.doCalculations((x, y) -> x+y, 1, 1);
            System.out.println(ceo.getTaskCount() / ceo.getResourceCount());
        }

        System.out.println();
        System.out.println("______________");
        System.out.println();
    }
    
}
