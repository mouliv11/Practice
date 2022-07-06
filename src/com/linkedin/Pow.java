package com.linkedin;

public class Pow {

    //O(log n)
    public double myPow(double x, int n) {
        if (n<0)
            return 1/helper(x, n);
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        double result = helper(x, n/2);
        if (n % 2 == 0)
            return result * result;
        return result * result * x;
    }

    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println(p.myPow(2, -2));
    }
}
