package com.epam.tc.hw7;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.enteties.MetalColor;
import com.epam.tc.hw7.forms.MetalColorForm;
import org.assertj.core.api.Assertions;


public class MetalColorPage extends WebPage {

    public MetalColorForm metalColorForm;
    public MetalColor metalColor;

    public void fillMetalAndColorForm(MetalColor metalColor) {
        metalColorForm.fill(metalColor);
    }

    public void assertResultLog(MetalColor metalColor) {
        Assertions.assertThat(metalColor.getActualResultLog())
                .hasSameElementsAs(metalColorForm.expectedActualResultLog());
    }
}
