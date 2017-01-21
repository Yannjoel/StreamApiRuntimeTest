package javastreamruntimetest.sampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Yannick
 */
public class SampleData {

    /**
     * @param size
     * @return List with  random numbers
     */
    public static List<Integer> getIntList(int size) {
        ArrayList<Integer> sampleList = new ArrayList<>();
        Random rand = new Random();
        rand.ints(size).forEach(( num)-> sampleList.add(num));
        return sampleList;
    }
    
}
