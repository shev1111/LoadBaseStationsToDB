package dao.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JdbcPropManager {


    public static String getProperty(String property) {
        try {
            InputStream inputStream = new FileInputStream("E:\\JAVA_PROGRAMING\\JAVA_WORKSPASE\\LoadBaseStationsToDB\\src\\jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            String receiveProp = properties.getProperty(property);
            if(receiveProp!=null)return receiveProp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
