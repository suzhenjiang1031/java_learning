package GRAPH;

import java.util.*;

class Prim {
    static class Edge {
        int target, weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int target, int weight) {
            adjacencyList[source].add(new Edge(target, weight));
            adjacencyList[target].add(new Edge(source, weight)); // 无向图
        }

        public void primMST() {
            boolean[] mstSet = new boolean[vertices]; // 表示该顶点是否被加入MST
            int[] key = new int[vertices]; // 用于存储每个顶点的最小边权重
            int[] parent = new int[vertices]; // 用于存储MST中每个顶点的父节点

            // 初始化所有键值为无穷大
            Arrays.fill(key, Integer.MAX_VALUE);
            key[0] = 0; // 选择第一个顶点作为起点
            parent[0] = -1; // 根节点没有父节点

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));
            pq.add(new int[]{0, 0}); // {权重, 顶点}

            while (!pq.isEmpty()) {
                int u = pq.poll()[1]; // 取出当前最小权重的顶点

                mstSet[u] = true; // 将该顶点标记为MST的一部分

                // 遍历所有相邻顶点，更新键值
                for (Edge edge : adjacencyList[u]) {
                    int v = edge.target;
                    int weight = edge.weight;

                    // 如果 v 不在 MST 中并且权重小于 key[v]，更新
                    if (!mstSet[v] && weight < key[v]) {
                        parent[v] = u;
                        key[v] = weight;
                        pq.add(new int[]{key[v], v});
                    }
                }
            }

            // 打印最小生成树
            System.out.println("Edge \tWeight");
            for (int i = 1; i < vertices; i++) {
                System.out.println(parent[i] + " - " + i + "\t" + key[i]);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}
