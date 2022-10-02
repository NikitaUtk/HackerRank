import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TimeFormatterTest {
    @Test
    public void exampleTests() {
        //assertEquals("1 second", TimeFormatter.formatDuration(1));
        //assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        //assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        //assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }
}

class TimeFormatter {

    public static String formatDuration(int seconds) {
        StringBuilder result = new StringBuilder();
        int day = (int) TimeUnit.SECONDS.toDays(seconds);
        long hours = TimeUnit.SECONDS.toHours(seconds) - (day *24);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) *60);
        System.out.println(hours +" "+ minute + "" + second);
        return "";
    }
}