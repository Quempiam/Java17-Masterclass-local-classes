package dev.que;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Leroy", "Jenkins", 2020));
        employeeList.add(new Employee("Ligma", "Johnson", 2022));
        employeeList.add(new Employee("Candice", "Naats", 2013));
        employeeList.add(new Employee("Shrek", "Forever", 2018));

        System.out.printf("Employees:\n%-15s %-15s %s\n", "FIRST NAME", "LAST NAME", "HIRE YEAR");
        for (Employee e : employeeList) {
            System.out.println(e);
        }
        System.out.println("-".repeat(30));

        printSortedEmployees(employeeList);
    }

    static void printSortedEmployees(List<? extends Employee> employeeLList) {
        class EmployeeWrapper {
            Employee employee;
            String fullName;
            int yearsWorked;

            EmployeeWrapper(Employee employee) {
                this.employee = employee;
                this.fullName = employee.lastName() + " " + employee.firstName();
                this.yearsWorked = LocalDate.now().getYear() - employee.hireDate();
            }

            @Override
            public String toString() {
                return "%-30s %d".formatted(fullName, yearsWorked);
            }
        }

        List<EmployeeWrapper> sortedEmployees = new ArrayList<>();
        for (Employee e : employeeLList) {
            sortedEmployees.add(new EmployeeWrapper(e));
        }

        // sorting using anonymous class
        sortedEmployees.sort(new Comparator<EmployeeWrapper>() {
            @Override
            public int compare(EmployeeWrapper o1, EmployeeWrapper o2) {
                return o1.yearsWorked - o2.yearsWorked;
            }
        });

        System.out.println("Employees sorted by years worked:");
        for (EmployeeWrapper e : sortedEmployees) {
            System.out.println(e);
        }
        System.out.println("-".repeat(30));

        sortedEmployees.sort(new Comparator<EmployeeWrapper>() {
            @Override
            public int compare(EmployeeWrapper o1, EmployeeWrapper o2) {
                return o1.fullName.compareTo(o2.fullName);
            }
        }.reversed());

        System.out.println("Employees sorted by full name (descending):");
        for (EmployeeWrapper e : sortedEmployees) {
            System.out.println(e);
        }
        System.out.println("-".repeat(30));
    }
}