import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class maxWin {
    public static void main(String[] args) {
        int[] test1 = {8, 2, 8, 7}; // maxWin 6
        int[] test2 = {4,3,5,6,8,7}; // maxWin 5
        int[] test3 = {3, 1, 7, 3, 9, 8}; // maxWin 8
        int[] test4 = {2, 8, 3, 5}; // maxWin 6

        int testing1 = trade(test1, 0, 3);
        int testing2 = trade(test2, 0, 5);
        int testing3 = trade(test3, 0, 5);
        int testing4 = trade(test4, 0, 3);
        System.out.println(testing1);
        System.out.println(testing2);
        System.out.println(testing3);
        System.out.println(testing4);
    }
    public static int trade(int[] arr, int p, int r) {
        if (p == r) { return 0; }
        else {
            int q = (int)Math.floor((float)(p+r)/2);
            int t1 = trade(arr, p, q);
            int t2 = trade(arr, q+1, r);
            return maxWin(arr, p, r, t1, t2);
        }
    }

    public static int maxWin(int[] arr, int p, int r, int t1, int t2) {
        int q = (int)Math.floor((float)(p+r)/2);
        int betweenWin1 = arr[q+1] - arr[q]; //  unnecessary?
        int[] part1 = Arrays.copyOfRange(arr, 0, q);
        int[] part2 = Arrays.copyOfRange(arr, q+1, r);
        int min = part1.length > 0 ? Arrays.stream(part1).min().getAsInt() : Integer.MAX_VALUE;
        int max = part2.length > 0 ? Arrays.stream(part2).max().getAsInt() : 0;
        int betweenWin = max-min;
        System.out.println("Array part1: " + Arrays.toString(part1) + " part2: " + Arrays.toString(part2));
        return maxOfThree(t1, t2, betweenWin, betweenWin1);
    }

    public static int maxOfThree(int a, int b, int c, int d) {
        return Math.max(Math.max(Math.max(a, b), c), d);
    }
}
