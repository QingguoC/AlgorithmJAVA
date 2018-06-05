package org.qingguo;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) return null;
        Map<Integer, Integer> mapI = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            mapI.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length - 1, inorder, 0, inorder.length - 1, mapI);
    }
    private TreeNode helper(int[] preorder,int stP, int edP, int[] inorder, int stI, int edI, Map<Integer, Integer> mapI){
        if(stP > edP || stI > edI) return null;
        TreeNode root = new TreeNode(preorder[stP]);
        if (stP == edP) return root;
        int iRoot = mapI.get(root.val);
        root.left = helper(preorder,stP + 1,stP + iRoot - stI, inorder,stI,iRoot - 1, mapI);
        root.right = helper(preorder,stP + iRoot - stI + 1,edP, inorder,iRoot + 1,edI, mapI);
        return root;
    }
}
