import org.junit.Test;

import static junit.framework.Assert.*;

public class TimeTest {

    @Test
    public void testGetNightTime() throws Exception {
        int source = 0;
        String expected = "night";

        Time time = new Time();
        String actual = time.getCurrentTime(source);

        assertTrue("Result (" + actual + ") is not NIGHT", actual.equals(expected));
    }

    @Test
    public void testSameGetCurrentTime() throws Exception {
        int source = 8;
        String expected = "morning";

        Time time = new Time();
        String actual = time.getCurrentTime(source);

        assertSame(expected, actual);
    }

    @Test
    public void testNotNullGetCurrentTime() throws Exception {
        int source = -5;
        String expected = "";

        Time time = new Time();
        String actual = time.getCurrentTime(source);

        assertNotNull("Result (" + actual + ") NULL",actual);
        assertEquals(expected,actual);
    }
}
