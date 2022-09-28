import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DirReductionTest {
    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    }
}

class DirReduction {
    public static String[] dirReduc(String[] arr) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, arr);
        while(true){
            int len = list.size();
            for(int i = 0; i < list.size() - 1; i++){
                if("NORTH".equals(list.get(i)) && "SOUTH".equals(list.get(i+1)) || "SOUTH".equals(list.get(i)) && "NORTH".equals(list.get(i+1)) || "EAST".equals(list.get(i)) && "WEST".equals(list.get(i+1)) || "WEST".equals(list.get(i)) && "EAST".equals(list.get(i+1))){
                    list.remove(i);
                    list.remove(i);
                    break;
                }
            }
            if( len == list.size()){
                break;
            }
        }
        return list.toArray(new String[0]);
    }
}