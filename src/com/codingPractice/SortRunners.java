package com.codingPractice;

import java.util.ArrayList;
import java.util.List;

public class SortRunners {
    public int[] sortRunners(int[] runners) {
        int[] result = new int[runners.length];
        if (runners == null || runners.length == 0) return result;

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < runners.length; i++) {
            a.add(i, runners[i]);
            if (runners[i] == -1)
                result[0] = i;
        }


        int curr = result[0];

        for (int i = 1; i < runners.length; i++) {
            result[i] = a.indexOf(curr);
            curr = result[i];
        }

        return result;
    }
}
