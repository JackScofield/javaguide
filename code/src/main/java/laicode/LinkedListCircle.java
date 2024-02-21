package laicode;

public class LinkedListCircle {
    static class LinkNode{
        int val;
        LinkNode next;
    }
    // 判断单链表是否有环
    public static boolean haveCircle(LinkNode head) {
        LinkNode slow = head;
        LinkNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // 判断环入口
    public static int entranceOfLoop(LinkNode head) {
        if(!haveCircle(head)) {
            throw new RuntimeException("该链表无环");
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                int count = 1;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }

    // 判断环大小
    public static int sizeOfLoop(LinkNode head){
        if(!haveCircle(head)) {
            throw new RuntimeException("该链表无环");
        }
        LinkNode slow = head;
        LinkNode fast = head;
        int count = 0;
        boolean flag = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                if(count!=0) return count;
            }
            if(flag) count++;
        }
        return 0;
    }



}
