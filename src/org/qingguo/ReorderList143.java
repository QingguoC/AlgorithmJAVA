package org.qingguo;
// find premiddle, reverse the min right half , and merge two.
public class ReorderList143 {
    public void reorderList(ListNode head){
        if (head == null || head.next == null){
            return;
        }
        ListNode preMiddle, fast;
        preMiddle = fast = head;
        while (fast.next != null && fast.next.next != null){
            preMiddle = preMiddle.next;
            fast = fast.next.next;
        }
        ListNode middle = preMiddle.next;

        ListNode p2 = null;
        while (middle.next != null){
            p2 = preMiddle.next;
            preMiddle.next = middle.next;
            middle.next = preMiddle.next.next;
            preMiddle.next.next = p2;
        }
        p2 = preMiddle.next;
        ListNode p1 = head;
        while (p1 != preMiddle){
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }
}
