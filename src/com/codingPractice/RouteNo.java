package com.codingPractice;

public class RouteNo {
    public int routeNo(int m, int n, int s1, int s2, int e1, int e2) {
        if (e2 <= s2) return 0;
        int[][] dp = new int[m][e2 - s2 + 1];
        dp[s1][0] = 1;
        for (int j = 1; j < dp[0].length; j++){
            for (int i = 0; i < dp.length; i++) {
                dp[i][j] = (i - 1 >= 0 ? dp[i - 1][j - 1] : 0) + dp[i][j - 1] + (i + 1 < dp.length ? dp[i + 1][j - 1] : 0);
            }
        }
        return dp[e1][e2 - s2];
    }
}
