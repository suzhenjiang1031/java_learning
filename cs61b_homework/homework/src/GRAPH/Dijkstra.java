package GRAPH;

import java.util.*;

public class Dijkstra {

    // 定义边的类
    static class Edge {
        int target; // 目标顶点
        int weight; // 边的权重

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // 实现 Dijkstra 算法的函数
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<Edge>> graph, int source) {
        // 存储源点到每个顶点的最短距离
        Map<Integer, Integer> dist = new HashMap<>();
        // 优先队列，按照距离从小到大排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 初始化距离
        for (Integer vertex : graph.keySet()) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(source, 0);
        queue.offer(new int[]{source, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0];
            int currentDist = current[1];

            // 如果当前距离大于已知最短距离，跳过
            if (currentDist > dist.get(u)) {
                continue;
            }

            // 遍历邻接点
            for (Edge edge : graph.getOrDefault(u, new ArrayList<>())) {
                int v = edge.target;
                int weight = edge.weight;
                int distanceThroughU = dist.get(u) + weight;

                // 如果通过 u 到 v 的距离更短，更新距离并加入队列
                if (distanceThroughU < dist.get(v)) {
                    dist.put(v, distanceThroughU);
                    queue.offer(new int[]{v, distanceThroughU});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        // 创建示例图
        Map<Integer, List<Edge>> graph = new HashMap<>();

        // 添加边到图中
        graph.put(0, Arrays.asList(new Edge(1, 4), new Edge(2, 1)));
        graph.put(1, Arrays.asList(new Edge(3, 1)));
        graph.put(2, Arrays.asList(new Edge(1, 2), new Edge(3, 5)));
        graph.put(3, new ArrayList<>());

        int source = 0; // 定义源点
        Map<Integer, Integer> distances = dijkstra(graph, source);

        // 输出结果
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("从节点 " + source + " 到节点 " + entry.getKey() + " 的最短距离是 " + entry.getValue());
        }
    }
}
