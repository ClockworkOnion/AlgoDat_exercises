import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class main {
    public static void main(String[] args) {
       measureBinarySearchForConstant(-2);
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

    public static void measureLinearSearchRandomValues() {
        System.out.println(" Linear Search Measurements With Random Values : ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Random random=new Random();
        Arrays.stream(lengths).forEach(x -> {
            int Searched;
            int times = 500;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSearchIn = SearchTools.createSequenceInc(x);
                Searched=toSearchIn[random.nextInt(0,toSearchIn.length-1)];
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
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Random random=new Random();
        Arrays.stream(lengths).forEach(x -> {
            int Searched;
            int times = 500;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSearchIn = SearchTools.createSequenceInc(x);
                Searched=toSearchIn[random.nextInt(0,toSearchIn.length-1)];
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
            for (int i = 0; i < times; i++) {
                int[] toSearchIn = SearchTools.createSequenceInc(x);
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

    public static void measureBinarySearchNewRandomValues() {
        System.out.println(" Binary Search Measurements With Random Values: ");
        int[] lengths = { 100000, 200000,1000000,100000000,685154321};
        Random random=new Random();
        Arrays.stream(lengths).forEach(x -> {
            int Searched;
            int times = 500;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSearchIn = SearchTools.createSequenceInc(x);
                Searched=toSearchIn[random.nextInt(0,toSearchIn.length-1)];
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
