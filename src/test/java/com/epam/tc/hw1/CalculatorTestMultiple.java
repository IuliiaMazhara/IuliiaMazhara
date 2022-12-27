//package com.epam.tc.hw1;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//
//public class CalculatorTestMultiple extends TestingArithmeticOperations {
//
//    @DataProvider(name = "data-provider-for-multiple")
//    public Object[][] dataSetForSubtraction() {
//        return new Object[][]{{1, 2, 2}, {-2, -4, 8}, {-121, -4, 484}, {1, 1, 1}};
//    }
//
//    @Test(dataProvider = "data-provider-for-multiple", groups = {"divMultiplication"})
//    public void multipleTest(long a, long b, long expectedMultiple) {
//        long actualMultiple = calculator.mult(a, b);
//        assertThat(actualMultiple).isEqualTo(expectedMultiple);
//    }
//
//}
