package org.qingguo;

// idea: A + B + nN = 2(A + B). A is from head to start of loop, B is start of loop to first meet, and N is loop.
// So nN - B = A which means slow pointer run another nN cycle minus B will meet anothe slow from head to start of loop.
public class LinkedListCycle142 {
    public ListNode detectCycle(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;

    }
}
