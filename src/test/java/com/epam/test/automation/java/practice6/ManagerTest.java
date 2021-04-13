package com.epam.test.automation.java.practice6;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement code according to description of task.
 * </summary>
 */
public class ManagerTest {
    Manager manager;
    BigDecimal salary = new BigDecimal("6349068474734");

    @Test
    public void constructorPositiveTest(){
        manager = new Manager("name", salary, 20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Salary cannot be negative.")
    public void constructorNegativeSalaryTest(){
        BigDecimal negativeSalary = new BigDecimal("-53597876");
        manager = new Manager("name", negativeSalary, 20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Quantity cannot be negative")
    public void constructorNegativeClientsTest(){
        manager = new Manager("name", salary, -20);
    }

    @Test
    public void setPositiveBonusTest(){
        BigDecimal bonus = new BigDecimal("523802665");
        manager = new Manager("name", salary, 20);
        manager.setBonus(bonus);

        Assert.assertEquals(manager.getBonus(), bonus);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Bonus cannot be null or negative.")
    public void setNegativeBonusTest(){
        manager = new Manager("name", salary, 20);
        manager.setBonus(new BigDecimal("-1"));
    }

    @Test
    public void setBonusWithMoreThen100ClientsTest(){
        manager = new Manager("name", salary, 120);
        BigDecimal bonus = new BigDecimal("523802665");

        manager.setBonus(bonus);

        Assert.assertEquals(manager.getBonus(), bonus.add(BigDecimal.valueOf(500)));
    }
    @Test
    public void setBonusWithMoreThen150ClientsTest(){
        manager = new Manager("name", salary, 1120);
        BigDecimal bonus = new BigDecimal("523802665");

        manager.setBonus(bonus);

        Assert.assertEquals(manager.getBonus(), bonus.add(BigDecimal.valueOf(1000)));
    }

    @Test
    public void toPayTest(){
        manager = new Manager("name", salary, 20);
        BigDecimal bonus = new BigDecimal("5373432");

        manager.setBonus(bonus);

        Assert.assertEquals(manager.toPay(), salary.add(bonus));
    }

}
