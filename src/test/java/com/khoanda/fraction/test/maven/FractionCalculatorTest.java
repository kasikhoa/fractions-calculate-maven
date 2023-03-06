/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.khoanda.fraction.test.maven;

import com.khoanda.fractions.calculate.maven.Fraction;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Admin
 */
public class FractionCalculatorTest {

    @DataProvider(name = "addFractions")
    public Object[][] addFractions() {
        return new Object[][]{
            {new Fraction(1, 2), new Fraction(1, 3), "5/6"},
            {new Fraction(3, 4), new Fraction(2, 5), "23/20"},
            {new Fraction(0, 1), new Fraction(1, 2), "1/2"},};
    }

    @Test(dataProvider = "addFractions")
    public void testAddition(Fraction f1, Fraction f2, String expected) {
        Fraction result = f1.add(f2);
        String actual = Fraction.printFraction(result);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "subFractions")
    public Object[][] subFractions() {
        return new Object[][]{
            {new Fraction(1, 2), new Fraction(1, 3), "1/6"},
            {new Fraction(3, 4), new Fraction(2, 5), "7/20"},
            {new Fraction(0, 1), new Fraction(1, 2), "-1/2"},};
    }

    @Test(dataProvider = "subFractions")
    public void testSubtraction(Fraction f1, Fraction f2, String expected) {
        Fraction result = f1.sub(f2);
        String actual = Fraction.printFraction(result);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "mulFractions")
    public Object[][] mulFractions() {
        return new Object[][]{
            {new Fraction(1, 2), new Fraction(1, 3), "1/6"},
            {new Fraction(3, 4), new Fraction(2, 5), "3/10"},
            {new Fraction(0, 1), new Fraction(1, 2), "0/1"},};
    }

    @Test(dataProvider = "mulFractions")
    public void testMultiplication(Fraction f1, Fraction f2, String expected) {
        Fraction result = f1.mul(f2);
        String actual = Fraction.printFraction(result);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] divFractions() {
        return new Object[][]{
            {new Fraction(1, 2), new Fraction(1, 3), "3/2"},
            {new Fraction(3, 4), new Fraction(2, 5), "15/8"},
            {new Fraction(0, 1), new Fraction(1, 2), "0/1"},};
    }

    @Test(dataProvider = "divFractions")
    public void testDivision(Fraction f1, Fraction f2, String expected) {
        Fraction result = f1.div(f2);
        String actual = Fraction.printFraction(result);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "invalidDivFractions")
    public Object[][] invalidDivFractions() {
        return new Object[][]{
            {new Fraction(1, 2), new Fraction(0, 1)},
            {new Fraction(3, 4), new Fraction(0, 2)}
        };
    }

    @Test(dataProvider = "invalidDivFractions", expectedExceptions = IllegalArgumentException.class)
    public void testDivInvalidFractions(Fraction f1, Fraction f2) {
        Fraction result = f1.div(f2);
        Fraction.printFraction(result);
    }

}
