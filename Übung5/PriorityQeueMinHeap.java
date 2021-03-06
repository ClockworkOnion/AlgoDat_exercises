import java.util.ArrayList;
import java.util.Random;

// Aufgabe 1 b)
public class PriorityQeueMinHeap<K extends Comparable<K>> implements PriorityQueuee<K> {
<<<<<<< Updated upstream
    private ArrayList<K> arr;
=======
    private ArrayList<K> arr = new ArrayList<>();
>>>>>>> Stashed changes
    private int Heapsize;
    private int Size;


    public PriorityQeueMinHeap(int size,int heapsize) throws CustomException {
        this.Size=size;
        if (heapsize<=size) this.Heapsize=heapsize;
        else throw new CustomException("Heapsize is bigger than max Size");
        this.arr=new ArrayList<>(Size);
    }

    @Override
    public void addElement(K elem, K sentinel) throws CustomException {
<<<<<<< Updated upstream
        BuildMinHeap();
        Insert(elem,sentinel);
=======
        BuildMinHeap(); //Angenommen das Array kein Minheap ist
        Insert(elem, sentinel);
>>>>>>> Stashed changes
    }

    @Override
    public K getFirst() throws CustomException {
        BuildMinHeap(); //Angenommen das Array kein Minheap ist
        return arr.get(0);
    }

    @Override
    public void deleteFirst() throws CustomException {
        BuildMinHeap(); //Angenommen das Array kein Minheap ist
        ExtractMin();
    }

    public K ExtractMin() throws CustomException {
        if (Heapsize < 1) {
            throw new CustomException("Extract min Exception");
        }
        K min = (K) arr.get(0);
        arr.set(0, arr.get(Heapsize - 1));
        arr.remove(Heapsize - 1);
        Heapsize--;
        MinHeapify(0);
        return min;
    }

    public void Insert(K key, K sentinel) throws CustomException {
        Heapsize = Heapsize + 1;
        arr.add(Heapsize - 1, sentinel); //arr.add(Collection.min(arr))
        IncreaseKey(Heapsize - 1, key);
    }

    public void IncreaseKey(int i, K key) throws CustomException {
        if (arr.get(i).compareTo(key) < 0) {
            throw new CustomException("error in increase key");
        }
        arr.set(i, key);
        while (i > 0 && arr.get(Father(i)).compareTo(arr.get(i)) > 0) {
            K temp = arr.get(i);
            arr.set(i, arr.get(Father(i)));
            arr.set(Father(i), temp);
            i = Father(i);
        }
    }

<<<<<<< Updated upstream


    public <T> void BuildMinHeap() throws CustomException {
        if (Size != 0)
            for (int i = (Heapsize-1)/2; i>=0;i--) MinHeapify(i);
        else throw new CustomException("Arraylist is empty");
=======
    public <T> void BuildMinHeap() {
        for (int i = (Heapsize - 1) / 2; i >= 0; i--) MinHeapify(i);
>>>>>>> Stashed changes
    }

    public int Left(int i) {
        return 2 * i + 1;
    }

    public int Right(int i) {
        return 2 * i + 2;
    }

    public int Father(int i) {
        if (i % 2 == 0) return (i / 2) - 1;
        else return i / 2;
    }

    public void MinHeapify(int i) {
        int left = Left(i);
        int right = Right(i);
        int min = -5;
        if (left <= Heapsize - 1 && arr.get(left).compareTo(arr.get(i)) < 0) {
            min = left;
        } else {
            min = i;
        }
        if (right <= Heapsize - 1 && arr.get(right).compareTo(arr.get(min)) < 0) {
            min = right;
        }
        if (min != i) {
            K temp = arr.get(i);
            arr.set(i, arr.get(min));
            arr.set(min, temp);
            MinHeapify(min);
        }
    }

    public static void main(String[] args) throws CustomException {
<<<<<<< Updated upstream
        PriorityQeueMinHeap<Integer> prq=new PriorityQeueMinHeap<>(5,5);
=======
        // PriorityQueueTest();
    }
>>>>>>> Stashed changes

    public static void PriorityQueueTest() throws CustomException {
        PriorityQeueMinHeap<Integer> prq = new PriorityQeueMinHeap<>(5);
        Random rdm = new Random();
        for (int i = 10; i > 1; i--) {
            //Integer x=rdm.nextInt(1,50);
            prq.arr.add(i);
        }
        System.out.println("before");
<<<<<<< Updated upstream
        prq.arr.forEach(x-> System.out.println(x));
//        prq.addElement(4,Integer.MAX_VALUE);
=======
        prq.arr.forEach(x -> System.out.println(x));
        prq.BuildMinHeap();
>>>>>>> Stashed changes
        //prq.addElement(0,Integer.MAX_VALUE);
        //prq.deleteFirst();
        prq.addElement(-20,Integer.MAX_VALUE);
        System.out.println("after");
<<<<<<< Updated upstream
        prq.arr.forEach(x-> System.out.println(x));

        //System.out.println(prq.Heapsize);
//        //System.out.println("before");
//        prq.arr.forEach(x-> System.out.println(x));
//        prq.BuildMinHeap();
//        System.out.println("after");
//        prq.arr.forEach(x-> System.out.println(x));
//
//        //adding new element
//        prq.addElement(800,Integer.MAX_VALUE);
//        System.out.println("adding");
//        prq.arr.forEach(x-> System.out.println(x));

=======
        prq.arr.forEach(x -> System.out.println(x));
        System.out.println(prq.Heapsize);
        //System.out.println("before");
        prq.arr.forEach(x -> System.out.println(x));
        prq.BuildMinHeap();
        System.out.println("after");
        prq.arr.forEach(x -> System.out.println(x));
>>>>>>> Stashed changes

        //adding new element
        prq.addElement(800, Integer.MAX_VALUE);
        System.out.println("adding");
        prq.arr.forEach(x -> System.out.println(x));
    }
}
