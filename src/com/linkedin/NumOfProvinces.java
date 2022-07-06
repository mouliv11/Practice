package com.linkedin;

public class NumOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int[] ids = new int[isConnected.length];
        int count = 0;
        for (int i=0; i<isConnected.length; i++) {
            ids[i] = i;
        }
        for (int i=0; i<isConnected.length; i++) {
            for (int j=0; j<isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i!=j) {
                    union(i, j, ids);
                }
            }
        }
        for (int i=0; i<ids.length; i++) {
            if (ids[i] == i)
                count++;
        }
        return count;
    }

    private void union(int edge1, int edge2, int[] ids) {
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        ids[parent1] = parent2;
    }

    private int find(int edge, int[] ids) {
        if(ids[edge] != edge)
            find(ids[edge], ids);
        return ids[edge];
    }
}
