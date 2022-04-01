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
        Printer printer = new Printer();
        Employee clerk = new Clerk(printer);
        Employee manager = new Manager(Arrays.asList(clerk));

        manager.printDocument("Aids");
        System.out.println(manager.getTaskCount());
        manager.doCalculations((x, y) -> x+y, 1, 2);
        System.out.println(manager.getTaskCount());
    }
    
}
