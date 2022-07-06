public class Fibo {

    private static int calcFibonacci(int n) {
        if (n < 2) return n;
        int[] cache = new int[n+1];
        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;
        return fib(n, cache);
    }

    private static int fib(int n, int[] cache) {
        if (cache[n] >= 0) return cache[n];
        return fib(n-1, cache) + fib(n-2, cache);
    }

    public static void main(String args[]) {
        System.out.println(calcFibonacci(80));
    }
}
