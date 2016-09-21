import org.junit.Test;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static junit.framework.Assert.*;

public class MainTest {

    @Test
    public void testGetHelloMorningEN() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("en", "US"));

        String source = "morning";
        String expected = "Good morning, World!";

        String actual = resourceBundle.getString(source);

        assertTrue("Result (" + actual + ") is not Good morning, World!", actual.equals(expected));
    }

    @Test
    public void testGetHelloDayEN() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("en", "US"));

        String source = "day";
        String expected = "Good day, World!";

        String actual = resourceBundle.getString(source);

        assertEquals("Result (" + actual + ") is not Good day, World!", expected, actual);
    }

    @Test(expected = MissingResourceException.class)
    public void testExpectedMessageKey(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("en", "US"));

        String source = "lunch";

        resourceBundle.getString(source);
    }

    @Test
    public void testNotNullParamOutputEN(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("en", "US"));

        String source = "evening";

        String actual = resourceBundle.getString(source);

        assertNotNull("Result (" + actual + ") NULL", actual);
    }

    @Test
    public void testGetHelloNightRU() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("ru", "RU"));

        String source = "night";
        String expected = "Доброй ночи, Мир!";

        String actual = resourceBundle.getString(source);

        assertTrue("Result (" + actual + ") is not Доброй ночи, Мир!", actual.equals(expected));
    }
}
