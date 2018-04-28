package org.qingguo;

public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = helper(nums,0,nums.length-1);
        return root;

    }
    public TreeNode helper(int[] nums, int st, int ed){
        if (st > ed){
            return null;
        }
        if (st == ed){
            return new TreeNode(nums[st]);
        }
        int mid = (st + ed)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,st,mid-1);
        root.right = helper(nums,mid+1,ed);
        return root;
    }
}
