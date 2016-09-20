import org.junit.Test;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static junit.framework.Assert.*;

public class MainTest {

    @Test
    public void testGetHelloMorningEN() throws MissingResourceException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("EN", "US"));

        String source = "morning";
        String expected = "Good morning, World!";

        String actual = resourceBundle.getString(source);

        assertTrue("Result (" + actual + ") is not Good morning, World!", actual.equals(expected));
    }

    @Test
    public void testGetHelloDayEN() throws MissingResourceException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("", ""));

        String source = "day";
        String expected = "Доброй ночи, Мир!";

        String actual = resourceBundle.getString(source);

        assertFalse("Result (" + actual + ") is Доброй ночи, Мир!", actual.equals(expected));
    }

    @Test(expected = MissingResourceException.class)
    public void testExpectedMessageKey(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("EN", "US"));

        String source = "lunch";

        resourceBundle.getString(source);
    }

    @Test
    public void testNotNullParamOutput(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("EN", "US"));

        String source = "evening";

        String actual = resourceBundle.getString(source);

        assertNotNull("Result (" + actual + ") NULL", actual);
    }
}
