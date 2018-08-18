package com.codingPractice;

import java.util.Arrays;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= -1 && nums[i] + 1 != nums[i + 1]) {
                return (nums[i] + 1 > 0 ? nums[i] + 1 : 1);
            }
        }
        return (nums[nums.length - 1] + 1 > 0 ? nums[nums.length - 1] + 1 : 1);
    }

}
