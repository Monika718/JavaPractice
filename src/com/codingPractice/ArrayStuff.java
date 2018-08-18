package com.codingPractice;

public class ArrayStuff {
    public void rotate(int[] nums, int k) {

        if (k > nums.length)
            k = k - nums.length;

        int[] temp = new int[nums.length];
        for (int i = nums.length - k; i < nums.length; i++ ) {
            temp[i - nums.length + k] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            temp[i + k] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int start = -1, end = -2, min = nums[n - 1], max = nums[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);

            if (nums[i] < max) end = i;
            if (nums[n - 1 - i] > min) start = n - i - 1;
        }

        return end - start + 1;
    }

    public int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            max = Math.max(max, maxEndingHere);
        }
        return max;
    }

    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else if (count == 0) {
                major = nums[i];
            } else
                count--;
        }

        return major;
    }
}
