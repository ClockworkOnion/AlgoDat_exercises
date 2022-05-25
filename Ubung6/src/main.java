import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        //measureQuickSort();
        //measureQuickSortRandom();
        //measureQuickSortNewRandom();
        //measureQuickSortTriRandom();
        measureQuickSortNewRandom();
    }



    public static void measureQuickSort() {
        System.out.println(" QuickSort ");
        int[] lengths = { 100,1000,10000,100000,200000};
        System.out.println("Create Sequence Inc : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.QuickSort(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
        System.out.println("Create Sequence Dec : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.QuickSort(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });


        System.out.println("Create Sequence Rand : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.QuickSort(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
    }

    public static void measureQuickSortRandom() {
        System.out.println(" QuickSortRandom :  ");
        int[] lengths = { 100,1000,10000,100000,200000};
        System.out.println("Create Sequence Inc : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
        System.out.println("Create Sequence Dec : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });


        System.out.println("Create Sequence Rand : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
    }


    public static void measureQuickSortNewRandom() {
        System.out.println(" QuickSortNewRandom :  ");
        int[] lengths = { 100,1000,10000,100000,200000};
        System.out.println("Create Sequence Inc : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceInc(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortNewRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
        System.out.println("Create Sequence Dec : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortNewRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });


        System.out.println("Create Sequence Rand : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortNewRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
    }

    public static void measureQuickSortTriRandom() {
        System.out.println(" QuickSortTriRandom :  ");
        int[] lengths = { 100,1000,10000,100000,200000};
        System.out.println("Create Sequence Inc : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceInc(x);
                try {
                    SortTools.PartitionTriRandom(toSort,0,toSort.length-1);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortTriRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
        System.out.println("Create Sequence Dec : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                try {
                    SortTools.PartitionTriRandom(toSort,0,toSort.length-1);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortTriRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });


        System.out.println("Create Sequence Rand : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                try {
                    SortTools.PartitionTriRandom(toSort,0,toSort.length-1);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortTriRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
    }

    public static void measureQuickSortTriNewRandom() {
        System.out.println(" QuickSortTriNewRandom :  ");
        int[] lengths = { 100,1000,10000,100000,200000};
        System.out.println("Create Sequence Inc : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceInc(x);
                try {
                    SortTools.PatritionTriNew(toSort,0,toSort.length-1);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortTriNewRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
        System.out.println("Create Sequence Dec : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                try {
                    SortTools.PatritionTriNew(toSort,0,toSort.length-1);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortTriNewRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });


        System.out.println("Create Sequence Rand : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            for (int i = 0; i < times; i++) {
                int[] toSort = SortTools.createSequenceDec(x);
                try {
                    SortTools.PatritionTriNew(toSort,0,toSort.length-1);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
                System.gc();
                long before = System.nanoTime();
                SortTools.quickSortTriNewRandom(toSort,0,toSort.length-1);
                duration += System.nanoTime() - before;
            }
            duration = duration / times;
            System.out.println("Average time of  measurements for length " + x + ": " + duration);
        });
    }
}
