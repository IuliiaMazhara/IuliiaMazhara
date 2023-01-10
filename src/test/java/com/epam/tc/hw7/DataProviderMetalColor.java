package com.epam.tc.hw7;

import com.epam.tc.hw7.entities.MetalColor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;


public class DataProviderMetalColor {

    Object[][] object;

    @DataProvider(name = "DataProviderJson")
    public Object[][] dataProviderMetalColor() {
        String path = "src/test/resources/JdiDataSet.json";
        {
            try {
                ObjectMapper mapper = new ObjectMapper();
                FileInputStream fileInputStream = new FileInputStream(path);
                HashMap<String, MetalColor> map = mapper.readValue(fileInputStream,
                        new TypeReference<HashMap<String, MetalColor>>() {
                        });
                int i = 0;
                object = new Object[map.size()][1];
                for (Map.Entry<String, MetalColor> entry : map.entrySet()) {
                    object[i][0] = entry.getValue();
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return object;
    }
}
