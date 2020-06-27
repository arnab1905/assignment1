package pages.ketto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config_class {


    public Properties configClass(){

        String userdir = System.getProperty("user.dir");

        File file1 = new File(userdir+"\\src\\main\\resources\\config.properties");
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file1);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        Properties prop = new Properties();

        try {
            prop.load(fileInputStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return prop;
    }

}