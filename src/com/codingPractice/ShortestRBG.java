package com.codingPractice;

public class ShortestRBG {
    public String shortestRGB(String s) {
        char[] ch = s.toCharArray();
        String t = "0123456789abcdef";
        int distance = Integer.MAX_VALUE;
        String result = "";
        int a = t.indexOf(ch[1]) * 16 + t.indexOf(ch[2]);
        int b = t.indexOf(ch[3]) * 16 + t.indexOf(ch[4]);
        int c = t.indexOf(ch[5]) * 16 + t.indexOf(ch[6]);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                for (int k = 0; k < 16; k++) {
                    int d = (a - i * 16 - i) * (a - i * 16 - i) + (b - j * 16 - j) * (b - j * 16 - j) + (c - k * 16 - k) * (c - k * 16 - k);
                    if (d < distance) {
                        distance = d;
                        result = "#" + t.charAt(i) + t.charAt(j) + t.charAt(k);
                    }
                }
            }
        }

        return result;
    }

}
