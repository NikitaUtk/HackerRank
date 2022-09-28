import org.junit.Test;


public class DecomposeTest {

    @Test
    public void test1() {
        Decompose d = new Decompose();
        long n = 11;
        //assertEquals("1 2 4 10",  d.decompose(n));
        System.out.println(d.decompose(12));
    }
}

 class Decompose {

    public String decompose(long n) {
        String result = null;

        for (long i = n - 1; i > 1; i--) {
            long square = n * n;
            result = recurseDecompose(i, square);
            if (result != null) break;
        }

        return result;
    }

     public static String recurseDecompose(long i, long rem) {
         if (i * i == rem) {
             return i + "";
         } else if (i * i < rem) {
             rem = rem - i * i;

             for (long j = i - 1; j > 0; j--) {
                 String tmp = recurseDecompose(j, rem);

                 if (tmp != null) {
                     System.out.println(tmp + " " + i);
                     return tmp + " " + i;
                 } else {
                     continue;
                 }
             }
         } else {
             return null;
         }

         return null;
        /*int endPoint = (int) Math.pow(n, 2);
        int lastValue = (int) Math.pow(n-1, 2);
        double t = endPoint - lastValue;
        int result = 0;
        List<Integer> resultList = new ArrayList<>();

        for(int i = 1; i < n-1; i++){
            if(Math.pow(i, 2) + result < t){
                result+=Math.pow(i, 2);
                resultList.add(i);
                if(t - result < Math.pow(i+1,2)){
                    result-=Math.pow(i, 2);
                    resultList.remove(i-1);
                }
            }
            if(Math.pow(i, 2) + result == t){
                result+=Math.pow(i, 2);
                resultList.add(i);
                resultList.add((int) (n-1));
                List<String> newList = resultList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList());
                return String.join(" ", newList);
            }
        }
        return"";*/
    }
}
