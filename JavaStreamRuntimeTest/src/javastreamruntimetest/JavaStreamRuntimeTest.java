/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreamruntimetest;

import java.util.List;
import javastreamruntimetest.sampleData.SampleData;

/**
 *
 * @author Yannick
 */
public class JavaStreamRuntimeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> sampleIntList = SampleData.getIntArrayList(10000000);
        SumUp.withForLoop(sampleIntList);
        SumUp.withItterator(sampleIntList);
        SumUp.withNormalStream(sampleIntList);
        SumUp.withParallelStream(sampleIntList);
        
        sampleIntList = SampleData.getIntLinkedList(10000000);
        SumUp.withForLoop(sampleIntList);
        SumUp.withItterator(sampleIntList);
        SumUp.withNormalStream(sampleIntList);
        SumUp.withParallelStream(sampleIntList);
        
        int[] sampleArray = SampleData.getIntArray(10000000);
        SumUp.arrayWithForLoop(sampleArray);
    }
}
