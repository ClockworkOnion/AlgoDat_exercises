import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class DfsAlgos {
    private DirectedGraph graph=new DirectedGraph();
    private LinkedList<Integer> dfs=new LinkedList<>();
    private Integer time;



    public DfsAlgos(DirectedGraph g, Integer s) throws CustomException {
        if(g.containsVertex(s)) {
            this.graph = g;
            for (Node e:g.graph) {
                e.coulour= "white";
            }
            time =0;
        }else{
            throw new CustomException("No Vertex such that");
        }
    }

    public void DfsvisitForTopSort(Node u) throws CustomException {
        u.coulour = "grey";
        time = time+1;
        u.detected= time;
        for (Integer e: u.adjacenceList) {
            int index1=graph.accessByKey(e);

            if (graph.graph.get(index1).coulour.equals("white")) {
                Node n=graph.graph.get(index1);
                n.father=u;
                DfsvisitForTopSort(n);
            }

        }
        u.coulour="black";
        time++;
        u.finished=time;
        dfs.addFirst(u.key);
    }

    public void Dfs(DirectedGraph g) throws CustomException {
        for (Node e:g.graph) {
            if (e.coulour.equals("white")){
                DfsvisitForTopSort(e);
            }
        }
    }

    public void Dfs1(DirectedGraph g) throws CustomException {
        DfsvisitForTopSort(g.graph.get(5));
    }

    public LinkedList<Integer> topSort(DirectedGraph g) throws CustomException {
        this.Dfs(g);
        for (int i=dfs.size()-1;i>=0;i--) {
            Node e=graph.graph.get(graph.accessByKey(dfs.get(i)));
            for (int j = 0; j < i; j++) {
                if (e.adjacenceList.contains(dfs.get(j))){
                    dfs=null;
                    return null;
                }
            }
        }
        return dfs;
    }

    public LinkedList<Integer> detectCycle(DirectedGraph g) throws CustomException {
        LinkedList<Integer> l=new LinkedList<>();
        this.Dfs(g);
        for (int i=dfs.size()-1;i>=0;i--) {
            Node e=graph.graph.get(graph.accessByKey(dfs.get(i)));
            for (int j = 0; j < i; j++) {
                if (e.adjacenceList.contains(dfs.get(j))){
                    for (int m=j;m<i;m++) {
                        l.add(dfs.get(m));
                        //l.add(dfs.get(i));
                    }
                    l.add(dfs.get(i));
                }
            }
        }
        return l;
    }

    public static void main(String[] args) throws IOException, CustomException {
        DirectedGraph graph1=DirectedGraph.createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung12\\outbnet.sec");
        DirectedGraph graph2=DirectedGraph.createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung12\\outmaayan-figeys.sec");
        DirectedGraph graph3=DirectedGraph.createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung12\\outmoreno_dense_comm.sec");
        DirectedGraph graph4=DirectedGraph.createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung12\\outmoreno_taro_taro.sec");
        DirectedGraph graph5=DirectedGraph.createGraphFromFile("C:\\Users\\21260\\Desktop\\Übung12\\outsimple.sec");
        //DirectedGraph.printGraph(graph2);

        //Topoligische Sortierung
        DfsAlgos dfs1=new DfsAlgos(graph1,1);
        DfsAlgos dfs2=new DfsAlgos(graph2,1);
        DfsAlgos dfs3=new DfsAlgos(graph3,1);
        DfsAlgos dfs4=new DfsAlgos(graph4,1);
        DfsAlgos dfs5=new DfsAlgos(graph5,1);

//        dfs1.topSort(graph1);
//        if (dfs1.dfs == null) System.out.println("Der Graph hat keine topologische Sortierung");
//        else {
//            dfs1.dfs.stream().forEach(x-> System.out.print(x+"-->"));
//        }
//
//        System.out.println();
//        dfs2.topSort(graph2);
//
//
//        if (dfs2.dfs == null){
//            System.out.println("Der Graph hat keine topologische Sortierung");
//        }
//        else {
//            System.out.println("ss");
//            dfs2.dfs.stream().forEach(x-> System.out.print(x+"-->"));
//        }
//
//        System.out.println();
//        dfs3.topSort(graph3);
//        if (dfs1.dfs == null) System.out.println("Der Graph hat keine topologische Sortierung");
//        else {
//            dfs3.dfs.stream().forEach(x-> System.out.print(x+"-->"));
//        }
//
//        System.out.println();
//        dfs4.topSort(graph4);
//        if (dfs4.dfs == null) System.out.println("Der Graph hat keine topologische Sortierung");
//        else {
//            dfs4.dfs.stream().forEach(x-> System.out.print(x+"-->"));
//        }
//
//        dfs5.topSort(graph1);
//        if (dfs1.dfs == null) System.out.println("Der Graph hat keine topologische Sortierung");
//        else {
//            dfs5.dfs.stream().forEach(x-> System.out.print(x+"-->"));
//        }

        //Zyklusentdeckung
        LinkedList<Integer> list1=dfs1.detectCycle(graph1);
        if (list1.isEmpty()) System.out.println("Der Graph hat keinen Zyklus ");
        else {
            list1.stream().forEach(x-> System.out.print(x+"-->"));
        }

        System.out.println();
        LinkedList<Integer> list2=dfs2.detectCycle(graph2);

        if (list2.isEmpty()){
            System.out.println("Der Graph hat keinen Zyklus");
        }
        else {
            list2.stream().forEach(x-> System.out.print(x+"-->"));
        }

        System.out.println();
        LinkedList<Integer> list3=dfs3.detectCycle(graph3);
        if (list3.isEmpty()) System.out.println("Der Graph hat keinen Zyklus");
        else {
            dfs3.dfs.stream().forEach(x-> System.out.print(x+"-->"));
        }

        System.out.println();
        LinkedList<Integer> list4=dfs4.detectCycle(graph4);
        if (list4.isEmpty()) System.out.println("Der Graph hat keinen Zyklus");
        else {
            list4.stream().forEach(x-> System.out.print(x+"-->"));
        }

        System.out.println();
        LinkedList<Integer> list5=dfs5.detectCycle(graph1);
        if (list5.isEmpty()) System.out.println("Der Graph hat keinen Zyklus");
        else {
            list5.stream().forEach(x-> System.out.print(x+"-->"));
        }




    }


}
