package com.linkedin;

public class Flowers {

    public boolean canPlaceFlowers (int[] flowerbed, int n) {
        int count = 0;
        for (int i=0; i<flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = (i == 0 || flowerbed[i-1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1 || flowerbed[i+1] == 0);
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public static void main (String[] args) {
        Flowers flowers = new Flowers();
        int[] flowerbed = new int[]{0,0,0,0,1};
        System.out.println(flowers.canPlaceFlowers(flowerbed, 1));
    }
}
