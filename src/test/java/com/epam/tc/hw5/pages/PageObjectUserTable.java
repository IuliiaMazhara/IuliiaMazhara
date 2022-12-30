package com.epam.tc.hw5.pages;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageObjectUserTable extends MainPage {

    public PageObjectUserTable(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tbody > tr")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "td > a")
    private List<WebElement> users;

    @FindBy(css = ".user-descr")
    private List<WebElement> images;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//*[@class = 'panel-body-list logs']//li")
    private List<WebElement> logs;

    @FindBy(xpath = "//td//a")
    private List<WebElement> userInTable;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> numberInTable;

    @FindBy(css = "[class='user-descr']")
    private List<WebElement> descInTable;

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUsers() {
        return users;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public void valueDropdown(String value) {
        numberTypeDropdowns.get(0).click();
        By dropElementPath = new By.ByXPath("//select/option[contains(. ,'" + value + "')]");
        WebElement dropdownValue = webDriver.findElement(dropElementPath);
        elementIsDisplayed(dropdownValue);
    }

    public void clickVipCheckBox(String checkboxOption) {
        By checkBoxElementPath = new By.ByXPath("//*[@id = '" + checkboxOption + "']");
        WebElement checkBoxValue = webDriver.findElement(checkBoxElementPath);
        checkBoxValue.click();
    }

    public void assertNumberOfLogItems(int numOfLogs) {
        assertThat(logs.size()).isEqualTo(numOfLogs);
    }

    public void assertLogText(String logText) {
        By logPath = new By.ByXPath("//li[contains(. ,'" + logText + "')]");
        WebElement log = webDriver.findElement(logPath);
        elementIsDisplayed(log);
    }

    public List<String> getUserInTableValues() {
        return userInTable.stream()
                .map(u -> u.getText())
                .collect(Collectors.toList());
    }

    public List<String> getNumberInTableValues() {
        return numberInTable.stream()
                .map(n -> n.getText())
                .collect(Collectors.toList());
    }

    public List<String> getDescInTableValues() {
        return descInTable.stream()
                .map(n -> n.getText())
                .map(n -> n.trim())
                .map(n -> n.replaceAll("\\s", " "))
                .map(n -> n.replaceAll("Vip", " "))
                .map(n -> n.trim())
                .collect(Collectors.toList());
    }
}
