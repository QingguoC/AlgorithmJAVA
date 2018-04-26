package org.qingguo;

public class LongestUnivaluePath {
    public int res = 0;
    public int longestUnivaluePath(TreeNode root){
        if (root == null){
            return 0;
        }
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        int count = 0;
        if (root == null || (root.left == null && root.right == null)){
            return count;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        if (root.left == null){
            if (root.val == root.right.val){
                count = right + 1;
                res = Math.max(res, count);
                return count;
            }
            return 0;

        }
        if (root.right == null){
            if (root.val == root.left.val){
                count = left + 1;
                res = Math.max(res, count);
                return count;
            }
            return 0;

        }


        if (root.val == root.left.val && root.val == root.right.val){
            res = Math.max(res, left + right + 2);
            return 1 + Math.max(right, left);
        }
        if (root.val == root.right.val){
            res = Math.max(res, right + 1);
            return 1 + right;
        }
        if (root.val == root.left.val){
            res = Math.max(res, 1 + left);
            return 1 + left;
        }
        return 0;
    }

}
