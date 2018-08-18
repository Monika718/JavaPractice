package com.codingPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoveAToB {
    public int[] moveAToB(int[][] a, int[][] b) {
        int[] result = new int[2];

        HashMap<List<Integer>, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int x = b[j][0] - a[i][0];
                int y = b[j][1] - a[i][1];
                List<Integer> l = new ArrayList<>();
                l.add(x); l.add(y);
                m.put(l, m.getOrDefault(l, 0) + 1);
            }
        }

        List<Integer> values = new ArrayList<>(m.values());
        values.sort((j, k) -> {return k - j;});

        int max = values.get(0);

        for (List<Integer> l : m.keySet()) {
            if (m.get(l) == max) {
                result[0] = l.get(0);
                result[1] = l.get(1);
                break;
            }
        }

        return result;

    }
}
