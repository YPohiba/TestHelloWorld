import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.*;

public class TimeTest {

    @Test
    public void testSameParamDate(){
        Date expected = new Date(2000, 1, 1, 23, 0, 0);
        Time time = new Time(expected);

        Date actual = time.getDate();

        assertSame("Not same", expected, actual);
    }

    @Test
    public void testGetNightTime() throws Exception {
        Date source = new Date(2000, 1, 1, 0, 0, 0);
        String expected = "night";

        Time time = new Time(source);
        String actual = time.getCurrentTime();

        assertTrue("Result (" + actual + ") is not NIGHT", actual.equals(expected));
    }

    @Test
    public void testSameGetMorningTime() throws Exception {
        Date source = new Date(2000, 1, 1, 8, 0, 0);
        String expected = "morning";

        Time time = new Time(source);
        String actual = time.getCurrentTime();

        assertSame(expected, actual);
    }

    @Test
    public void testNotNullGetEveningTime() throws Exception {
        Date source = new Date(2000, 1, 1, 20, 0, 0);
        String expected = "evening";

        Time time = new Time(source);
        String actual = time.getCurrentTime();

        assertNotNull("Result (" + actual + ") NULL", actual);
        assertEquals("Result (" + actual + ") is not Evening", expected, actual);
    }

    @Test
    public void testNotEmptyOutParam() throws Exception {
        Date source = new Date(2000, 1, 1, 1, 0, 0);
        String expected = "";

        Time time = new Time(source);
        String actual = time.getCurrentTime();

        assertNotSame("Result (" + actual + ") is empty", expected.equals(actual));
    }

    @Test
    public void testHoursIntervalDay() throws Exception {
        Date source = new Date(2000, 1, 1, 15, 0, 0);

        Time time = new Time(source);
        String result = time.getCurrentTime();

        int actual = time.getHours();

        assertTrue("The result is not in the correct interval", actual > 9 && actual <= 19);
    }

    @Test
    public void testHoursIntervalNight() throws Exception {
        Date source = new Date(2000, 1, 1, 2, 0, 0);

        Time time = new Time(source);
        String result = time.getCurrentTime();

        int actual = time.getHours();

        assertTrue("The result is not in the correct interval", actual >= 0 && actual <= 5);
    }
}
