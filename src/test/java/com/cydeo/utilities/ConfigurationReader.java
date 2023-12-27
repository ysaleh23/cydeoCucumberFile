package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
in this Class, we will be creating the re-usable logic to read from configuration.properties file
 */
public class ConfigurationReader {
        //Steps to read from Properties type of file
        //1- Create object of properties
        private static Properties properties = new Properties();

        static {

            try {
                //2- We need to open the file in the Java memory using FileInputStream
                //3- Load the properties file in the properties object
                FileInputStream file = new FileInputStream("configuration.properties");
                properties.load(file);
                file.close();

            } catch (IOException e) {
                System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
                e.printStackTrace();
            }

        }

    //4- Use the "properties" object to read value from the value from the file
    public static String getProperty(String keyword){
            return properties.getProperty(keyword);
    }

}
