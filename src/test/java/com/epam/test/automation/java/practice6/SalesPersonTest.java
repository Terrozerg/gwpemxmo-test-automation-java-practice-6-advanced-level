package com.epam.test.automation.java.practice6;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement code according to description of task.
 * </summary>
 */
public class SalesPersonTest {
    SalesPerson salesPerson;
    BigDecimal salary = new BigDecimal("6349068474734");

    @Test
    public void constructorPositiveTest(){
        salesPerson = new SalesPerson("name", salary, 20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Salary cannot be negative.")
    public void constructorNegativeSalaryTest(){
        BigDecimal negativeSalary = new BigDecimal("-53597876");
        salesPerson = new SalesPerson("name", negativeSalary, 20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Percent cannot be negative.")
    public void constructorNegativeClientsTest(){
        salesPerson = new SalesPerson("name", salary, -20);
    }

    @Test
    public void setPositiveBonusTest(){
        BigDecimal bonus = new BigDecimal("523802665");
        salesPerson = new SalesPerson("name", salary, 20);
        salesPerson.setBonus(bonus);

        Assert.assertEquals(salesPerson.getBonus(), bonus);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Bonus cannot be null or negative.")
    public void setNegativeBonusTest(){
        salesPerson = new SalesPerson("name", salary, 20);
        salesPerson.setBonus(new BigDecimal("-523802665"));
    }

    @Test
    public void setBonusWithMoreThen100PercentTest(){
        salesPerson = new SalesPerson("name", salary, 120);
        BigDecimal bonus = new BigDecimal("523802665");

        salesPerson.setBonus(bonus);

        Assert.assertEquals(salesPerson.getBonus(), bonus.multiply(BigDecimal.valueOf(2)));
    }
    @Test
    public void setBonusWithMoreThen200PercentTest(){
        salesPerson = new SalesPerson("name", salary, 350);
        BigDecimal bonus = new BigDecimal("523802665");

        salesPerson.setBonus(bonus);

        Assert.assertEquals(salesPerson.getBonus(), bonus.multiply(BigDecimal.valueOf(3)));
    }

    @Test
    public void toPayTest(){
        salesPerson = new SalesPerson("name", salary, 20);
        BigDecimal bonus = new BigDecimal("5373432");

        salesPerson.setBonus(bonus);

        Assert.assertEquals(salesPerson.toPay(), salary.add(bonus));
    }
}
