package oving6.delegation.office;

import java.util.ArrayList;
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
        if(employeeIndex == employees.size()-1) employeeIndex = 0;
        return employees.get(employeeIndex++).doCalculations(operation, value1, value2);
    }

    @Override
    public void printDocument(String document) {
        taskCount++;
        if(employeeIndex == employees.size()-1) employeeIndex = 0;
        employees.get(employeeIndex++).printDocument(document);
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        return employees.size()+1;
    }
    
}
