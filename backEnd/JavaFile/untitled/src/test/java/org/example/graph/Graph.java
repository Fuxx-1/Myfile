package org.example.graph;

import java.util.*;

public class Graph {
    static class Edge {
        int val;
        int weight;

        public Edge(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), time = sc.nextInt();
        sc.nextLine();
        Map<Integer, List<Edge>> graph = new HashMap<>();
        // init
        for (int i = 0; i < m; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1, w = sc.nextInt();
            sc.nextLine();
            // x -> y
            graph.get(x).add(new Edge(y, w));
            // y -> x
            graph.get(y).add(new Edge(x, w));
        }
        // calculate the minDistance
        int[] minDistance = new int[m], visited = new int[m];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        int aimNode = sc.nextInt() - 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{aimNode, 0});
        while (!queue.isEmpty()) {
            int[] aim = queue.poll();
            if (visited[aim[0]] == 1) continue;
            visited[aim[0]] = 1;
            minDistance[aim[0]] = Math.min(aim[1], minDistance[aim[0]]);
            List<Edge> edges = graph.get(aim[0]);
            for (Edge edge : edges) {
                queue.offer(new int[]{edge.val, edge.weight + aim[1]});
            }
        }
        // get aims
//        int[] aim = new int[time];
//        for (int i = 0; i < time; i++) {
//            aim[i] = sc.nextInt();
//        }
        sc.close();
        System.out.println(Arrays.toString(minDistance));

    }
}
