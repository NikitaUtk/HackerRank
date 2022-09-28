import org.junit.Test;

import static org.junit.Assert.*;

public class KataTest {
    @Test
    public void test1() {
        assertEquals("42 -9", Kata.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
    @Test
    public void test2() {
        assertEquals("3 1", Kata.highAndLow("1 2 3"));
    }

}

 class Kata {
    public static String highAndLow(String numbers) {
        // Code here or
        String[] arr = numbers.split(" ");
        int high = Integer.parseInt(arr[0]);
        int low = Integer.parseInt(arr[0]);
        for(int i = 0; i < arr.length; i++){
            Integer s = Integer.parseInt(arr[i]);
           if(s>= high) high = s;
           if(s<= low) low = s;
        }
        return high + " " + low;
    }
     /*public static int[] minMax(int[] arr) {
         List<Integer> result = new ArrayList();
         int high = arr[0];
         int low = arr[0];
         for(int i = 0; i < arr.length; i++){
             int s = arr[i];
             if(s>= high) high = s;
             if(s<= low) low = s;
         }
         result.add(high);
         result.add(low);

         return arr
     }*/


}
