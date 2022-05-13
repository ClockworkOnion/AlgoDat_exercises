import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
 /*
         Binary Search Measurements :
         Average time of searching in 500 measurements for length 100000: 2800
         Average time of searching in 500 measurements for length 200000: 1231
         Average time of searching in 500 measurements for length 1000000: 1189
         Average time of searching in 500 measurements for length 100000000: 1607
         Average time of searching in 500 measurements for length 685154321: 3721
         Binary Search Measurements for Random values :
         Average time of searching in 500 measurements for length 100000: 3588
         Average time of searching in 500 measurements for length 200000: 1885
         Average time of searching in 500 measurements for length 1000000: 3018
         Average time of searching in 500 measurements for length 100000000: 5458
         Average time of searching in 500 measurements for length 685154320: 6992
         Binary Search New Measurements With Constant Value :
         Average time of searching -4 in 500 measurements for length 100000: 2122
         Average time of searching -4 in 500 measurements for length 200000: 1545
         Average time of searching -4 in 500 measurements for length 1000000: 1512
         Average time of searching -4 in 500 measurements for length 100000000: 2087
         Average time of searching -4 in 500 measurements for length 685154321: 4944
         Binary Search Measurements With Random Values:
         Average time of searching  in 500 measurements for length 100000: 1907
         Average time of searching  in 500 measurements for length 200000: 2116
         Average time of searching  in 500 measurements for length 1000000: 2014
         Average time of searching  in 500 measurements for length 100000000: 3978
         Average time of searching  in 500 measurements for length 685154321: 7031
         Linear Search Measurements With Constant Value:
         Average time of searching -5 in 500 measurements for length 100000: 30615
         Average time of searching -5 in 500 measurements for length 200000: 50843
         Average time of searching -5 in 500 measurements for length 1000000: 286819
         Average time of searching -5 in 500 measurements for length 100000000: 27886644
         Average time of searching -5 in 500 measurements for length 685154321: 190361036
         Linear Search Measurements With Random Values :
         Average time of searching  in 500 measurements for length 100000: 16761
         Average time of searching  in 500 measurements for length 200000: 28164
         Average time of searching  in 500 measurements for length 1000000: 140109
         Average time of searching  in 500 measurements for length 100000000: 13747576

  */

public class main {
    public static void main(String[] args) {
    //   measureBinarySearchForConstant(-2);
       measureBinarySearchRandomValue();

       measureBinarySearchNewConstantValue(-4);
       measureBinarySearchNewRandomValues();

       measureLinearSearchConstantValue(-5);
       measureLinearSearchRandomValues();
    }
    public static void measureLinearSearchConstantValue(int Searched) {
        System.out.println(" Linear Search Measurements With Constant Value: ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Arrays.stream(lengths).forEach(x -> {
            int times = 500;
            long duration = 0;
                int[] toSearchIn = SearchTools.createSequenceInc(x);
            for (int i = 0; i < times; i++) {
                System.gc();
                long before = System.nanoTime();
                SearchTools.linSearch(toSearchIn,Searched);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching "+Searched+" in " + times + " measurements for length " + x + ": " + duration);
        });
    }

    public static void measureLinearSearchRandomValues() {
        System.out.println(" Linear Search Measurements With Random Values : ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Random random=new Random();
        Arrays.stream(lengths).forEach(x -> {
            int Searched;
            int times = 500;
            long duration = 0;
                int[] toSearchIn = SearchTools.createSequenceInc(x);
            for (int i = 0; i < times; i++) {
                Searched=toSearchIn[ThreadLocalRandom.current().nextInt(0, toSearchIn.length-1)];
                System.gc();
                long before = System.nanoTime();
                SearchTools.linSearch(toSearchIn,Searched);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching  in " + times + " measurements for length " + x + ": " + duration);
        });
    }

    public static void measureBinarySearchRandomValue() {
        System.out.println(" Binary Search Measurements for Random values : ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154320};
      //  int[] lengths = { 100000000,685154320};
        Random random=new Random();
        Arrays.stream(lengths).forEach(x -> {
            int Searched;
            int times = 500;
            long duration = 0;
                int[] toSearchIn = SearchTools.createSequenceInc(x);
            for (int i = 0; i < times; i++) {
                Searched=toSearchIn[ThreadLocalRandom.current().nextInt(0, toSearchIn.length-1)];
                System.gc();
                long before = System.nanoTime();
                SearchTools.binSearch(toSearchIn,Searched,0,toSearchIn.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching in " + times + " measurements for length " + x + ": " + duration);
        });
    }

    public static void measureBinarySearchForConstant(int Searched) {
        System.out.println(" Binary Search Measurements : ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Random random=new Random();
        Arrays.stream(lengths).forEach(x -> {
            int times = 500;
            long duration = 0;
                int[] toSearchIn = SearchTools.createSequenceInc(x);
            for (int i = 0; i < times; i++) {
                System.gc();
                long before = System.nanoTime();
                SearchTools.binSearch(toSearchIn,Searched,0,toSearchIn.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching in " + times + " measurements for length " + x + ": " + duration);
        });
    }

    public static void measureBinarySearchNewConstantValue(int Searched) {
        System.out.println(" Binary Search Measurements With Constant Value : ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Arrays.stream(lengths).forEach(x -> {
            int times = 500;
            long duration = 0;
                int[] toSearchIn = SearchTools.createSequenceInc(x);
            for (int i = 0; i < times; i++) {
                System.gc();
                long before = System.nanoTime();
                SearchTools.binSearchNew(toSearchIn,Searched,0,toSearchIn.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching "+Searched+" in " + times + " measurements for length " + x + ": " + duration);
        });
    }

    public static void measureBinarySearchNewRandomValues() {
        System.out.println(" Binary Search Measurements With Random Values: ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Random random=new Random();
        Arrays.stream(lengths).forEach(x -> {
            int Searched;
            int times = 500;
            long duration = 0;
                int[] toSearchIn = SearchTools.createSequenceInc(x);
            for (int i = 0; i < times; i++) {
                Searched=toSearchIn[ThreadLocalRandom.current().nextInt(0, toSearchIn.length-1)];
                System.gc();
                long before = System.nanoTime();
                SearchTools.binSearchNew(toSearchIn,Searched,0,toSearchIn.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of searching  in " + times + " measurements for length " + x + ": " + duration);
        });
    }



}
