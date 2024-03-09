package cin.ufpe.aps.AluCar.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader() {
        try (InputStream input = new FileInputStream("C:/Users/gugac/APS/ServicoCarro/src/main/resources/application.properties")) {
            System.out.println(input);
            properties = new Properties();
            properties.load(input);
            System.out.println(properties);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
