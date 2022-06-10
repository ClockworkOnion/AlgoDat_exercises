import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortTools {
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
//1**********************************************
    public static void QuickSort(int[] A,int l,int r){
        int q;
        if (r>l){
            q=PartitionFirstElement(A,l,r);
            QuickSort(A,l,q-1);
            QuickSort(A,q+1,r);
        }

    }

    private static int PartitionFirstElement(int[] A, int l, int r) {
        int x=A[l];
        int i=l;
        for (int j=l+1;j<=r;j++){
            if (A[j]<=x){
                i++;
                int tem=A[i];
                A[i]=A[j];
                A[j]=tem;
            }
        }
        int tem=A[i];
        A[i]=A[l];
        A[l]=tem;

        return i;
    }
//**********************************************************

    public static void quickSortRandom(int[] A,int l,int r){
        int q;
        if (r>l){
            q=PartitionRandom(A,l,r);
            quickSortRandom(A,l,q-1);
            quickSortRandom(A,q+1,r);
        }
    }

    private static int PartitionRandom( int[] A,int l, int r) {
        Random random=new Random();
        int ran=random.nextInt(l,r);
        int temp=A[l];
        A[l]=A[ran];
        A[ran]=temp;
        return PartitionFirstElement(A,l,r);
    }
//***********************************************************

    public static void quickSortNewRandom(int[] A,int l,int r){
        int q;
        if (r>l){
            q=PartitionNewRandom(A,l,r);
            quickSortNewRandom(A,l,q-1);
            quickSortNewRandom(A,q+1,r);
        }
    }

    private static int PartitionNewRandom(int[] A, int l, int r) {
        Random random=new Random();
        int ran1=random.nextInt(l,r);
        int ran2=random.nextInt(l,r);
        int ran3=random.nextInt(l,r);
        int mid;

        if (ran1 > ran2)
        {
            if (ran2 > ran3)
                mid=ran2;
            else if (ran1 > ran3)
                mid=ran3;
            else
                mid=ran1;
        }
        else
        {
            if (ran1 > ran3)
                mid=ran1;
            else if (ran2 > ran3)
                mid=ran3;
            else
                mid=ran2;
        }
        int temp=A[l];
        A[l]=A[mid];
        A[mid]=temp;
        return PartitionFirstElement(A,l,r);
    }

//*************************************************


    public static void quickSortTriRandom(int A[],int l,int r){
        int[] pivots = new int[2];
        if (r>l){
            pivots=PatritionTri(A,l,r);
            quickSortTriRandom(A,l,pivots[0]-1);
            quickSortTriRandom(A,pivots[0]+1,pivots[1]-1);
            quickSortTriRandom(A,pivots[1]+1,r);
        }
    }

    public static void quickSortTriNewRandom(int A[],int l,int r){
        int[] pivots = new int[2];
        if (r>l){
            pivots=PatritionTri(A,l,r);
            quickSortTriNewRandom(A,l,pivots[0]-1);
            quickSortTriNewRandom(A,pivots[0]+1,pivots[1]-1);
            quickSortTriNewRandom(A,pivots[1]+1,r);
        }
    }

    //wählen von Pivots und setzen
    public static int[] PatritionTriNew(int[] A, int l, int r) throws CustomException {
        if (A.length<2) throw new CustomException("Länge muss mindestens 2 sein");
        Random random=new Random();
        int[] arr=random.ints(5,l,r).toArray();
        arr=Arrays.stream(arr).map(x->x=A[x]).toArray();
        Arrays.sort(arr);
        int x=arr[1],y=arr[3];

        int i= IntStream.range(0, A.length).filter(p->A[p]==x).findFirst().getAsInt();
        int j=IntStream.range(0, A.length).filter(p->A[p]==y).findFirst().getAsInt();

        if (x<=y){
            int temp=A[l];
            A[l]=A[i];
            A[i]=temp;

            temp=A[r];
            A[r]=A[j];
            A[j]=temp;
        }
        else {
            int temp=A[l];
            A[l]=A[j];
            A[j]=temp;

            temp=A[r];
            A[r]=A[i];
            A[j]=temp;
        }
        return A;
    }

    //wählen von Pivots und setzen
    public static int[] PartitionTriRandom(int[] A, int l, int r) throws CustomException {
        if (A.length<2) throw new CustomException("Länge muss mindestens 2");
            Random random=new Random();
            int ran1=random.nextInt(l,r);
            int ran2=random.nextInt(l,r);
            if (A[ran1]<=A[ran2]){
                //place ran1
                int temp=A[l];
                A[l]=A[ran1];
                A[ran1]=temp;

                //place ran2
                temp=A[r];
                A[r]=A[ran2];
                A[ran2]=temp;
            }
            else {
                int temp=A[l];
                A[l]=A[ran2];
                A[ran2]=temp;

                //place ran2
                temp=A[r];
                A[r]=A[ran1];
                A[ran1]=temp;
            }
            return A;
    }
    //Partitioning für 2 Pivots
    private static int[] PatritionTri(int[] A, int l, int r) {
        int x = A[l], y = A[r];
        int i = l + 1, j = r - 1;
        int k = l + 1, g = r;
        while (i <= g) {
            if (A[i] <= x) {
                swap(A, k, i);
                k++;
                i++;
            } else{
                if (A[i]>y){
                    int p=i;
                    while (p<g){
                        swap(A,p,p+1);
                        p++;
                    }
                    g--;
                }
                else i++;
            }
        }
        k--;
        swap(A,l,k);
        return new int[]{k, g};
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) throws CustomException {
        int[] A =createSequenceRand(2);

        System.out.println("before : ");
        System.out.println(Arrays.toString(A));
        System.out.println("after : ");
        PatritionTriNew(A,0,A.length-1);

        quickSortTriNewRandom(A,0,A.length-1);
        System.out.println(Arrays.toString(A));
    }
}
