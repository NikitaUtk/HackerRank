import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NextBiggerNum {
    @Test
    public void basicTests() {
        //assertEquals(21, NextBigNum.nextBiggerNumber(12));
        //assertEquals(531, NextBigNum.nextBiggerNumber(513));
        //assertEquals(2071, NextBigNum.nextBiggerNumber(2017));
        //assertEquals(441, NextBigNum.nextBiggerNumber(414));
        //assertEquals(414, NextBigNum.nextBiggerNumber(144));
        //assertEquals(19009, NextBigNum.nextBiggerNumber(10990));
        //assertEquals(426440923, NextBigNum.nextBiggerNumber(426440392));
        //assertEquals(1234567908, NextBigNum.nextBiggerNumber(1234567890));
        assertEquals(1888143005, NextBigNum.nextBiggerNumber(1888140530));
    }
}

class NextBigNum
{
    public static long nextBiggerNumber(long n){
        char[] resArr = (""+n).toCharArray();
        if(resArr.length < 2) return -1;

        return findNextBig(resArr, resArr.length);
    }
    public static long findNextBig(char[]arr, int n){
        int i;
        for(i = n-1; i > 0; i--){
            if(arr[i] > arr[i-1]){
                break;
            }
        }
        if(i == 0){
            return -1;
        }
        else{
            int x = arr[i-1], min = i;
            for(int j = i+1;j < n; j++ ){
                if(arr[j] > x && arr[j] < arr[min]){
                    min = j;
                }
            }
            char temp = arr[i-1];
            arr[i-1] = arr[min];
            arr[min] = temp;

            Arrays.sort(arr, i, n);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j <= arr.length-1; j++){
                sb.append(arr[j]);
            }
            return Long.parseLong(sb.toString());
        }

    }
    /*public static long nextBiggerNumber(long n)
    {
        char[] resArr = (""+n).toCharArray();

            for(int i = resArr.length-1; i > 0; i--){
                StringBuilder sb = new StringBuilder();
                char[] arr = (""+n).toCharArray();
                if(arr[i] == arr[i-1]){
                    continue;
                }
                char bf = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = bf;
                for(int j = 0; j <= arr.length-1; j++){
                    sb.append(arr[j]);
                }

                if(Long.parseLong(sb.toString()) > n){
                    //if(arr.length == 2) return Long.parseLong(sb.toString());
                    return nextBig(arr, i-1, Long.parseLong(sb.toString()), n);
                }
            }
        return n;

    }
    public static long nextBig(char[]arr, int i, long n, long l){
        System.out.println(n);
        char[]resArr = arr;
        StringBuilder str = new StringBuilder();
        while(true){
            for(int k = i; k < arr.length-1; k++){
                StringBuilder sb = new StringBuilder();
                if(resArr[k] == resArr[k+1]){
                    continue;
                }
                char bf = resArr[k];
                resArr[k] = resArr[k+1];
                resArr[k+1] = bf;
                for(int j = 0; j <= arr.length-1; j++){
                    sb.append(resArr[j]);
                }
                if((Long.parseLong(sb.toString()) < n && Long.parseLong(sb.toString()) > l) || (Long.parseLong(sb.toString()) > n && Long.parseLong(sb.toString()) > l)) {
                    return nextBig(arr, i, Long.parseLong(sb.toString()), l);
                }
                //if(Long.parseLong(sb.toString()) == l){
                //
                //    return
                //}
            }

            for(int j = 0; j <= arr.length-1; j++){
                str.append(arr[j]);
            }
            return Long.parseLong(str.toString());
        }
*/

}