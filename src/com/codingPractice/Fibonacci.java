package com.codingPractice;

public class Fibonacci {
    public int fibonacci(int n) {
        if (n < 2) {
            return 0;
        } else {
            int[] fib = new int[n];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[n - 1];
        }
    }
}
