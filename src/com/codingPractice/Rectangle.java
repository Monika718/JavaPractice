package com.codingPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rectangle {
    public boolean isInRectangles(int x, int y, int[][] rectangles) {
        for (int i = 0; i < rectangles.length; i++) {
            if (x >= rectangles[i][0] && x <= rectangles[i][1] && y >= rectangles[i][2] && y <= rectangles[i][3]) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> randomPointRectangles(int[][] rectangles) {
        int maxL = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE, maxT = Integer.MIN_VALUE, maxB = Integer.MAX_VALUE;
        for (int i = 0; i < rectangles.length; i++) {
            maxL = Math.min(maxL, rectangles[i][0]);
            maxR = Math.max(maxR, rectangles[i][1]);
            maxT = Math.max(maxT, rectangles[i][3]);
            maxB = Math.min(maxB, rectangles[i][2]);
        }
        List<Integer> result = new ArrayList<>();
        Random rand = new Random();
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        while(!isInRectangles(x, y, rectangles)) {
            x = maxL + rand.nextInt(maxR - maxL);
            y = maxB + rand.nextInt(maxT - maxB);
        }
        result.add(x);
        result.add(y);
        return result;
    }

    public static List<Integer> randomPointRectangle(int x1, int x2, int y1, int y2) {
        Random rand = new Random();
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        int i = rand.nextInt(x) + (x1 > x2 ? x2 : x1);
        int j = rand.nextInt(y) + (y1 > y2 ? y2 : y1);
        List<Integer> result = new ArrayList<>();
        result.add(i);
        result.add(j);
        return result;
    }
}
