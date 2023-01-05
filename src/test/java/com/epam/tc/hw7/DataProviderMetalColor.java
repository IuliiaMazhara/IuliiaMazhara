package com.epam.tc.hw7;

import com.epam.tc.hw7.enteties.MetalColor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;


public class DataProviderMetalColor {

    private static final String path = "src/test/resources/JdiDataSet.json";

    Object[][] object;

    @DataProvider(name = "DataProviderJson")
    public Object[][] dataProviderMetalColor() {

        {
            ObjectMapper mapper = new ObjectMapper();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            HashMap<String, MetalColor> map = null;
            try {
                map = mapper.readValue(fileInputStream,
                        new TypeReference<HashMap<String, MetalColor>>() {
                        });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int i = 0;
            object = new Object[map.size()][1];
            for (Map.Entry<String, MetalColor> entry : map.entrySet()) {
                object[i][0] = entry.getValue();
                i++;
            }

        }
        return object;
    }
}
