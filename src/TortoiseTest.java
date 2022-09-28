import org.junit.Test;

import static org.junit.Assert.*;


public class TortoiseTest {
//387,6
    //0.24
    @Test
    public void test1() {
        System.out.println("Basic Tests");
        assertArrayEquals(new int[]{0, 32, 18}, Tortoise.race(720, 850, 70));
        assertArrayEquals(new int[]{3, 21, 49}, Tortoise.race(80, 91, 37));
        assertArrayEquals(new int[]{2, 0, 0}, Tortoise.race(80, 100, 40));
    }
}
class Tortoise {
    public static int[] race(int v1, int v2, int g) {
        /*int [] arr = new int [3];
        double distanceA = 0;
        double distanceB = 0;
        int time = 1;
        while(true){
            distanceA = Math.ceil((v1/3600.0)*time + g);
            distanceB = Math.round((v2/3600.0)*time);
            time++;
            System.out.println(time);
            if(distanceA == distanceB) break;
        }
        System.out.println(time);
        time = time/60;
        System.out.println(distanceA + "-" + distanceB + "-" + time);
        return new int[0];*/
        if (v1 >= v2)
            return null;
        int seconds = (g * 3600) / (v2 - v1);
        return new int[]{seconds / 3600, (seconds % 3600) / 60, seconds % 60};
    }
}