package org.qingguo;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode p = root;
        while (p != null){
            stack.add(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int res = curr.val;
        TreeNode p = curr.right;
        while (p != null){
            stack.add(p);
            p = p.left;
        }

        return res;
    }
}
