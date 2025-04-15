package org.example;


import org.example.entity.*;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> employeeMap;

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Osman", "Postal"));
        employees.add(new Employee(2, "Yılmaz", "Kaya"));
        employees.add(new Employee(1, "Osman", "Postal"));
        employees.add(new Employee(3, "Semih", "Kızıl"));
        employees.add(new Employee(2, "Yılmaz", "Kaya"));

        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniqueEmployees = findUniques(employees);
        List<Employee> removedEmployees = removeDuplicates(employees);

        System.out.println("Tekrar eden çalışanlar: ");
        for (Employee e : duplicates) {
            System.out.println(e.getId());
        }

        for(Map.Entry<Integer, Employee> entry : uniqueEmployees.entrySet()) {
            System.out.println(entry.getKey());
        }

        for(Employee emp : removedEmployees) {
            System.out.println(emp);
        }

        Map<String, Integer> sonuc = WordCounter.calculatedWord();
        for(Map.Entry<String, Integer> entry : sonuc.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();//Set yapısı --> aynı elemanı birden fazla kez içeremez.
        List<Employee> duplicates = new ArrayList<>();

        for (Employee emp : employees) {
            if (!seen.add(emp)) {
                duplicates.add(emp);
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }

        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());

        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }

}