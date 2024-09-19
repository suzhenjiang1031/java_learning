package GRAPH;

import java.util.*;

// 边的类，包含两个顶点和边的权重
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // construct function
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;  // 按权重升序排序
    }
}

// 并查集（Union-Find）结构
class UnionFind {
    private int[] parent;
    private int[] rank;

    // 初始化
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // 每个节点的父节点初始化为自己
            rank[i] = 0;    // 每个节点的初始秩为 0
        }
    }

    // 查找带路径压缩
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);  // 递归查找根节点，并压缩路径
        }
        return parent[p];
    }

    // 合并两棵树，按秩合并
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP != rootQ) {
            // 按秩合并：秩低的树合并到秩高的树
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }
}

// Kruskal 算法的类
public class KruskalAlgorithm {
    private int V;  // 图的顶点数量
    private List<Edge> edges;  // 图的边集

    public KruskalAlgorithm(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    // 添加一条边
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Kruskal 最小生成树算法
    public List<Edge> kruskalMST() {
        // 保存最终的最小生成树
        List<Edge> result = new ArrayList<>();

        // 按边的权重从小到大排序
        Collections.sort(edges);

        // 创建并查集，用于检测环
        UnionFind uf = new UnionFind(V);

        // 遍历边集，选择不会形成环的边
        for (Edge edge : edges) {
            int rootSrc = uf.find(edge.src);
            int rootDest = uf.find(edge.dest);

            // 如果两个顶点不在同一连通分量中，则加入这条边
            if (rootSrc != rootDest) {
                result.add(edge);
                uf.union(edge.src, edge.dest);  // 合并两个顶点
            }

            // 如果已经选了 V-1 条边，则生成树已经完成
            if (result.size() == V - 1) {
                break;
            }
        }

        return result;
    }

    // 打印最小生成树
    public void printMST(List<Edge> result) {
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : result) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
    }

    public static void main(String[] args) {
        // 创建一个图，顶点数量为 4
        KruskalAlgorithm graph = new KruskalAlgorithm(4);

        // 添加边 (src, dest, weight)
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);

        // 运行 Kruskal 算法获取最小生成树
        List<Edge> mst = graph.kruskalMST();

        // 打印最小生成树
        graph.printMST(mst);
    }
}
