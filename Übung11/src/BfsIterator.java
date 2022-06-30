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
      UndirectedGraph graph1=UndirectedGraph.createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung11\\out.ucidata-zachary.sec");
      UndirectedGraph graph2=UndirectedGraph.createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung11\\soc-twitter-follows.txt");

      BfsIterator bfs1=new BfsIterator(graph1,1);

        while (!bfs1.queue.isEmpty()){
            int x=bfs1.queue.peek();
            int index=bfs1.graph.accessByKey(x);
            System.out.println(bfs1.next() +" with distance : "+ graph1.graph.get(index).distance);
        }

        BfsIterator bfs2=new BfsIterator(graph1,1);

        while (!bfs2.queue.isEmpty()){
            int x=bfs2.queue.peek();
            int index=bfs2.graph.accessByKey(x);
            System.out.println(bfs2.next() +" with distance : "+ graph1.graph.get(index).distance);
        }





    }

}
