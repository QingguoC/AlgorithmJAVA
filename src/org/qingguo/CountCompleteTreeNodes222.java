package org.qingguo;

public class CountCompleteTreeNodes222 {
    // measure height and right tree height,
    // if  diff in 1, it means left tree is full: 2^rh + countNodes(root.right)
    // otherwise, right tree is full, 2^rh + countNodes(root.left)
    public int countNodes(TreeNode root){
        int h = height(root);
        if (h < 2){
            return h;
        }
        int rh = height(root.right);
        if (rh == h - 1){
            return (1 << rh)  + countNodes(root.right);
        }
        return (1 << rh) + countNodes(root.left) ;

    }
    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + height(root.left);
    }

}
