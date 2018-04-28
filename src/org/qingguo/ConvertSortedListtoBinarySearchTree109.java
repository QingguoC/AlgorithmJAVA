package org.qingguo;

public class ConvertSortedListtoBinarySearchTree109 {
    public TreeNode sortedListToBST(ListNode head){
        if (head == null){
            return null;
        }
        if (head.next == null){
            return new TreeNode(head.val);
        }
        ListNode mid,fast;
        mid = head;
        fast = head.next;
        while (fast.next != null && fast.next.next != null){
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(mid.next.val);
        root.right = sortedListToBST(mid.next.next);
        mid.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
