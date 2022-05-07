import java.util.Arrays;
import java.util.function.Consumer;

public class main {
    public static void main(String[] args) {
       measureBinarySearchNew(24);
        //measureLinearSearch(-5);
    }
    public static void measureLinearSearch(int Searched) {
        System.out.println(" Linear Search Measurements : ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Arrays.stream(lengths).forEach(x -> {
            int times = 500;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSearchIn = SearchTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                SearchTools.linSearch(toSearchIn,Searched);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching "+Searched+" in " + times + " measurements for length " + x + ": " + duration);
        });
    }

    public static void measureBinarySearch(int Searched) {
        System.out.println(" Binary Search Measurements : ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Arrays.stream(lengths).forEach(x -> {
            int times = 500;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSearchIn = SearchTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                SearchTools.binSearch(toSearchIn,Searched,0,toSearchIn.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching "+Searched+" in " + times + " measurements for length " + x + ": " + duration);
        });
    }

    public static void measureBinarySearchNew(int Searched) {
        System.out.println(" Binary Search Measurements : ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Arrays.stream(lengths).forEach(x -> {
            int times = 500;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSearchIn = SearchTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                SearchTools.binSearchNew(toSearchIn,Searched,0,toSearchIn.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching "+Searched+" in " + times + " measurements for length " + x + ": " + duration);
        });
    }



}
