package org.qingguo;

public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode f = head;
        ListNode s = head;
        int i = 0;
        while (f.next != null && i < k){
            f = f.next;
            i++;
        }
        if (i < k){
            k = k % (i + 1);
            f = head;
            i = 0;
            while ( i < k){
                f = f.next;
                i++;
            }

        }

        while (f.next != null){
            f = f.next;
            s = s.next;
        }
        f.next = head;

        head = s.next;
        s.next = null;
        return head;
    }
}
