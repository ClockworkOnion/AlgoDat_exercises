import java.util.Arrays;
import java.lang.*;
import java.util.function.Consumer;

public class main {
    // Anmerkung: Aufgaben 1 a, b und d sind in der Datei SortTools.java
    public static void main(String[] args) {
        measureTimes(); // Aufgabe 1 c)
        /* Ergebnisse:

        BubbleSort:
        Average time of 10 measurements for length 10: 6199
        Average time of 10 measurements for length 100: 269125
        Average time of 10 measurements for length 1000: 1517391
        Average time of 10 measurements for length 10000: 58742045
        Average time of 10 measurements for length 100000: 10906088929

        InsertionSort:
        Average time of 10 measurements for length 10: 3529
        Average time of 10 measurements for length 100: 92895
        Average time of 10 measurements for length 1000: 862471
        Average time of 10 measurements for length 10000: 6790033
        Average time of 10 measurements for length 100000: 675099191

        BubbleSortNew:
        Average time of 10 measurements for length 10: 138220
        Average time of 10 measurements for length 100: 1415324
        Average time of 10 measurements for length 1000: 6660400
        Average time of 10 measurements for length 10000: 587482820
        Average time of 10 measurements for length 100000: 58578083416

         */
    }

    public static void measureTimes() {
        SortTools sort = new SortTools();
        System.out.println("BubbleSort:");
        measureGenericSort(sort::bubbleSort);
        System.out.println("InsertionSort:");
        measureGenericSort(sort::insertionSort);
        System.out.println("BubbleSortNew:");
        measureGenericSort(sort::bubbleSortNew);
    }

    public static void measureGenericSort(Consumer<int[]> sorter) {
        int[] lengths = {10, 100, 1000, 10000, 100000};
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceRand(x);
                System.gc();
                long before = System.nanoTime();
                sorter.accept(toSort);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of " + times + " measurements for length " + x + ": " + duration);
        });
    }
}
