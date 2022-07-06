import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DirectedGraph {
    ArrayList<Node> graph;

    public DirectedGraph() {}

    public DirectedGraph(Integer n) {
        this.graph=new ArrayList<Node>(n);
        for (int i=0;i<n;i++) {
            int key=i+1;
            graph.add(i, new Node(key,new LinkedList<>()));
        }
    }

    public Integer accessByKey(Integer i) throws CustomException {
        for (int j = 0; j < graph.size(); j++) {
            if (i.equals(graph.get(j).key)) return j;
        }
        throw new CustomException("doesnt exist");
    }

    public boolean containsVertex(Integer i){
        for (Node e:graph) {
            if (e.key.equals(i)){
                return true;
            }
        }
        return false;
    }

    public void addVertex(Integer i) {
        if (containsVertex(i)) return;
        else{
            graph.add(new Node(i,new LinkedList<>()));
        }
    }

    public void addEdge(Integer i,Integer j) throws CustomException {
        if (!containsVertex(i)) throw new CustomException("no such vertex");
        int x=accessByKey(i);
        this.graph.get(x).adjacenceList.add(j);
    }

    public void deleteEdge(Integer i,Integer j) throws CustomException {
        if (!containsVertex(i)) throw new CustomException("no such vertex");
        int x=accessByKey(i);
        this.graph.get(x).adjacenceList.remove(j);
    }

    public static DirectedGraph createGraphFromFile(String filename) throws IOException, CustomException {
        File file = new File(filename);

        BufferedReader br1 = new BufferedReader(new FileReader(file));
        String st;
        int max=0;
        //getting max
        while ((st = br1.readLine()) != null){
            String[] ax= st.split("\\s+");
            int x1=Integer.parseInt(ax[0]);
            int x2=Integer.parseInt(ax[1]);
            max= Math.max(Math.max(x1,x2),max);
        }
        DirectedGraph graph = new DirectedGraph(max);
        String st2;
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        while ((st2 = br2.readLine()) != null){
            String[] ax= st2.split("\\s+");
            int x1=Integer.parseInt(ax[0]);
            int x2=Integer.parseInt(ax[1]);
            graph.addVertex(x1);
            graph.addVertex(x2);
            graph.addEdge(x1,x2);
        }

        return graph;
    }
    public static void printLinkedList(LinkedList<Integer> e){
        for (Integer x:e) {
            System.out.print(x+"-->");
        }
    }
    public static void printGraph(DirectedGraph graph){
        for (int i = 0; i < graph.graph.size(); i++) {
            System.out.print(graph.graph.get(i).key+" : "); printLinkedList(graph.graph.get(i).adjacenceList);
            System.out.println();
        }
    }

    public LinkedList<Integer> getNeighbours(Integer e) throws CustomException {
        int x=accessByKey(e);
        return graph.get(x).adjacenceList;
    }


    public static void main(String[] args) throws IOException, CustomException {
        //System.out.println(gr.graph.get(1).get(0));
        DirectedGraph graph=createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung12\\src\\test");
        printGraph(graph);
        //System.out.println(graph.graph.size());

    }
}
