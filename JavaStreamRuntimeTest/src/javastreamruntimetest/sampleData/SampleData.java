package javastreamruntimetest.sampleData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Yannick
 */
public class SampleData {

    private final static Random RAND = new Random();
    private static int itr;
    
    /**
     * @param size
     * @return List with  random numbers
     */
    public static List<Integer> getIntArrayList(int size) {
        ArrayList<Integer> sampleList = new ArrayList<>();
        RAND.ints(size).forEach(( num)-> sampleList.add(num));
        return sampleList;
    }
    
        
    /**
     * @param size
     * @return List with  random numbers
     */
    public static List<Integer> getIntLinkedList(int size) {
        ArrayList<Integer> sampleList = new ArrayList<>();
        RAND.ints(size).forEach(( num)-> sampleList.add(num));
        return sampleList;
    }
    
    public static int[] getIntArray(int size) {
        int[] sampleArray = new int[size];
        itr = 0;
        RAND.ints(size).forEach((num)-> {
            sampleArray[itr]=num;
            itr++;
        });
        return sampleArray;
    }
}
