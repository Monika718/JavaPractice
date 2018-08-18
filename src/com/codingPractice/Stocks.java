package com.codingPractice;

public class Stocks {
    public int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;


        int sofarmin = prices[0];
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < sofarmin) {
                sofarmin = prices[i];
            } else {
                max = Math.max(max, prices[i] - sofarmin);
            }
        }

        return max;
    }
}
