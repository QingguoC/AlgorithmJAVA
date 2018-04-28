package org.qingguo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while (stack.size() != 0){
            root = stack.pop();
            if (root.left == null && root.right == null){
                res.add(root.val);
            } else {
                stack.add(root);
                if (root.right != null){
                    stack.add(root.right);
                }
                if (root.left != null){
                    stack.add(root.left);
                }
                // key point
                root.right = null;
                root.left = null;
            }
        }
        return res;
    }
}
