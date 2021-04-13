package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement code according to description of task.
 * </summary>
 */
public class SalesPerson extends Employee{
    //percent of sales targets plan performance/execution
    private int percent;

    public SalesPerson(String name, BigDecimal salary, int percent) {
        super(name, salary);

        if(percent < 0){
            throw new IllegalArgumentException("Percent cannot be negative.");
        }

        this.percent = percent;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        if(bonus == null || bonus.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Bonus cannot be null or negative.");
        }

        BigDecimal result;

        if(this.percent > 200){
            result = bonus.multiply(BigDecimal.valueOf(3));
        } else if(this.percent > 100){
            result = bonus.multiply(BigDecimal.valueOf(2));
        } else result = bonus;

        this.bonus = result;
    }
}
