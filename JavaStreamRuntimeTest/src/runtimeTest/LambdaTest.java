
package runtimeTest;

import runtimeTest.sampleData.SampleData;
import java.util.List;

/**
 *
 * @author Yannick
 */
public class LambdaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> sampleIntList = SampleData.getIntList();
        SumUp.withForLoop(sampleIntList);
        SumUp.withItterator(sampleIntList);
        SumUp.addAllStream(sampleIntList);
    }
}
