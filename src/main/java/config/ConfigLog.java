package config;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLog {

    private static Properties logProperties = new Properties();
    private static String logFile;

    public ConfigLog(String logFile) {
        this.logFile = logFile;
    }

    public void init(){

        try {
            logProperties.load(new FileInputStream(logFile));
            PropertyConfigurator.configure(logProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
