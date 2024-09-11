package GRAPH;

import java.util.*;

class Kruskal {

    static class Edge implements Comparable<Edge> {
        int source, target, weight;

        public Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class Graph {
        int vertices;
        List<Edge> edges = new ArrayList<>();

        public Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEdge(int source, int target, int weight) {
            edges.add(new Edge(source, target, weight));
        }

        public void kruskalMST() {
            Collections.sort(edges); // 将所有边按权重升序排序

            int[] parent = new int[vertices];
            // 初始化并查集，所有顶点的父节点初始化为自己
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }

            List<Edge> mst = new ArrayList<>(); // 存储最小生成树的边
            int mstWeight = 0;

            for (Edge edge : edges) {
                int rootSource = find(parent, edge.source);
                int rootTarget = find(parent, edge.target);

                // 如果不在同一集合，说明加入此边不会产生环
                if (rootSource != rootTarget) {
                    mst.add(edge);
                    mstWeight += edge.weight;
                    union(parent, rootSource, rootTarget); // 合并两个集合
                }

                // 如果已经找到 V-1 条边，说明MST已经完成
                if (mst.size() == vertices - 1) {
                    break;
                }
            }

            // 输出最小生成树
            System.out.println("Edge \tWeight");
            for (Edge edge : mst) {
                System.out.println(edge.source + " - " + edge.target + "\t" + edge.weight);
            }
            System.out.println("Total Weight: " + mstWeight);
        }

        // 查找并查集的根节点
        private int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent, parent[vertex]); // 路径压缩
            }
            return parent[vertex];
        }

        // 合并两个集合
        private void union(int[] parent, int root1, int root2) {
            parent[root1] = root2;
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

        graph.kruskalMST();
    }
}
