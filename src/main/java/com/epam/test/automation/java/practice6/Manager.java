package com.epam.test.automation.java.practice6;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement code according to description of task.
 * </summary>
 */
public class Manager extends Employee{
    //number of clients, who were served by the manager during a month
    private int quantity;

    public Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);

        if(clientAmount < 0){
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        this.quantity = clientAmount;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        if(bonus == null || bonus.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Bonus cannot be null or negative.");
        }

        BigDecimal result;

        if(quantity > 150){
            result = bonus.add(BigDecimal.valueOf(1000));
        } else if(quantity > 100){
            result = bonus.add(BigDecimal.valueOf(500));
        } else result = bonus;

        this.bonus = result;
    }
}
