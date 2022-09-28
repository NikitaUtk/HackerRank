import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralsTest {

    @Test
    public void testToRoman() throws Exception {
        //assertThat("1 converts to 'I'", RomanNumerals.toRoman(1), is("I"));
        //assertThat("2 converts to 'II'", RomanNumerals.toRoman(1666), is("MDCLXVI"));
        //assertThat("2 converts to 'II'", RomanNumerals.toRoman(1148), is("MCXLVIII"));
        //assertThat("2 converts to 'II'", RomanNumerals.toRoman(1148), is("MCXLVIII"));

    }

    @Test
    public void testFromRoman() throws Exception {
        //assertThat("'I' converts to 1", RomanNumerals.fromRoman("I"), is(1));
        assertThat("'II' converts to 2", RomanNumerals.fromRoman("DCCXLVIII"), is(748)); //768
    }
}

 class RomanNumerals {

    public static String toRoman(int n) { //1666   MDCLXVI
        List<Integer> intList =  new ArrayList<>();
        List<String> strList =  new ArrayList<>();



        intList.add(1000);
        intList.add(900);
        intList.add(500);
        intList.add(400);
        intList.add(100);
        intList.add(90);
        intList.add(50);
        intList.add(40);
        intList.add(10);
        intList.add(9);
        intList.add(5);
        intList.add(4);
        intList.add(1);

        strList.add("M");
        strList.add("CM");
        strList.add("D");
        strList.add("CD");
        strList.add("C");
        strList.add("XC");
        strList.add("L");
        strList.add("XL");
        strList.add("X");
        strList.add("IX");
        strList.add("V");
        strList.add("IV");
        strList.add("I");

         /*if(intList.contains(n)) return strList.get(intList.indexOf(n));
        String result = "";
        int res = n;
        for(int i = intList.size()-1; i >= 0; i--){
            if(intList.get(i) > res) {
                continue;
            }

            if(res == 0 && i == intList.size()-1){
                result+=String.format("%" + n / intList.get(i) + "s", strList.get(i)).replace(" ", strList.get(i));
            }
                result+=String.format("%" + res / intList.get(i) + "s", strList.get(i)).replace(" ", strList.get(i));
                res = res %  intList.get(i);
        }
        */
        StringBuilder result = new StringBuilder();
        for(int i=0;i<intList.size();i++) {
            while (n >= intList.get(i)) {
                n = n - intList.get(i);
                result.append(strList.get(i));
            }


        }
        return result.toString();
    }
    public static int fromRoman(String romanNumeral) {
        Map<String, Integer> newMap =  new HashMap<>();
        newMap.put("I", 1);
        newMap.put("IV", 4);
        newMap.put("V", 5);
        newMap.put("IX", 9);
        newMap.put("X", 10);
        newMap.put("XL", 40);
        newMap.put("L", 50);
        newMap.put("XC", 90);
        newMap.put("C", 100);
        newMap.put("CD", 400);
        newMap.put("D", 500);
        newMap.put("CM", 900);
        newMap.put("M", 1000);
        int result = 0;
        for(int i = 0; i < romanNumeral.length(); i++){
            if(romanNumeral.length() > 1 && i != romanNumeral.length()-1 && newMap.get(romanNumeral.charAt(i)+""+romanNumeral.charAt(i+1)+"") != null){
                result += newMap.get(romanNumeral.charAt(i)+""+romanNumeral.charAt(i+1)+"");
                i++;
            }else {
                result += newMap.get(romanNumeral.charAt(i) + "");
            }

        }
        return result;
    }
}
