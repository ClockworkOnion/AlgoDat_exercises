// Aufgabe 1 a) Interface Priority Queue
interface PriorityQueuee<K extends Comparable<K>>{
    public void addElement(K elem, K sentinel) throws CustomException;
    public K getFirst();
    public void deleteFirst() throws CustomException;

}
