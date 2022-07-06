package com.linkedin;

import java.util.HashSet;
import java.util.Set;

public class ConnectedComponents {

    public int countComponents(int n, int[][] edges) { //[[0, 1], [1, 2], [3, 4]]
        int[] ids = new int[n];
        Set set = new HashSet();
        for (int i=0; i<n; i++) {
            ids[i] = i; //[0,1,2,3,4]
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1], ids);
        }
        //[1,2,2,4,4]
        for (int i=0; i<ids.length; i++) {
            set.add(find(ids[i], ids));
        }
        return set.size();
    }

    private void union(int edge1, int edge2, int[] ids) {
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        if (parent1 != parent2) {
            ids[parent1] = parent2;
        }
    }

    private int find(int edge, int[] ids) { //0, [1,2,2,4,4]
        if (ids[edge] != edge) {
            return find(ids[edge], ids);
        }
        return edge;
    }

    public static void main(String[] args) {
        ConnectedComponents c = new ConnectedComponents();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(c.countComponents(5, edges));
    }
}
