package com.linkedin;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dpArr = new int[amount + 1];
        Arrays.fill(dpArr, amount + 1);
        dpArr[0] = 0;
        for (int i = 0; i<= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // The 1 is for adding this particular coin and dpArr[i - coins[j]] will be
                    // using previous values. dp[11 - 1] = dp[10] (dp[10] will already be calculated)
                    dpArr[i] = Math.min(dpArr[i], 1 + dpArr[i - coins[j]]);
                }
            }
        }
        return dpArr[amount] > amount ? -1 : dpArr[amount];
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        c.coinChange(coins, 11);
    }
}
