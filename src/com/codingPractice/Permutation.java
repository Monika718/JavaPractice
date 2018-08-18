package com.codingPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public boolean Permutation(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        if (a.length != b.length) {
            return false;
        } else {
            Arrays.sort(a);
            Arrays.sort(b);
            if (a == b)
                return true;
            else
                return false;
        }
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j<=i; ++j){
                for (List<Integer> l : ans){
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j,num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }

}
