import java.util.Arrays;

public class SearchTools {

    public static int[] createSequenceInc(int n){
        int[] arr=new int[n];
        for (int i=1;i<n;i++) arr[i]=i;
        return arr;
    }

    public static int linSearch(int[] A, int x){
        for (int i = 0; i < A.length; i++) {
            if (A[i]==x) return i;
        }
        return -1;
    }

    public static int binSearch(int[] A, int x, int l, int r){
        int q;
        if (l>r) return -1;
        else {
            q=(l+r)/2;
            if (A[q]==x) return q;
            else if (x>A[q]) return binSearch(A,x,q+1,r);
            else return binSearch(A,x,l,q);
        }
    }

    public static int binSearchNew(int[] A,int x,int l,int r){
        int q,w;
        if (l>r) return -1;
        else {
            q=l+(l+r)/3;
            w=l+2*((l+r)/3)+1;
            if (A[q]==x) return q;
            else if (x==A[w]) return w;
            else if (A[q]>x) return binSearch(A,x,l,q);
            else if (A[q]<x && A[w]>x) return binSearch(A,x,q+1,w);
            else return binSearch(A,x,w+1,r);
        }
    }


}
