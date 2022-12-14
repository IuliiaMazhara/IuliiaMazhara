package com.epam.tc.hw3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getPropertyObject() throws IOException {
        String path = new File("src\\test\\resources\\config.properties").getAbsolutePath();
        FileInputStream fp = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(fp);
        return prop;
    }

    public static String getUserName() throws IOException {
        return getPropertyObject().getProperty("userName");
    }

    public static String getUserPassword() throws IOException {
        return getPropertyObject().getProperty("password");
    }

}
