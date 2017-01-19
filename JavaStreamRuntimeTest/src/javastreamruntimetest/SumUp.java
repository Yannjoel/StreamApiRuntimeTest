package javastreamruntimetest;

import java.util.List;

/**
 *
 * @author Yannick
 */
public class SumUp {
      public static void withForLoop(List<Integer> data) {
        System.out.println("For-loop:");
        long start = System.currentTimeMillis();
        int listLenght = data.size();
        int total = 0;
        for (int i = 0; i < listLenght; i++) {
            total += data.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Ergebniss: " + total);
        System.out.println("Dauer: " + (end - start) + "ms");
    }

    public static void withItterator(List<Integer> data) {
        System.out.println("Iterator:");
        long start = System.currentTimeMillis();
        int total = 0;
        for (Integer num : data) {
            total += num;
        }
        long end = System.currentTimeMillis();
        System.out.println("Ergebniss: " + total);
        System.out.println("Dauer: " + (end - start) + "ms");
    }

    public static void addAllStream(List<Integer> data) {
        System.out.println("Stream");
        long start = System.currentTimeMillis();
        int total = data.stream().mapToInt(num -> num).sum();
        long end = System.currentTimeMillis();
        System.out.println("Ergebniss: " + total);
        System.out.println("Dauer: " + (end - start) + "ms");
    }
}
