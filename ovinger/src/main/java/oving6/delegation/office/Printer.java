package oving6.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Printer {
    
    HashMap<Employee, List<String>> printHistory = new HashMap<>();

    public void printDocument(String document, Employee employee) {
        System.out.println(document);
        printHistory.putIfAbsent(employee, new ArrayList<>());
        printHistory.get(employee).add(document);
    }

    public List<String> getPrintHistory(Employee employee) {
        if(!printHistory.containsKey(employee)) return new ArrayList<>();
        return new ArrayList<>(printHistory.get(employee));
    }

}
