package com.codingPractice;

public class CarSpeed {
    public int carSpeed(int[] speed) {
        if (speed == null || speed.length == 0) return 0;
        if (speed.length == 1) return 1;

        int result = 1, i = 0;

        while (i < speed.length) {
            if (speed[i] < speed[i + 1 < speed.length ? i + 1 : speed.length - 1]) {
                result++;

            }
            i = i + 1;

        }
        return result;
    }
}
