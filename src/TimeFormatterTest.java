import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TimeFormatterTest {
    @Test
    public void exampleTests() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(36625354));
    }
}

class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";
        StringBuilder result = new StringBuilder();
        long year = (int) TimeUnit.SECONDS.toDays(seconds)/365;
        long day = (int) TimeUnit.SECONDS.toDays(seconds) - (year * 365);
        long hour = TimeUnit.SECONDS.toHours(seconds) - (day * 24) - (year * 365 * 24);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) *60);
        if(year==1){
            result.append(year + " year");
        }else if(year>1){
            result.append(year + " years");
        }
        if(year != 0){
            if(hour == 0 && minute == 0 && second == 0) result.append(" and ");
            else result.append(", ");
        }
        if(day==1){
            result.append(day + " day");
        }else if(day>1){
            result.append(day + " days");
        }
        if(day != 0){
            if(minute == 0 && second == 0) result.append(" and ");
            else result.append(", ");
        }
        if(hour==1){
            result.append(hour + " hour");
        }else if(hour>1) {
            result.append(hour + " hours");
        }
        if(hour != 0 && (minute != 0 || second != 0)){
            if(minute == 0 || second == 0) result.append(" and ");
            else result.append(", ");
        }
        if(minute==1){
            result.append(minute + " minute");
        }else if(minute>1){
            result.append(minute + " minutes");
        }
        if(minute != 0 && second != 0){
            result.append(" and ");
        }
        if(second==1){
            result.append(second + " second");
        }else if(second>1){
            result.append(second + " seconds");
        }
        return result.toString();
    }

    /*public static String formatDuration(int seconds) {
        return seconds == 0 ? "now" :
                Arrays.stream(
                  new String[]{
                       formatTime("year",  (seconds / 31536000)),
                       formatTime("day",   (seconds / 86400)%365),
                       formatTime("hour",  (seconds / 3600)%24),
                       formatTime("minute",(seconds / 60)%60),
                       formatTime("second",(seconds%60)})
                      .filter(e->e!="")
                      .collect(Collectors.joining(", "))
                      .replaceAll(", (?!.+,)", " and ");
    }
    public static String formatTime(String s, int time){
      return time==0 ? "" : Integer.toString(time)+ " " + s + (time==1?"" : "s");
    }*/
}