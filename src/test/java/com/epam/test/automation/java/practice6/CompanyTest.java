package com.epam.test.automation.java.practice6;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <summary>
 * Implement code according to description of task.
 * </summary>
 */
public class CompanyTest {
    Company company;
    Employee[] employees;

    @BeforeClass
    public void createEmployees(){
        employees = new Employee[]{
                new Manager("m1", BigDecimal.valueOf(500000), 10),
                new Manager("m2", BigDecimal.valueOf(600000), 10),
                new SalesPerson("sale", BigDecimal.valueOf(250000), 10)};
    }

    @Test
    public void constructorTest(){
        company = new Company(employees);

        Assert.assertEquals(company.getEmployees().size(), employees.length);
    }

    @Test
    public void giveEverybodyBonusTest(){
        company = new Company(employees);

        company.giveEverybodyBonus(BigDecimal.valueOf(10000));

        for (Employee employee : employees) {
            Assert.assertEquals(employee.getBonus(), BigDecimal.valueOf(10000));
        }
    }

    @Test
    public void totalToPayWithNoBonusesTest(){
        company = new Company(employees);
        BigDecimal total = new BigDecimal(0);

        for (Employee employee : employees) {
            total = total.add(employee.toPay());
        }

        Assert.assertEquals(company.totalToPay(), total);
    }

    @Test
    public void totalToPayWithBonusesTest(){
        company = new Company(employees);
        company.giveEverybodyBonus(BigDecimal.valueOf(5000));
        BigDecimal total = new BigDecimal(0);

        for (Employee employee : employees) {
            total = total.add(employee.toPay());
        }

        Assert.assertEquals(company.totalToPay(), total);
    }

    @Test
    public void nameMaxSalaryTest(){
        company = new Company(employees);

        Assert.assertEquals(company.nameMaxSalary(), "m2");
    }

    @Test
    public void nameMaxSalaryWithMultipleMaxSalariesTest(){
        Employee[] sameEmployees = new Employee[]{
                new Manager("m1", BigDecimal.valueOf(500000), 10),
                new Manager("m2", BigDecimal.valueOf(500000), 10),
                new SalesPerson("sale", BigDecimal.valueOf(250000), 10)};
        sameEmployees[0].setBonus(BigDecimal.valueOf(500000));

        company = new Company(sameEmployees);

        Assert.assertEquals(company.nameMaxSalary(), "m1");
    }

    @Test
    public void nameMaxSalaryWithBonusesTest(){
        Employee[] sameEmployees = new Employee[]{
                new Manager("m1", BigDecimal.valueOf(500000), 10),
                new Manager("m2", BigDecimal.valueOf(600000), 10),
                new SalesPerson("sale", BigDecimal.valueOf(250000), 10)};
        sameEmployees[0].setBonus(BigDecimal.valueOf(500000));

        company = new Company(sameEmployees);

        Assert.assertEquals(company.nameMaxSalary(), "m1");
    }
}
