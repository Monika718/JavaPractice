package com.codingPractice;

import java.util.*;

public class Main {

    public static boolean isPalindrome(int x) {
        char[] c = Integer.toString(x).toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - i - 1]) {
                return false;
            }
        }
        return true;
    }



    public static int fibonacci(int n) {
        if (n < 2) {
            return 0;
        } else {
            int[] fib = new int[n];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[n - 1];
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        // write your code here
        ListNode helper = new ListNode(0);
        helper.next = head;
        int a = helper.val;
        ListNode p = helper;
        int[] b = {p.val, p.next.val};

        while(p.next != null){
            if(p.next.val == val){
                ListNode next = p.next;
                p.next = next.next;
                int c = p.val;
            }else{
                p = p.next;
                int d = p.val;
            }
        }

        return helper.next;
    }

    public static boolean Permutation(String A, String B) {
        // write your code here
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



    public static void rotate(int[] nums, int k) {

        if (k > nums.length)
            k = k - nums.length;

        int[] temp = new int[nums.length];
        for (int i = nums.length - k; i < nums.length; i++ ) {
            temp[i - nums.length + k] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            temp[i + k] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= -1 && nums[i] + 1 != nums[i + 1]) {
                return (nums[i] + 1 > 0 ? nums[i] + 1 : 1);
            }
        }
        return (nums[nums.length - 1] + 1 > 0 ? nums[nums.length - 1] + 1 : 1);
    }

    public static boolean isValid(String s) {
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

    public static int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            max = Math.max(max, maxEndingHere);
        }
        return max;
    }

    public static int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;


        int sofarmin = prices[0];
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < sofarmin) {
                sofarmin = prices[i];
            } else {
                max = Math.max(max, prices[i] - sofarmin);
            }
        }

        return max;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;

        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) return true;
        }

        return false;
    }

    public static int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else if (count == 0) {
                major = nums[i];
            } else
                count--;
        }

        return major;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
    }

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int start = -1, end = -2, min = nums[n - 1], max = nums[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);

            if (nums[i] < max) end = i;
            if (nums[n - 1 - i] > min) start = n - i - 1;
        }

        return end - start + 1;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;
        for (char c : p.toCharArray())
            chars[c-'a']++;

        int start = 0, end = 0, count = p.length();
        // Go over the string
        while (end < s.length()) {
            // If the char at start appeared in p, we increase count
            if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0)
                count++;
            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if (--chars[s.charAt(end++)-'a'] >= 0)
                count--;
            if (count == 0)
                result.add(start);
        }

        return result;
    }

    public static List<List<Integer>> permute(int[] num) {
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

    public static int[] countBits(int num) {
        int[] a = new int[num + 1];
        a[0] = 0;
        int p = 1;
        for (int i = 1; i <= num; i++) {
            if (i == p * 2) {
                p = p * 2;
                a[i] = 1 + a[i - p];
            }
        }
        return a;
    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }

        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        if (n > 0) generateParenthesisCore("", n, n, result);
        return result;
    }

    private static void generateParenthesisCore(String prefix, int left, int right, List<String> result) {
        if (left == 0 && right == 0) result.add(prefix);
        // Has left Parenthesis
        if (left > 0) generateParenthesisCore(prefix+'(', left-1, right, result);
        // has more right Parenthesis
        if (left < right) generateParenthesisCore(prefix+')', left, right-1, result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || (board.length == 0 && board[0].length == 0)) return;

        int n = board[0].length, m = board.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int l = lives(board, m, n, i, j);

                 if (board[i][j] == 1 && (l < 2 || l > 3)) {
                     board[i][j] = 2;
                 } else {
                     if (board[i][j] == 0 && l == 3) {
                         board[i][j] = 3;
                     }
                 }


            }
        }

         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (board[i][j] == 2) {
                     board[i][j] = 0;
                 } else {
                     if (board[i][j] == 3) {
                         board[i][j] = 1;
                     }
                 }
             }
         }

    }

    private static int lives(int[][] board, int m, int n, int i, int j) {
        int l = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                if (board[x][y] == 1 || board[x][y] == 2) {
                    l++;
                }
            }
        }
        if (board[i][j] == 1 || board[i][j] == 2) l--;
        return l;

    }

    public static boolean nStraight (int[] nums, int n) {
        if (nums == null || nums.length == 0 || nums.length % n != 0) return false;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length / n; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i + j] != nums[i] + j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int carSpeed(int[] speed) {
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

    public static char missingChar(String s1, String s2) {
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

    public static List<Integer> randomPointRectangle(int x1, int x2, int y1, int y2) {
        Random rand = new Random();
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);

        int i = rand.nextInt(x) + (x1 > x2 ? x2 : x1);
        int j = rand.nextInt(y) + (y1 > y2 ? y2 : y1);

        List<Integer> result = new ArrayList();
        result.add(i);
        result.add(j);
        return result;
    }





    public static int routeNo(int m, int n, int s1, int s2, int e1, int e2) {
        if (e2 <= s2) return 0;
        int[][] dp = new int[m][e2 - s2 + 1];
        dp[s1][0] = 1;
        for (int j = 1; j < dp[0].length; j++){
            for (int i = 0; i < dp.length; i++) {
                dp[i][j] = (i - 1 >= 0 ? dp[i - 1][j - 1] : 0) + dp[i][j - 1] + (i + 1 < dp.length ? dp[i + 1][j - 1] : 0);
            }
        }
        return dp[e1][e2 - s2];
    }

    public static double getProfit(int year, int base) {
        double result = base * 1.07;
        for (int i = 1; i < 10; i++) {
            result = ( result + 5000 ) * 1.07;
        }

        for (int i = 10; i <= year; i++) {
            result *= 1.07;
        }

        return result;
    }






    public static void main(String[] args) {
    }
}