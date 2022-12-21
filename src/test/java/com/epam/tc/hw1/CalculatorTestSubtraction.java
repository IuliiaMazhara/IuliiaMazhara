//package com.epam.tc.hw1;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//
//public class CalculatorTestSubtraction extends TestingArithmeticOperations {
//
//    @DataProvider(name = "data-provider-for-sub")
//    public Object[][] dataSetForSubtraction() {
//        return new Object[][]{{1, 2, -1}, {-2, -4, 2}, {-121, -4, -117}, {0, 0, 0}};
//    }
//
//    @Test(dataProvider = "data-provider-for-sub", groups = {"subAdd"})
//    public void subTest(long a, long b, long expectedSub) {
//        long actualSub = calculator.sub(a, b);
//        assertThat(actualSub).isEqualTo(expectedSub);
//    }
//
//}
