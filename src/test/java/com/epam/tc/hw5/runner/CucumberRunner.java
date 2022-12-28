package com.epam.tc.hw5.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class CucumberRunner {

    @CucumberOptions(
            features = {"C:/Users/Iuliia_Mazhara/IdeaProjects/TA_2_Part_Mazhara/src/test/resources/features"},
            glue = {"com.epam.tc.hw5.step"})


    public class CucumberTestRun extends AbstractTestNGCucumberTests {
    }
}
