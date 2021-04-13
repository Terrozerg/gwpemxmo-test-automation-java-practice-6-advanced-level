package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;
import java.util.*;

/**
 * <summary>
 * Implement code according to description of task.
 * </summary>
 */
public class Company {
    private List<Employee> employees;

    public Company(Employee ...employees) {
        this.employees = new ArrayList<>(Arrays.asList(employees));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void giveEverybodyBonus(BigDecimal companyBonus){
        employees.forEach(employee -> employee.setBonus(companyBonus));
    }

    public BigDecimal totalToPay(){
        return employees.stream()
                .map(Employee::toPay)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String nameMaxSalary(){
        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName)
                .orElseThrow();
    }
}
