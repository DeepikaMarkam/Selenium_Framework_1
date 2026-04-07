package org.testingacdemcy.Utils.waitHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String readKey (String key)
    {
        Properties p;
        String user_dir = System.getProperty("user.dir");
//        user.dir = working directory = //D:\MYLEARNINGPROJECT\JAVASELENIUM\Selenium_Framework_1
        //D:\MYLEARNINGPROJECT\JAVASELENIUM\Selenium_Framework_1\src\main\resources\data.properties
        String filePath = user_dir + "/src/main/resources/data.properties";
//        System.out.println("filePath =" +filePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            p =new Properties();
            p.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p.getProperty(key);
    }
}
