package com.epam.tc.hw4;

import io.qameta.allure.Allure;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoBrokenTest {
    @BeforeMethod
    public void setUp() {
        throw new ArithmeticException();
    }

    @Test
    public void testNoOp() {
        Allure.step("noop");
    }
}
