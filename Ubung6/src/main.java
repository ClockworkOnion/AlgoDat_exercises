import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        // measureQuickSort();
        measureQuickSortRandom();
        measureQuickSortNewRandom();
        measureQuickSortTriRandom();
        measureQuickSortNewRandom();
    }
    /*
    QuickSortRandom :
    Create Sequence Inc :
    Average time of  measurements for length 100: 150141
    Average time of  measurements for length 1000: 70550
    Average time of  measurements for length 10000: 449812
    Average time of  measurements for length 100000: 4122408
    Average time of  measurements for length 200000: 8353708
    Create Sequence Dec :
    Average time of  measurements for length 100: 11712
    Average time of  measurements for length 1000: 52400
    Average time of  measurements for length 10000: 415975
    Average time of  measurements for length 100000: 5476887
    Average time of  measurements for length 200000: 10596641
    Create Sequence Rand :
    Average time of  measurements for length 100: 21350
    Average time of  measurements for length 1000: 59242
    Average time of  measurements for length 10000: 527383
    Average time of  measurements for length 100000: 5159225
    Average time of  measurements for length 200000: 10000975
    QuickSortNewRandom :
    Create Sequence Inc :
    Average time of  measurements for length 100: 25129
    Average time of  measurements for length 1000: 53229
    Average time of  measurements for length 10000: 495654
    Average time of  measurements for length 100000: 4724979
    Average time of  measurements for length 200000: 9483029
    Create Sequence Dec :
    Average time of  measurements for length 100: 6699
    Average time of  measurements for length 1000: 50112
    Average time of  measurements for length 10000: 474358
    Average time of  measurements for length 100000: 4684729
    Average time of  measurements for length 200000: 9560800
    Create Sequence Rand :
    Average time of  measurements for length 100: 8029
    Average time of  measurements for length 1000: 49012
    Average time of  measurements for length 10000: 458208
    Average time of  measurements for length 100000: 4774258
    Average time of  measurements for length 200000: 9611704
    QuickSortTriRandom :
    Create Sequence Inc :
    Average time of  measurements for length 100: 44800
    Average time of  measurements for length 1000: 490945
    Average time of  measurements for length 10000: 13165141
    Average time of  measurements for length 100000: 12722383
    Average time of  measurements for length 200000: 19145920
    Create Sequence Dec :
    Average time of  measurements for length 100: 3712
    Average time of  measurements for length 1000: 104754
    Average time of  measurements for length 10000: 13112770
    Average time of  measurements for length 100000: 13722383
    Average time of  measurements for length 200000: 22145920
    Create Sequence Rand :
    Average time of  measurements for length 100: 5099
    Average time of  measurements for length 1000: 102766
    Average time of  measurements for length 10000: 7881966
    Average time of  measurements for length 100000: 18722383
    Average time of  measurements for length 200000: 27145920
    QuickSortNewRandom :
    Create Sequence Inc :
    Average time of  measurements for length 100: 10074
    Average time of  measurements for length 1000: 51908
    Average time of  measurements for length 10000: 475545
    Average time of  measurements for length 100000: 4722383
    Average time of  measurements for length 200000: 9614520
    Create Sequence Dec :
    Average time of  measurements for length 100: 6920
    Average time of  measurements for length 1000: 51866
    Average time of  measurements for length 10000: 474579
    Average time of  measurements for length 100000: 4975312
    Average time of  measurements for length 200000: 9468058
    Create Sequence Rand :
    Average time of  measurements for length 100: 5720
    Average time of  measurements for length 1000: 47162
    Average time of  measurements for length 10000: 468241
    Average time of  measurements for length 100000: 4813508
    Average time of  measurements for length 200000: 9685941

     */

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
        int[] lengths = { 100,1000,10000};
        System.out.println("Create Sequence Inc : ");
        Arrays.stream(lengths).forEach(x -> {
            int times = 10;
            long duration = 0;
            int[] toSort = SortTools.createSequenceInc(x);
            for (int i = 0; i < times; i++) {
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
            int[] toSort = SortTools.createSequenceDec(x);
            for (int i = 0; i < times; i++) {
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
            int[] toSort = SortTools.createSequenceInc(x);
            for (int i = 0; i < times; i++) {
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
            int[] toSort = SortTools.createSequenceDec(x);
            for (int i = 0; i < times; i++) {
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
