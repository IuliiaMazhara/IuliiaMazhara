package com.epam.tc.hw7.enteties;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class MetalColor {

    @JsonProperty("summary")
    private List<String> summary;

    @JsonProperty("elements")
    private List<String> elements;

    @JsonProperty("color")
    private String color;

    @JsonProperty("metals")
    private String metals;

    @JsonProperty("vegetables")
    private List<String> vegetables;


    public MetalColor() {

    }

    public MetalColor(List<String> summary, List<String> elements, String color,
                      String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setSummary(List<String> summary) {
        this.summary = summary;
    }

    public List<String> getActualResultLog() {
        int sumOfOddEvenNumbers = Integer.parseInt(getSummary().get(0)) + Integer.parseInt(getSummary().get(1));
        List<String> actualResult = new ArrayList<>();
        String elementsEarth = convertStringArrayToString(getElements(), ",");
        String vegetables = convertStringArrayToString(getVegetables(), ",");
        actualResult.add("Color: " + getColor());
        actualResult.add("Metal: " + getMetals());
        actualResult.add("Summary: " + sumOfOddEvenNumbers);
        actualResult.add("Elements: " + elementsEarth);
        actualResult.add("Vegetables: " + vegetables);
        return actualResult;
    }

    private static String convertStringArrayToString(List<String> strArr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(delimiter).append(' ');
        }
        return sb.substring(0, sb.length() - 2);
    }
}
