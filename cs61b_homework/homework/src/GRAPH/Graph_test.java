//package GRAPH;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Graph_test {
//    private final i nt V;
//    private List<Integer>[] adj;
//
//    public Graph_test(int V) {
//        this.V = V;
//        adj = (List<Integer>[]) new ArrayList[V];
//
//        for (int v = 0; v < V; v++) {
//            adj[v] = new ArrayList<>();
//        }
//    }
//
//    public void addEdge(int v, int w) {
//        adj[v].add(w);
//        adj[w].add(v);
//    }
//
//    public Iterable<Integer> adj(int v) {
//        return adj[v];
//    }
//}
