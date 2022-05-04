public class equals {
    public static void main(String[] args) {
       int[] test1 = {2, 1, 2, 2, 2, 4, 5, 2}; // yes
       int[] test2 = {1, 2, 3, 2, 4, 2, 5, 2, 2, 2}; // yes
       int[] test3 = {1, 2, 3, 4, 5, 6}; // no

       boolean r1 = findMajority(test1, 0, test1.length-1);
       boolean r2 = findMajority(test2, 0, test2.length-1);
       boolean r3 = findMajority(test3, 0, test3.length-1);
    }

    public static boolean findMajority(int[] arr, int p, int r) {
        if (p == r) return true;
        int midPoint = (int)((double)(p+r)/2);
        boolean t1 = findMajority(arr, p, midPoint);
        boolean t2 = findMajority(arr, midPoint+1, r);
        return mergeMajority(arr, p, r, t1, t2);
    }

    public static boolean mergeMajority(int[] arr, int p, int r, boolean t1, boolean t2) {
        if (r-p == 1) return equals(arr, arr[r], arr[p]);
        return true;
    }

    public static boolean equals(int[] arr, int i, int j) {
        return arr[i] == arr[j] ? true : false;
    }
}
