package GRAPH;
import java.util.Arrays;

public class DijkstraAlgorithm {

    // 找到距离源节点最近且未被访问的节点
    private static int findMinDistance(int[] dist, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Dijkstra算法的实现
    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length; // 图的顶点数
        int[] dist = new int[V]; // 存储源节点到其他节点的最短距离
        boolean[] visited = new boolean[V]; // 标记已访问的节点

        // 初始化所有节点的最短路径为无穷大，源节点距离为0
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // 主循环：遍历每个节点
        for (int i = 0; i < V - 1; i++) {
            // 选择一个未被访问的，距离源节点最近的节点
            int u = findMinDistance(dist, visited);
            visited[u] = true; // 将其标记为已访问

            // 更新所有邻接节点的距离
            for (int v = 0; v < V; v++) {
                // 如果存在边、节点未被访问且经过u的路径比当前路径短，则更新
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // 打印结果
        printSolution(dist);
    }

    // 打印结果
    private static void printSolution(int[] dist) {
        System.out.println("节点到源节点的最短路径距离：");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("节点 " + i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // 定义一个5个节点的图，使用邻接矩阵表示
        int[][] graph = {
                { 0, 10, 0, 0, 5 },
                { 10, 0, 1, 0, 2 },
                { 0, 1, 0, 4, 0 },
                { 0, 0, 4, 0, 3 },
                { 5, 2, 0, 3, 0 }
        };

        // 调用Dijkstra算法，计算从节点0开始的最短路径
        dijkstra(graph, 0);
    }
}
