import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        log.info("Starting.");

        Locale currentLocale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message",currentLocale);

        log.info("Regional settings: " + currentLocale + ".");

        Date currentDate = new Date();
        Time time = new Time(currentDate);

        String currentTime = time.getCurrentTime();

        outputDisplay(resourceBundle,currentTime);

        log.info("Program completion.");
    }

    private static void outputDisplay(ResourceBundle resourceBundle, String currentTime){
        log.info("Result output to the screen.");
        if (resourceBundle != null && !currentTime.equals("")) {
            try {
                String result = resourceBundle.getString(currentTime);
                log.info("Result = " + result);
                System.out.println(result);
            } catch (MissingResourceException e) {
                log.error("Can't find resource for bundle java.util.PropertyResourceBundle, key " + currentTime + ".");
                System.out.println("An error has happened. For details, see the log file.");
            }
        } else {
            log.error("Incorrect variable value (resourceBundle) or (currentTime).");
            System.out.println("An error has happened. For details, see the log file.");
        }
    }
}
