package com.codingPractice;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Parenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        if (n > 0) generateParenthesisCore("", n, n, result);
        return result;
    }

    private void generateParenthesisCore(String prefix, int left, int right, List<String> result) {
        if (left == 0 && right == 0) result.add(prefix);
        // Has left Parenthesis
        if (left > 0) generateParenthesisCore(prefix+'(', left-1, right, result);
        // has more right Parenthesis
        if (left < right) generateParenthesisCore(prefix+')', left, right-1, result);
    }

    public boolean isValidParenthesis(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')'){
                if (stack.pop() != '(')
                    return false;
            } else if (c == ']') {
                if (stack.pop() != '[') {
                    return false;
                }else if(c == '}') {
                    if (stack.pop() != '{')
                        return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
