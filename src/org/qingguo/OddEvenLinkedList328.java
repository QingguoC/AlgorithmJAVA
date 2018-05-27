package org.qingguo;

public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h2 = head.next;
        ListNode p1 = head;
        ListNode p2 = h2;
        while (p2 != null){
            p1.next = p2.next;
            if (p1.next == null) break;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = h2;
        return head;
    }
}
