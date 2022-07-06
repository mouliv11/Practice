public class Test {
    public static void main (String args[]) {
        int[] a = new int[]{1,2,5,6};
        twoMissing(a);
        int[] weights = new int[]{1,2,3};
        int[] vals = new int[]{6,10,12};
        knapsack(5, weights, vals);
    }

    public static void twoMissing(int[] arr) {
        int size = arr.length + 2;

        // 1 + 2 + ... + N-1 + N = N *(N + 1) / 2
        long totalSum = size * (size + 1) / 2;

        // Sum up the input array
        long arrSum = 0;
        for (int i : arr) arrSum += i;
        System.out.println(totalSum);
        System.out.println(arrSum);
    }

    /*
        j->   0 1 2  3 4 5
      i 0   0 0 0  0 0 0
        1   0 6 6  6
        2   0 6 10 10
        3   0 6 16

        weights = {1,2,3}
        vals = {6,10,12}
        W=5
     */
    public static int knapsack(int W, int[] weights, int[] vals) {
        int[][] cache = new int[weights.length+1][W+1];
        for (int i=1; i<=weights.length; i++) {
            for (int j=1; j<=W;j++) {
                if (weights[i-1] > j)
                    cache[i][j] = cache[i-1][j];
                else
                    cache[i][j] = Math.max(
                            cache[i-1][j], //16, cache[2][3-3] + 12
                            cache[i-1][j-weights[i-1]] + vals[i-1]);
            }
        }

        return cache[weights.length][W];
    }
}
