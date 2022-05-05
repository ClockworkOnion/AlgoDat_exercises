mport java.util.Arrays;
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