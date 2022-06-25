import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BfsIterator {
    private UndirectedGraph graph=new UndirectedGraph();
    private Queue<Integer> queue=new LinkedList<>();



    public BfsIterator(UndirectedGraph g, Integer s) throws CustomException {
        if(g.containsVertex(s)) {
            this.graph = g;
            for (Node e:g.graph) {
                if (e.key.equals(s)) continue;
                else e.coulour= "white";
            }
            int x=g.accessByKey(s);
            g.graph.get(x).distance=0;
            this.queue.add(s);
        }else{
            throw new CustomException("No Vertex such that");
        }
    }

    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    public Integer next() throws CustomException {
        Integer x= queue.remove();
        int index=graph.accessByKey(x);
        LinkedList<Integer> l=graph.graph.get(index).adjacenceList;
        for (Integer v:l) {
            int index1=graph.accessByKey(v);
            if (graph.graph.get(index1).coulour.equals("white")){
                Node n =graph.graph.get(index1);
                n.coulour="gray";
                n.distance=graph.graph.get(index).distance+1;
                queue.add(n.key);
            }
        }
        graph.graph.get(index).coulour="black";
        return graph.graph.get(index).key;
    }

    public Integer dist(Integer v) throws CustomException {
        int x=graph.accessByKey(v);
        return graph.graph.get(x).distance;
    }


    public static void main(String[] args) throws IOException, CustomException {
      UndirectedGraph graph=UndirectedGraph.createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung11\\ana");
      //UndirectedGraph.printGraph(graph);
        BfsIterator bfs=new BfsIterator(graph,1);

        while (!bfs.queue.isEmpty()){
            int x=bfs.queue.peek();
            int index=bfs.graph.accessByKey(x);
            System.out.println(bfs.next() +" with distance : "+ graph.graph.get(index).distance);
        }



    }

}
