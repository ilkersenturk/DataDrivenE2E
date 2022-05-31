package Utulities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

    private static Properties properties = new Properties();

    static  {

        try {
            FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Properties/config.properties");
            properties.load(in);
            in.close();

        } catch (IOException e) {
            System.out.println("Error occurred while reading config.properties" + e.getMessage());
        }
    }


    public static String read(String key){
        return properties.getProperty(key);
    }
}
