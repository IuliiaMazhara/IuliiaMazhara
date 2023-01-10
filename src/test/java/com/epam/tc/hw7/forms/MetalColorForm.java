package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalColor;


public class MetalColorForm extends Form<MetalColor> {

    @FindBy(css = "#elements-checklist input")
    public Checklist elementsOfEarth;

    @FindBy(name = "custom_radio_odd")
    public RadioButtons oddNumbers;

    @FindBy(name = "custom_radio_even")
    public RadioButtons evenNumbers;

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown color;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Dropdown metals;

    @FindBy(id = "salad-dropdown")
    private Button buttonVegetables;

    @FindBy(css = "#salad-dropdown  input")
    private Checklist saladList;

    @FindBy(id = "submit-button")
    private Button submit;

    @Override
    public void fill(MetalColor metalColor) {
        oddNumbers.select(metalColor.getSummary().get(0));
        evenNumbers.select(metalColor.getSummary().get(1));
        metalColor.getElements().forEach(elementsOfEarth::select);
        color.select(metalColor.getColor());
        metals.select(metalColor.getMetals());
        buttonVegetables.click();
        saladList.select("Vegetables");
        metalColor.getVegetables().forEach(saladList::select);
        submit.click();
    }
}
