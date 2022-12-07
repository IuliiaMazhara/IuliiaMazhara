package com.epam.tc.hw1;


import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTestAddition extends TestingArithmeticOperations {

    @DataProvider(name = "data-provider-for-addition")
    public Object[][] dataSetForAddition() {

        return new Object[][]{{1, 2, 3}, {-2, -4, -6}, {-121, -4, -125}, {0, 0, 0}};

    }

    @Test(dataProvider = "data-provider-for-addition", groups = {"subAdd"})
    public void sumTest(long a, long b, long expectedAddition) {

        long actualAddition = calculator.sum(a, b);
        assertThat(actualAddition).isEqualTo(expectedAddition);

    }

}
