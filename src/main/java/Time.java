import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    private static final Logger log = Logger.getLogger(Time.class.getName());

    private Date date;

    private int hours;

    public Time(Date date) {
        this.date = date;
        log.info("Created the object type (Time) parameter with the date (" + date + ").");
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public String getCurrentTime() {
        Date currentDate = getDate();
        getCurrentHours(currentDate);

        String currentTime;
        if (hours >= 6 && hours <= 9)
            currentTime = "morning";
        else if (hours > 9 && hours <= 19)
            currentTime = "day";
        else if (hours > 19 && hours <= 23)
            currentTime = "evening";
        else
            currentTime = "night";

        log.info("Determine the time of day (result = " + currentTime + ").");

        return currentTime;
    }

    private void getCurrentHours(Date currentDate){
        SimpleDateFormat formatHours = new SimpleDateFormat("H");

        hours = Integer.parseInt(formatHours.format(currentDate));

        log.info("Get the time in hours (result = " + hours + ").");
    }
}
