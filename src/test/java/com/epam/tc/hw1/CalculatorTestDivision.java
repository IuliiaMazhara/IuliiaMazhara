package com.epam.tc.hw1;


import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTestDivision extends TestingArithmeticOperations {

    @DataProvider(name = "data-provider-for-division")
    public Object[][] dataSetForDivision() {

        return new Object[][]{{1, 2, 0}, {-2, -4, 0}, {-121, -4, 30}, {1, 1, 1}};

    }

    @Test(dataProvider = "data-provider-for-division", groups = {"divMultiplication"})
    public void divTest(long a, long b, long expectedQuotient) {

        long actualQuotient = calculator.div(a, b);
        assertThat(actualQuotient).isEqualTo(expectedQuotient);

    }

    @Test(groups = {"divMultiplication"})
    public void divBy0Test() {

        assertThatThrownBy(() -> calculator.div(1,0)).isInstanceOf(NumberFormatException.class);

    }

}
