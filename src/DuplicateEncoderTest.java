import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DuplicateEncoderTest {
    @Test
    public void test() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encode("   ()(   "));
    }
}



 class DuplicateEncoder {
    static String encode(String word){
        /*String s = word.toLowerCase();
        char [] res = s.toCharArray();
        List<Character> ret = new ArrayList<>();
        Map<Character, Integer> count = new HashMap<>();
        for(char i : res) {
            count.compute(i, (k,v)->v == null ? 1 : v + 1);
            if(count.get(i) > 1){
                ret.add(')');
            }else{
                ret.add('(');
            }
        }
        System.out.println(ret.toString());*/
        char[] arr = word.toLowerCase().toCharArray();
        List<String> res = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                }

            }
            if(count > 1){
                res.add(")");
            }else{
                res.add("(");
            }
        }
        return String.join("", res);
    }
}