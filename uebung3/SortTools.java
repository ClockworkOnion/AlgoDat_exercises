import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SortTools {


    //Blatt 03

    // Aufgabe 1 a)
    public static void mergeSort(int[] a, int p, int r){
        int q;
        if (p<r){
            q=(p+r)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge(a,p,q,r);
        }

    }

    // Aufgabe 1 b)
    public static void mergeSortNew(int[] a,int p,int r){
        int q,w;

        if (p<r){
            q=p+(r-p)/3;
            w=p+2*((r-p)/3)+1;
            mergeSortNew(a,p,q);
            mergeSortNew(a,q+1,w);
            mergeSortNew(a,w+1,r);
            merge3Arrays(a,p,q,w,r);

        }
    }

    public static void merge3Arrays(int[] a, int p, int q, int w, int r) {
        int n1,n2,n3;

        n1=q-p+1; n2=w-q; n3=r-w;

        int[] L=new int[n1+1]; int R[]=new int[n2+1]; int E[]=new  int[n3+1];
        for (int i=0;i<n1;i++) L[i]=a[p+i];
        for (int j = 0; j <n2 ; j++) R[j]=a[q+j+1];
        for (int m = 0; m <n3 ; m++) E[m]=a[w+m+1];

        L[n1]= Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;
        E[n3]=Integer.MAX_VALUE;
        int i=0,j=0,k=0;

        for (int m = p; m <=r ; m++) {
            if (L[i]<=R[j] && L[i]<=E[k]){
                a[m]=L[i];
                i++;
            }
            else if (R[j]<=L[i] && R[j]<=E[k]){
                a[m]=R[j];
                j++;
            }else if (E[k]<=L[i] && E[k]<=R[j]){
                a[m]=E[k];
                k++;
            }
        }

    }

    // Aufgabe 1 d)
    public  static <T extends Comparable<T>> void mergeGeneric(T[] a,int p,int r,T sentinel){ //für Strings könnte man als Sentinel : ein Array der 214748364 length hat, und gefÜllt mit "z".Für Andere Typen ist
        int q;                                                                                //die Max Valur davon
        if (p<r){
            q=(p+r)/2;
            mergeGeneric(a,p,q,sentinel);
            mergeGeneric(a,q+1,r,sentinel);
            mergeGenericArrays(a,p,q,r,sentinel);
        }
    }

    public static  <T extends Comparable<T>> void mergeGenericArrays(T[] a, int p, int q, int r, T sentinel) {
        int n1,n2;
        n1=q-p+1; n2=r-q;
        T[] L=(T[]) new Comparable[n1+1]; T R[]=(T[]) new Comparable[n2+1];
        for (int i=0;i<n1;i++) L[i]=a[p+i];
        for (int j = 0; j <n2 ; j++) R[j]=a[q+j+1];
        L[n1]= sentinel;
        R[n2]=sentinel;
        int i=0,j=0;
        for (int k = p; k <=r ; k++) {
            if (L[i].compareTo(R[j])<=0){
                a[k]=L[i];
                i++;
            }
            else {
                a[k]=R[j];
                j++;
            }
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        int n1,n2;
        n1=q-p+1; n2=r-q;
        int[] L=new int[n1+1]; int R[]=new int[n2+1];
        for (int i=0;i<n1;i++) L[i]=a[p+i];
        for (int j = 0; j <n2 ; j++) R[j]=a[q+j+1];
        L[n1]= Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;
        int i=0,j=0;
        for (int k = p; k <=r ; k++) {
            if (L[i]<=R[j]){
                a[k]=L[i];
                i++;
            }
            else {
                a[k]=R[j];
                j++;
            }
        }
    }


    // Alte Methoden / Hilfsmethoden / Ungenutzte

    // MaxWin Testen
    private static int Maxwin(int[] a, int p, int r, int t1, int t2) {
        int q=(p+r)/2;
        int n1,n2;
        n1=q-p+1; n2=r-q;
        int[] L=new int[n1+1]; int R[]=new int[n2+1];
        for (int i=0;i<n1;i++) L[i]=a[p+i];
        for (int j = 0; j <n2 ; j++) R[j]=a[q+j+1];
        L[n1]= Integer.MAX_VALUE;
        R[n2]=Integer.MIN_VALUE;
        int min = Arrays.stream(L).min().getAsInt();
        int max = Arrays.stream(R).max().getAsInt();
        return Math.max(t1,Math.max(t2,max-min));
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

    public static int maxi(int[] a){
        int max=-1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j <a.length ; j++) {
                if (a[i]<a[j] && max<a[j]-a[i]) max=a[j]-a[i];
            }
        }
        return max;
    }

    public static int maxirec(int[] a,int p,int r){
        int t1;
        int t2,q;
        if (p==r) return 0;
        else{
            q=(p+r)/2;
            t1=maxirec(a,p,q);
            t2=maxirec(a,q+1,r);
            return Maxwin(a,p,r,t1,t2);
        }
    }
}
