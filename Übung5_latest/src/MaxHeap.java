// Java program to implement Max Heap

// Main class
public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity
    public MaxHeap(int maxsize)
    {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    // Method 1
    // Returning position of parent
    private int parent(int pos) { return (pos - 1) / 2; }

    // Method 2
    // Returning left children
    private int leftChild(int pos) { return (2 * pos) + 1; }

    // Method 3
    // Returning right children
    private int rightChild(int pos){ return (2 * pos) + 2; }

    // Method 4
    // Returning true of given node is leaf
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Method 5
    // Swapping nodes
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Method 6
    // Recursive function to max heapify given subtree
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)]
                || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)]
                    > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // Method 7
    // Inserts a new element to max heap
    public void insert(int element)
    {
        Heap[size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // Method 8
    // To display heap
    public void print()
    {

        for(int i=0;i<size/2;i++){

            System.out.print("Parent Node : " + Heap[i] );

            if(leftChild(i)<size) //if the child is out of the bound of the array
                System.out.print( " Left Child Node: " + Heap[leftChild(i)]);

            if(rightChild(i)<size) //if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: "+ Heap[rightChild(i)]);

            System.out.println(); //for new line

        }

    }


    public int Find(int i,int elem){
        int x=-1,y=-1; int left=leftChild(i),right=rightChild(i);
        if (Heap[i]<elem ) return -1;
        else if (Heap[i]==elem ) return 1;
        else{
            if (right<=size-1 && Heap[right]>= elem  )
                x=Find(right,elem);
            else x=-1;
            if (left<=size-1 && Heap[left]>=elem )
                y=Find(left,elem);
            else y=-1;
        }
        return (Math.max(x,y));
    }

    public boolean Find1(int i, int elem){
        if (Heap[i] == elem) return true;
        if (Heap[i] < elem) return false;
        int left = leftChild(i);
        int right = rightChild(i);
        if (left<=size-1 && Find1( left, elem) == true) return true;
        else{
            if (right<=size-1)
                return (Find1( right, elem));
            else  return false;
        }


    }

    // Method 9
    // Remove an element from max heap
    public int extractMax()
    {
        int popped = Heap[0];
        Heap[0] = Heap[size--];
        maxHeapify(0);
        return popped;
    }

    // Method 10
    // main dri er method
    public static void main(String[] arg)
    {
//        // Display message for better readability
        System.out.println("The Max Heap is ");

        MaxHeap maxHeap = new MaxHeap(15);

        // Inserting nodes
        // Custom inputs
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
//
//        // Calling maxHeap() as defined above
     maxHeap.print();
//
        //System.out.println(maxHeap.Heap[]);
//        // Print and display the maximum value in heap
      System.out.println(maxHeap.Find1(2,9));
     //System.out.println(maxHeap.Find1(0,6));



//        byte b1 = (byte) 32768;
//        String s1 = String.format("%32s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
//        System.out.println(s1); // 10000001
    }
}
