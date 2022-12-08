package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class TestingArithmeticOperations {

    protected Calculator calculator;

    @BeforeMethod
    public void initializeCalculator() {

        calculator = new Calculator();

    }

    @AfterMethod
    public void clearCalculator() {

        calculator = null;

    }

}
