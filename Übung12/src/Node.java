import java.util.LinkedList;

public class Node {
    Integer key;
    String coulour;
    Integer detected;
    Node father;
    Integer finished;
    LinkedList<Integer> adjacenceList;

    public Node(Integer key, LinkedList<Integer> adjacenceList) {
        this.key = key;
        this.adjacenceList = adjacenceList;
    }

    public Node(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public LinkedList<Integer> getAdjacenceList() {
        return adjacenceList;
    }
}