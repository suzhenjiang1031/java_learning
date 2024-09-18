package GRAPH;

import java.util.Arrays;

public class PrimAlgorithm {

    // 找到未被包含在最小生成树中的、权重最小的顶点
    private static int findMinKey(int[] key, boolean[] mstSet) {
        int minKey = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < minKey) {
                minKey = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Prim算法的实现
    public static void primMST(int[][] graph) {
        int V = graph.length; // 顶点数量
        int[] parent = new int[V]; // 存储构成MST的树的父节点
        int[] key = new int[V]; // 每个节点的最小边权值
        boolean[] mstSet = new boolean[V]; // 是否已包含在MST中

        // 初始化所有顶点的key值为无穷大，父节点为-1
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // 从第一个节点开始，key值为0（使其被优先选中）
        parent[0] = -1; // 第一个节点是根节点，父节点为-1

        // 最小生成树包含V个顶点
        for (int count = 0; count < V - 1; count++) {
            // 选择一个不在MST中的、key值最小的顶点
            int u = findMinKey(key, mstSet);
            mstSet[u] = true; // 将选中的顶点包含到MST中

            // 更新与u相邻的未被包含在MST中的顶点的key值
            for (int v = 0; v < V; v++) {
                // graph[u][v] != 0 表示u和v之间有边，!mstSet[v]表示v还未包含在MST中
                // 更新key值和父节点索引，如果当前边的权重比key[v]小
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // 打印MST
        printMST(parent, graph);
    }

    // 打印最小生成树的边和权重
    private static void printMST(int[] parent, int[][] graph) {
        System.out.println("最小生成树的边及其权重:");
        for (int i = 1; i < graph.length; i++) {
            System.out.println("边: " + parent[i] + " - " + i + " \t权重: " + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        // 定义一个5个节点的图，使用邻接矩阵表示
        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };

        // 调用Prim算法，计算最小生成树
        primMST(graph);
    }
}
