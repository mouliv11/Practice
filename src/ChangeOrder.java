public class ChangeOrder {

    private static int makeChange(int c) {
        int[] cache = new int[c+1];
        for (int i=1; i<c+1; i++) {
            cache[i] = -1;
        }
        return makeChange(c, cache);
    }

    private static int makeChange(int c, int[] cache) {
        if (cache[c]>=0) return cache[c];
        int[] coins = new int[]{10, 6 ,1};
        int currentCnt = Integer.MAX_VALUE;
        for (int coin : coins) {
            if(c - coin >= 0) {
                int minCnt = makeChange(c - coin, cache);
                if(minCnt < currentCnt)
                    currentCnt = minCnt;
            }
        }
        cache[c] = currentCnt + 1;
        return cache[c];
    }

    public static void main(String args[]) {
        System.out.println(makeChange(49));
    }
}
