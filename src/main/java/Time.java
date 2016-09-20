import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    private static final Logger log = Logger.getLogger(Time.class.getName());

    public String getCurrentTime(int hours) {
        String currentTime = "";
        if (hours >= 0 && hours <= 23) {
            if (hours >= 6 && hours <= 9)
                currentTime = "morning";
            else if (hours >= 9 && hours <= 19)
                currentTime = "day";
            else if (hours >= 19 && hours <= 23)
                currentTime = "evening";
            else
                currentTime = "night";

            log.info("Determine the time of day (result = " + currentTime + ")");
        }
        return currentTime;
    }

    public int getCurrentHours(Date currentDate){
        SimpleDateFormat formatHours = new SimpleDateFormat("H");

        int currentHours = Integer.parseInt(formatHours.format(currentDate));

        log.info("Get the time in hours (result = " + currentHours + ")");

        return currentHours;
    }
}
