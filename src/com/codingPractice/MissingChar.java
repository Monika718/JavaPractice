package com.codingPractice;

public class MissingChar {
    public char missingChar(String s1, String s2) {
        int[] count = new int[26];
        for (char c1 : s1.toCharArray()) {
            count[c1 - 'a']++;
        }
        for (char c2 : s2.toCharArray()) {
            count[c2 - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return (char)(i + 'a');
        }
        return 'a';
    }
}
