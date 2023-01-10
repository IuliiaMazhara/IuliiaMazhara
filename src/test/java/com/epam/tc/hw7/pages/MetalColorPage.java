package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.entities.MetalColor;
import com.epam.tc.hw7.forms.MetalColorForm;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;


public class MetalColorPage extends WebPage {

    public MetalColorForm metalColorForm;

    @Css(".results li")
    private WebList log;

    public void fillMetalAndColorForm(MetalColor metalColor) {
        metalColorForm.fill(metalColor);
    }

    public void assertResultLog(MetalColor metalColor) {
        Assertions.assertThat(metalColor.getExpectedResultLog())
                .hasSameElementsAs(actualResultLog());
    }

    public List<String> actualResultLog() {
        List<String> expectedResult = new ArrayList<>();
        log.forEach(els -> {
            expectedResult.add(els.getText());
        });
        return expectedResult;
    }
}
