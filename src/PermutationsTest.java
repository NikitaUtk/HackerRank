import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PermutationsTest {

    @Test public void example1() {
        assertEquals( new ArrayList<String>(Arrays.asList("a")),
                Permutations.singlePermutations("a").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example2() {
        assertEquals( new ArrayList<String>(Arrays.asList("ab","ba")),
                Permutations.singlePermutations("ab").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example3() {
        assertEquals( new ArrayList<String>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                Permutations.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()) );
    }
}

class Permutations {

    public static List<String> singlePermutations(String s) {
        List<String> resList = new ArrayList<>();
        List<String> lst = new ArrayList<>(Arrays.asList(s.split("")));



        return null;
    }
}
