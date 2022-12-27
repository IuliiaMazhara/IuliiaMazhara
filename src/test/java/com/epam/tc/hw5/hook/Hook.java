package com.epam.tc.hw5.hook;


import com.epam.tc.hw5.utils.DriverManagerUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hook {

    @Before
    public void setUp() {
        DriverManagerUtils.setupDriver();
    }

    @After
    public static void tearDownDriver() {
        DriverManagerUtils.tearDownDriver();
    }
}
