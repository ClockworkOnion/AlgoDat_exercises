import java.util.Arrays;
import java.util.Random;
public class SortTools {
    // Aufgabe 1 a)
    public void bubbleSort(int[] a) {
        for (int i = a.length; i > 1; i--) {
            for (int j = 0; j < i-1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    // Aufgabe 1 b)
    public void bubbleSortNew(int[] a) {
        for (int i = a.length; i > 1; i--) {
            for (int j = 0; j < i-1; j++) {
                    insertionSortPart(a, j, j+10);
                }
            }
        }

    public void insertionSortPart(int[] a, int startIndex, int endIndex){
        int s,j;
        for (int i = startIndex; i <Math.min(a.length, endIndex-1) ; i++) {
            s=a[i];
            j=i-1;
            while (j > startIndex-1 && a[j] > s){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=s;
        }
    }

    // Aufgabe 1 d)
    public static<T extends Comparable<T>> void bubbleSortGen(T[] a) {
        for (int i = a.length; i >1 ; i--) {
            for (int j = 0; j < i ; j++) {
               if (a[j].compareTo(a[j+1])>0) swapGen(a,j,j+1);
            }
        }
    }

    public static <T>void swapGen(T[] a, int j, int i) {
        T tmp;
        tmp=a[j];
        a[j]=a[j+1];
        a[j+1]=tmp;
    }

//        *********************************************
//        Hilfsmethoden, Überbleibsel von Blatt 1 etc.
//        *********************************************

    // Aufgabe 1 b) Alternativlösung mit Arrays kopieren
    public void bubbleSortNew2(int[] a) {
        for (int i = a.length; i > 0; i--) {
            for (int j = 0; j <= i-10; j++) {
                int endIndex = Math.min(a.length, j+10);
                int[] part = Arrays.copyOfRange(a, j, endIndex);
                insertionSort(part);
                for (int k = 0; k < part.length; k++) {
                    a[j+k] = part[k];
                }
            }
        }
    }

    public <T extends Comparable<T>> void insertionSortGen(T[] a) {
        T s;
        int j;
        for (int i = 1; i <a.length ; i++) {
            s=a[i];
            j=i-1;
            while (j>-1 && a[j].compareTo(s)>0){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=s;
        }
    }

    public static int[] createSequenceInc(int n){
        int[] arr=new int[n];
        for (int i=1;i<n;i++) arr[i]=i;
        return arr;
    }

    public static int[] createSequenceDec(int n){
        int[] arr=new int[n];
        for (int i=n;i>=1;i--) arr[i-1]=n-i+1;
        return arr;
    }

    public static int[] createSequenceRand(int n){
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=1+new Random().nextInt(n);
        }
        return arr;
    }

    public static int[] createSequenceAlt(int n){
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            if (i%2==0) arr[i]=1;
            else arr[i]=2;
        }
        return arr;
    }

    public void insertionSort(int[] a){
        int s,j;
        for (int i = 1; i <a.length ; i++) {
            s=a[i];
            j=i-1;
            while (j>-1 && a[j]>s){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=s;
        }
    }
}
