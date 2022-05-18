import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Stream;

public class PriorityQeueMinHeap<K extends Comparable<K>> implements PriorityQueuee<K> {
    private ArrayList<K> arr=new ArrayList<>();


    @Override
    public void addElement(K elem, K sentinel) throws CustomException {
        BuildMinHeap();
        Insert(elem,sentinel);
    }

    @Override
    public K getFirst() {
       BuildMinHeap();
       return arr.get(0);
    }

    @Override
    public void deleteFirst() throws CustomException {
        BuildMinHeap();
        ExtractMin();
    }

    public  K ExtractMin() throws CustomException{
        if (arr.size()==0){
           throw new CustomException("Extract min Exception");
        }
        K min = (K) arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        MinHeapify(0);
        return min;
    }

    public   void Insert(K key,K sentinel) throws CustomException {
        arr.add(sentinel); //arr.add(Collection.min(arr))
       Lol(arr.size()-1,key);
    }

    public void Lol(int i,K key) throws CustomException{
        if (arr.get(i).compareTo(key)<0){
            throw new CustomException("error by dicrease key");
        }
        arr.set(i,key);
        while (i>0 && arr.get(Father(i)).compareTo(arr.get(i))>0){
            K temp=arr.get(i);
            arr.set(i,arr.get(Father(i)));
            arr.set(Father(i),temp);
            i=Father(i);
        }
    }



    public <T> void BuildMinHeap(){
        for (int i = this.arr.size()/2; i>=0;i--) MinHeapify(i);
    }

    public int Left(int i){
        return 2*i+1;
    }

    public int Right(int i){
        return 2*i+2;
    }

    public int Father(int i){
        if (i%2==0) return (i/2)-1;
        else return i/2;
    }

    public  void MinHeapify(int i){
        int left=Left(i);
        int right=Right(i); int min=-5;
        if (left<=arr.size()-1 && arr.get(left).compareTo(arr.get(i))<0){
            min=left;
        }else {
            min=i;
        }
        if (right<=arr.size()-1 && arr.get(right).compareTo(arr.get(min))<0){
            min=right;
        }
        if (min != i){
            K temp=arr.get(i);
            arr.set(i,arr.get(min));
            arr.set(min,temp);
            MinHeapify(min);
        }
    }
//
//    public void Infos(K elem,K sentinel) throws CustomException {
//        System.out.println("getting first element : "+getFirst());
//        System.out.println("deleting first element : "+getFirst());
//        deleteFirst();
//        System.out.println("adding new element: ");
//        addElement(elem,sentinel);
//
//    }




    public static void main(String[] args) throws CustomException {
        PriorityQeueMinHeap<Integer> prq=new PriorityQeueMinHeap<>();
        //prq.addElement(1,Integer.MAX_VALUE);
        //prq.arr.forEach(x-> System.out.println(x));
        //System.out.println(prq.getFirst());
        prq.deleteFirst();

//        Random rdm=new Random();
//        for (int i = 1; i < 10; i++) {
//            Integer x=rdm.nextInt(1,50);
//            prq.arr.add(x);
//
//        }
//        System.out.println("before");
//        prq.arr.forEach(x-> System.out.println(x));
//        prq.BuildMinHeap();
//        System.out.println("after1");
//        prq.arr.forEach(x-> System.out.println(x));
//        prq.deleteFirst();
//        System.out.println("deleted");
//        prq.arr.forEach(x-> System.out.println(x));

//        prq.arr.add(1);  prq.arr.add(25);  prq.arr.add(100); prq.arr.add(36); prq.arr.add(7); prq.arr.add(19); prq.arr.add(17); prq.arr.add(3); prq.arr.add(2);
//        System.out.println("before");
//
//        prq.BuildMinHeap();  prq.arr.forEach(x-> System.out.println(x));
//        prq.addElement(0,Integer.MAX_VALUE); //max value to ensure for dicreasekey thats gonna be always the biggest elem
//        System.out.println("after");
//        prq.arr.forEach(x-> System.out.println(x));

    }
}
