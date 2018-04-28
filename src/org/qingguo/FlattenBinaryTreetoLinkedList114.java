package org.qingguo;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList114 {
    public void flatten(TreeNode root){
        if (root == null ){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        TreeNode dummy = new TreeNode(0);

        TreeNode prev = dummy;
        TreeNode temp = null;
        while (stack.size() != 0){
            temp = stack.pop();
            if (temp.right != null){
                stack.add(temp.right);
            }
            if (temp.left != null){
                stack.add(temp.left);
            }
            prev.right = temp;
            prev = prev.right;
            temp.right = null;
            temp.left = null;
        }
        return;
    }

}
