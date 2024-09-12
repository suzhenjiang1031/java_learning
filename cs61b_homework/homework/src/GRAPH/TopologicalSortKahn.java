package GRAPH;

import java.util.*;

import java.util.*;

class TopologicalSortKahn {
    static class Graph {
        private int vertices; // 顶点数量
        private List<List<Integer>> adjacencyList; // 邻接表

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        // 添加一条边
        public void addEdge(int source, int target) {
            adjacencyList.get(source).add(target);
        }

        // Kahn算法实现的拓扑排序
        public void topologicalSort() {
            int[] inDegree = new int[vertices]; // 记录每个顶点的入度

            // 计算每个顶点的入度
            for (int i = 0; i < vertices; i++) {
                for (int neighbor : adjacencyList.get(i)) {
                    inDegree[neighbor]++;
                }
            }

            // 初始化一个队列，将所有入度为0的顶点加入队列
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < vertices; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            // 用于存储拓扑排序的结果
            List<Integer> topologicalOrder = new ArrayList<>();

            // BFS处理
            while (!queue.isEmpty()) {
                int current = queue.poll();
                topologicalOrder.add(current);

                // 遍历该顶点的邻居，更新邻居的入度
                for (int neighbor : adjacencyList.get(current)) {
                    inDegree[neighbor]--;

                    // 如果某个邻居的入度变为0，将其加入队列
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }

            // 检查是否所有顶点都被处理了，如果没有则图中存在环
            if (topologicalOrder.size() != vertices) {
                System.out.println("Graph has a cycle, no topological ordering exists.");
            } else {
                // 打印拓扑排序结果
                System.out.println("Topological Sort (Kahn's Algorithm): " + topologicalOrder);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort(); // 执行拓扑排序
    }
}
