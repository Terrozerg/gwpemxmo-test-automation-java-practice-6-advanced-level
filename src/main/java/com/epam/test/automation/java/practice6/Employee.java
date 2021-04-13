package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement code according to description of task.
 * </summary>
 */
public abstract class Employee {
    private String name;
    private BigDecimal salary;
    protected BigDecimal bonus;

    public Employee(String name, BigDecimal salary) {
        if(salary == null){
            throw new NullPointerException("Salary cannot be null.");
        }
        if(salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        this.name = name;
        this.salary = salary;
        this.bonus = new BigDecimal(0);
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public abstract void setBonus(BigDecimal bonus);

    public BigDecimal toPay(){
        if(bonus == null || bonus.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Bonus cannot be null or negative.");
        }

        return salary.add(bonus);
    }
}
