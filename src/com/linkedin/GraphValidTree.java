package com.linkedin;

import java.util.*;

public class GraphValidTree {

    public boolean isValidTree(int n, int[][] edges) {
        if (edges.length == 0)
            return n == 1;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(edges[0][0]);
        queue.add(edges[0][0]);
        int nodes = 0;
        for (int[] edge : edges) {
            List<Integer> neighbors1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> neighbors2 = graph.getOrDefault(edge[1], new ArrayList<>());
            neighbors1.add(edge[0]);
            neighbors2.add(edge[1]);
            graph.put(edge[0], neighbors1);
            graph.put(edge[1], neighbors2);
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            nodes++;
            for (int neighbor : graph.get(node)) {
                if (queue.contains(node)) {
                    return false;
                }
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return nodes == n;
    }

    public static void main(String[] args) {
        GraphValidTree g = new GraphValidTree();
        int[][] edges = new int[][]{{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        g.isValidTree(5, edges);
    }
}
