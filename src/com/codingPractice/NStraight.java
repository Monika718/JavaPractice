package com.codingPractice;

import java.util.Arrays;

public class NStraight {
    public boolean nStraight (int[] nums, int n) {
        if (nums == null || nums.length == 0 || nums.length % n != 0) return false;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length / n; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i + j] != nums[i] + j) {
                    return false;
                }
            }
        }
        return true;
    }
}
