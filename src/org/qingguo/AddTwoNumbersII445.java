package org.qingguo;

import java.util.Stack;

public class AddTwoNumbersII445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null){
            stack1.add(p1.val);
            p1 = p1.next;
        }
        while (p2 != null){
            stack2.add(p2.val);
            p2 = p2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()){
                carry += stack1.pop();
            }
            if (!stack2.isEmpty()){
                carry += stack2.pop();
            }
            ListNode temp = new ListNode(carry % 10);
            temp.next = dummy.next;
            dummy.next = temp;
            carry /= 10;
        }
        if (carry != 0){
            ListNode temp = new ListNode(carry);
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }
}
