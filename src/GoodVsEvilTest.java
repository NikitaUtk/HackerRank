import java.util.Arrays;

public class GoodVsEvilTest {
/*    @Test
    public void testEvilWin() {
        assertEquals("Evil should win", "Battle Result: Evil eradicates all trace of Good",
                GoodVsEvil.battle("1 1 1 1 1 1", "1 1 1 1 1 1 1"));
    }

    @Test
    public void testGoodWin() {
        assertEquals("Good should win", "Battle Result: Good triumphs over Evil",
                GoodVsEvil.battle("0 0 0 0 0 10", "0 1 1 1 1 0 0"));
    }

    @Test
    public void testTie() {
        assertEquals("Should be a tie", "Battle Result: No victor on this battle field",
                GoodVsEvil.battle("1 0 0 0 0 0", "1 0 0 0 0 0 0"));
    }*/

    public static void main(String[] args) {
        System.out.println(GoodVsEvil.battle("8949 7039 3143 2454 3992 3292", "9440 8527 3916 6623 4569 3090 841"));
    }

}
 class GoodVsEvil {
    public static String battle(String goodAmounts, String evilAmounts) {
        int [] goodArr = Arrays.stream(goodAmounts.split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] evilArr = Arrays.stream(evilAmounts.split(" ")).mapToInt(Integer::parseInt).toArray();

        int good = 0;
        int evil = 0;

        for(int i : goodArr){
            good+=i;
        }
        for(int j : evilArr){
            evil+=j;
        }

        if(good == evil) {
            return "Battle Result: No victor on this battle field";
        }else if(good>evil){
            return "Battle Result: Good triumphs over Evil";
        }else{
            return "Battle Result: Evil eradicates all trace of Good";
        }

    }
}