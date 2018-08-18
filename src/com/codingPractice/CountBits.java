package com.codingPractice;

public class CountBits {
    public int[] countBits(int num) {
        int[] a = new int[num + 1];
        a[0] = 0;
        int p = 1;
        for (int i = 1; i <= num; i++) {
            if (i == p * 2) {
                p = p * 2;
                a[i] = 1 + a[i - p];
            }
        }
        return a;
    }
}
