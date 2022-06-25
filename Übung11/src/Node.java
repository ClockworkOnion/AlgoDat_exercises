import java.util.LinkedList;

public class Node {
    Integer key;
    String coulour;
    Integer distance;
    LinkedList<Integer> adjacenceList;

    public Node(Integer key, LinkedList<Integer> adjacenceList) {
        this.key = key;
        this.adjacenceList = adjacenceList;
    }

    public Integer getKey() {
        return key;
    }

    public LinkedList<Integer> getAdjacenceList() {
        return adjacenceList;
    }
}
