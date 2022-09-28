import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RgbToHexTest {

    @Test
    public void sampleTests() {
        assertEquals("For input: (0, 0, 0)", "000000", RgbToHex.rgb(0, 0, 0));
        assertEquals("For input: (1, 2, 3)", "010203", RgbToHex.rgb(1, 2, 3));
        assertEquals("For input: (255, 255, 255)", "FFFFFF", RgbToHex.rgb(255, 255, 255));
        assertEquals("For input: (254, 253, 252)", "FEFDFC", RgbToHex.rgb(254, 253, 252));
        assertEquals("For input: (-20, 275, 125)", "00FF7D", RgbToHex.rgb(-20, 275, 125));
    }
}

class RgbToHex {

    public static String rgb(int r, int g, int b) {
        if(r < 0) r = 0;
        if(g < 0) g = 0;
        if(b < 0) b = 0;
        if(r > 255) r = 255;
        if(g > 255) g = 255;
        if(b > 255) b = 255;
        return String.format("%02X%02X%02X", r, g, b);
        //return String.format("%06x", r, g, b);
    }
   //private static int verify(int i) {
   //    return i > 0 ? Math.min(255, i) : 0;  // Интересный вариант решения
   //}
}
