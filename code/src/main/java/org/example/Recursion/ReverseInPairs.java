package org.example.Recursion;

public class ReverseInPairs {
    // iterative
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            ListNode next = cur.next.next;
            cur.next.next = cur.next.next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    // recursion
    public static ListNode reverseInPairsRecursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = reverseInPairsRecursion(head.next.next);
        newHead.next = head;
        return newHead;
    }
}
