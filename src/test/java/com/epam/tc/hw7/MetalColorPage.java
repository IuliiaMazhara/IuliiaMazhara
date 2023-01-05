package com.epam.tc.hw7;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.enteties.MetalColor;
import com.epam.tc.hw7.forms.MetalColorForm;

public class MetalColorPage extends WebPage {

    public MetalColorForm metalColorForm;

    public void fillMetalAndColorForm(MetalColor metalColor) {
        metalColorForm.fillForm(metalColor);
    }

    public void verifyResultRows(MetalColor metalColor) {

    }
}
