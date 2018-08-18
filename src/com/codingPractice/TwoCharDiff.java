package com.codingPractice;

public class TwoCharDiff {
    public boolean twoCharacterDiff(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int m = 0, count = 0;
        for (int i = 0; i < s1.length(); i++) {
            m = m ^ (c1[i] - 'a') ^ (c2[i] - 'a');
            if (c1[i] != c2[i]) {
                count++;
            }
        }

        if (m == 0 && count == 2) {
            return true;
        }
        else
            return false;
    }
}
