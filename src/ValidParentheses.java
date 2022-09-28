import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD by writing your own tests

public class ValidParentheses {
    @Test
    public void sampleTest() {
        //assertEquals("expected", "actual");
        //assertEquals(true,Solution.validParentheses( "()" ));
        //assertEquals(false,Solution.validParentheses( "())" ));
        //assertEquals(true,Solution.validParentheses( "32423(sgsdg)" ));
        //assertEquals(false,Solution.validParentheses( "(dsgdsg))2432" ));
        //assertEquals(true,Solution.validParentheses( "adasdasfa" ));
        //assertEquals(false,Solution.validParentheses( "())(" ));
        //assertEquals(false,Solution.validParentheses( "())(()" ));
        //assertEquals(false,Solution.validParentheses( "(()()()())(())" ));//()()()(())((((()))))(()()()())(())(())((()((()))))())(()
        assertEquals(true,Solution.validParentheses( "(()((((())))))((()()))(()())((()))()(()())(()((())))((()))()((())(()))(())()()()()(())()((()))()()()(())(()())()(()(()))()()()(())(())()()()((()()()(())))())(((()))" ));

    }
}

class Solution{

    public static boolean validParentheses(String parens)
    {

        /**Самое умное решение данной задачи
         * try {
         *       Pattern.compile(parens.replaceAll("[^()]", ""));
         *       return true;
         *     } catch (PatternSyntaxException e) {
         *       return false;
         *     }
         * */
        ArrayList<Character> list = new ArrayList<>(parens.chars().filter(e -> e == '(' || e == ')').mapToObj(e ->(char) e).collect(Collectors.toList()));
        if(list.isEmpty()) return true;
        //if(list.size() == 1 || (list.get(0) == ')' || list.size()%2 != 0 || list.get(list.size()-1) == '(' ) || (Collections.frequency(list, '(') != Collections.frequency(list, ')'))) return false;
        while(true){
            int len = list.size();
                for(int j = 0; j < list.size()-1; j++){
                    if(list.get(j).equals('(') && list.get(j+1) == ')') {
                        list.remove(j);
                        list.remove(j);
                        break;
                    }
                }
            if(len == list.size()) break;

        }

        if(list.isEmpty()) return true;
        return true;
    }
}