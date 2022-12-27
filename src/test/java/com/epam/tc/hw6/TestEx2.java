package com.epam.tc.hw6;


import com.epam.tc.hw4.BaseTest;
import java.io.IOException;
import org.testng.annotations.Test;



public class TestEx2 extends BaseTest {
    @Test
    public void verifyDifferentElements() throws IOException {
        assertStep.assertTitle("Home Page");
        actionStep.loggIn();
        actionStep.navigateToDifferentElementsPage();
        actionStep.clickOnCheckBox("Water");
        assertStep.assertCheckBoxLog("Water");
        actionStep.clickOnCheckBox("Wind");
        assertStep.assertCheckBoxLog("Wind");
        actionStep.clickOnRadioBox("Selen");
        assertStep.assertRadioBoxLog("Selen");
    }

}