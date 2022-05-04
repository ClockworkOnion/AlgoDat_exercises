import java.util.Random;
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

    public static void insertionSort(int[] a){
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



    public static<T extends Comparable<T>> void insertionSortGen(T[] a) {
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

    public static void main(String[] args) {
        //1
        long before=java.lang.System.nanoTime();
        int[] arr1=createSequenceDec(100);
        insertionSort(arr1);
        long after=java.lang.System.nanoTime();
        //System.out.println(after-before); //116600-131100-140900-84200-99500-81700-84200-86300-89100-83400 //Average=99700

        //2
        before=java.lang.System.nanoTime();
        int[] arr2=createSequenceDec(1000);
        after=java.lang.System.nanoTime();
        //System.out.println(after-before); //14500-17100-14400-25400-18300-17700-13400-16400-15800-39600 //Average=19260

        //3
        before=java.lang.System.nanoTime();
        int[] arr3=createSequenceDec(10000);
        after=java.lang.System.nanoTime();
        //System.out.println(after-before); //131700-167000-131100-126900-133700-137500-135800-130900-151000-131600 //Average=137720

        //4
        before=java.lang.System.nanoTime();
        int[] arr4=createSequenceDec(100000);
        after=java.lang.System.nanoTime();
        //System.out.println(after-before); //1739100-1395600-1554600-1217800-975800-1889700-1140800-1132900-938300-1285500 //Average=1327010

        //5
        before=java.lang.System.nanoTime();
        int[] arr5=createSequenceDec(200000);
        after=java.lang.System.nanoTime();
        System.out.println(after-before); //601700-762300-942900-982000-761700-621200-628600-1004500-775300-918200 //Average=799840



    }


}
