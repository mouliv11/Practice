public class Fibo2 {

    private static int calcFibonacci(int n) {
        if (n == 0) return 0;
        int[] cache = new int[n+1];
        cache[1] = 1;
        for (int i=2; i<=n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static void main(String args[]) {
        System.out.println(calcFibonacci(5));
    }
}
