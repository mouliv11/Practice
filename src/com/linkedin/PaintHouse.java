package com.linkedin;

public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        for (int i=1; i<costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
    }

    public static void main (String[] args) {
        PaintHouse p = new PaintHouse();
        int[][] costs = new int[][]{{17,2,17}, {16,16,5}, {14,3,19}};
        System.out.println(p.minCost(costs));
    }
}
