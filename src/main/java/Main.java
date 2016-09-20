import config.ConfigLog;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Main {

    private static final String LOG_PROPERTY_FILE = "src/main/resources/log4j.properties";
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ConfigLog logConfig = new ConfigLog(LOG_PROPERTY_FILE);
        logConfig.init();

        log.info("Starting");

        Locale currentLocale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message",currentLocale);

        log.info("Regional settings: " + currentLocale);

        Date currentDate = new Date();
        Time time = new Time();

        String currentTime = time.getCurrentTime(time.getCurrentHours(currentDate));

        outputDisplay(resourceBundle,currentTime);
    }

    private static void outputDisplay(ResourceBundle resourceBundle, String currentTime){
        try {
            String result = resourceBundle.getString(currentTime);
            System.out.println(result);
            log.info("Result = " + result);
        } catch (MissingResourceException e){
            log.error("Can't find resource for bundle java.util.PropertyResourceBundle, key " + currentTime);
        }
    }
}
