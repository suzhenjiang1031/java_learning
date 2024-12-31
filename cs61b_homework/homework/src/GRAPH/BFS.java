package GRAPH;

import java.util.LinkedList;
import java.util.List;

public class BFS {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; //Adjacency list

    //Constructor
    public BFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); //Add w to v's list
        adj[w].add(v); //Since the graph is undirected, and v to w's list
    }

    //BFS starting from a given source node
    public void bfs(int start) {
        //Mark all vertices as not visited (set to false)
        boolean[] visited = new boolean[V];

        //Create a queue for bfs
        LinkedList<Integer> queue = new LinkedList<>();

        //Mark the current node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            //Deque a vertex from queue and print it
            int current = queue.poll();
            System.out.println(current + " ");

            //Get all adjacent vertices of the dequeue vertex
            //If an adjacent vertex has not been visited, mark it as visited and enqueue it
            for (int nerghbor : adj[current]) {
                if (!visited[nerghbor]) {
                    visited[nerghbor] = true;
                    queue.add(nerghbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS b = new BFS(6); //Create a graph with 6 vertices

        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(1, 3);
        b.addEdge(2, 4);
        b.addEdge(3, 4);
        b.addEdge(4, 5);

        System.out.println("BFS starting from node 0:");
        b.bfs(0);
    }
}

