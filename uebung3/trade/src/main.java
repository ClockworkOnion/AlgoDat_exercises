import java.util.Arrays;
import java.lang.*;
import java.util.Arrays;
import java.util.function.Consumer;

public class main {
    public static void main(String[] args) {

        measureTimesInsertion();
        System.out.println("Merge Sort : ");
        mesureMergeSort();
        System.out.println("Merge Sort New : ");
        mesureMergeSortNew();

        /* Aufgabe 1 c)
        InsertionSort :
        Aufsteigend :
        Average time of 10 measurements for length 10: 12383
        Average time of 10 measurements for length 100: 15733
        Average time of 10 measurements for length 1000: 97925
        Average time of 10 measurements for length 10000: 498337
        Average time of 10 measurements for length 100000: 620229
        Average time of 10 measurements for length 200000: 51341

        Absteigend :
        Average time of 10 measurements for length 10: 17466
        Average time of 10 measurements for length 100: 138379
        Average time of 10 measurements for length 1000: 619908
        Average time of 10 measurements for length 10000: 41396229
        Average time of 10 measurements for length 100000: 3728808083
        Average time of 10 measurements for length 200000: 15297032729

        Merge Sort :
        Aufsteigend :
        Average time of 10 measurements for length 10: 13916
        Average time of 10 measurements for length 100: 165862
        Average time of 10 measurements for length 1000: 386795
        Average time of 10 measurements for length 10000: 490937
        Average time of 10 measurements for length 100000: 5160616
        Average time of 10 measurements for length 200000: 12793166

        Absteigend :
        Average time of 10 measurements for length 10: 152616
        Average time of 10 measurements for length 100: 154725
        Average time of 10 measurements for length 1000: 180358
        Average time of 10 measurements for length 10000: 461770
        Average time of 10 measurements for length 100000: 4749283
        Average time of 10 measurements for length 200000: 11292866

        Merge Sort New :
        Aufsteigend :
        Average time of 10 measurements for length 10: 10875
        Average time of 10 measurements for length 100: 156795
        Average time of 10 measurements for length 1000: 304054
        Average time of 10 measurements for length 10000: 419628
        Average time of 10 measurements for length 100000: 5220175
        Average time of 10 measurements for length 200000: 11683516
        Abstaeigend :
        Average time of 10 measurements for length 10: 47954
        Average time of 10 measurements for length 100: 54287
        Average time of 10 measurements for length 1000: 78783
        Average time of 10 measurements for length 10000: 452395
        Average time of 10 measurements for length 100000: 5486175
        Average time of 10 measurements for length 200000: 11049429
         */
        }

        public static void measureTimesInsertion() {
            SortTools sort = new SortTools();
        System.out.println("InsertionSort : ");
        measureGenericSortInsertion(sort::insertionSort);
    }


    public static void measureGenericSortInsertion(Consumer<int[]> sorter) {
        System.out.println();
        System.out.println("Aufsteigend : ");
        int[] lengths = {10, 100, 1000, 10000, 100000,200000};
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                sorter.accept(toSort);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of " + times + " measurements for length " + x + ": " + duration);
        });
        System.out.println();
        System.out.println("Absteigend : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                sorter.accept(toSort);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of " + times + " measurements for length " + x + ": " + duration);
        });
    }

    public static void mesureMergeSort(){
        System.out.println();
        System.out.println("Aufsteigend : ");
        int[] lengths = {10, 100, 1000, 10000, 100000,200000};
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.mergeSort(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of " + times + " measurements for length " + x + ": " + duration);
        });
        System.out.println();
        System.out.println("Absteigend : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.mergeSort(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of " + times + " measurements for length " + x + ": " + duration);
        });
    }


    public static void mesureMergeSortNew(){
        System.out.println("Aufsteigend : ");
        int[] lengths = {10, 100, 1000, 10000, 100000,200000};
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.mergeSortNew(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of " + times + " measurements for length " + x + ": " + duration);
        });
        System.out.println("Abstaeigend : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.mergeSortNew(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of " + times + " measurements for length " + x + ": " + duration);
        });
    }
}