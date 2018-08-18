package com.codingPractice;

import java.util.HashMap;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);

            if (s2t.containsKey(cS)) {
                if (!s2t.get(cS).equals(cT) || !t2s.get(cT).equals(cS)) {
                    return false;
                }
            } else {
                if (t2s.containsKey(cT)) {
                    return false;
                }
                s2t.put(cS, cT);
                t2s.put(cT, cS);
            }
        }
        return true;
    }
}
