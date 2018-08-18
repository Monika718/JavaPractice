package com.codingPractice;


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode removeElements(ListNode head, int val) {
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

    public boolean hasCycle(ListNode head) {
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
}
