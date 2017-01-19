package javastreamruntimetest.sampleData;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Yannick
 */
public class SampleData {

    /**
     * @return List with 100000 random numbers
     */
    public static List<Integer> getIntList() {
        LinkedList<Integer> sampleList = new LinkedList<>();
        Random rand = new Random();
        rand.ints(100000).forEach(( num)-> sampleList.add(num));
        return sampleList;
    }
    
}
